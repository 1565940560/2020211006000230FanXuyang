package com.FanXuyang.controller;

import com.FanXuyang.dao.OrderDao;
import com.FanXuyang.model.Order;
import com.FanXuyang.model.Payment;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(name = "AdminOrderListServlet", value = "/admin/orderList")
public class AdminOrderListServlet extends HttpServlet {

    private Connection con = null;

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        super.init();
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Payment> allPayment = Payment.findAllPayment(con);
        for (Payment payment : allPayment) {
            System.out.println(payment);
        }
        request.setAttribute("paymentTypeList", allPayment);
        OrderDao orderDao = new OrderDao();
        List<Order> all = orderDao.findAll(con);
        for (Order order : all) {
            System.out.println(order);
        }
        request.setAttribute("orderList", all);
        request.getRequestDispatcher("/WEB-INF/views/admin/orderList.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
