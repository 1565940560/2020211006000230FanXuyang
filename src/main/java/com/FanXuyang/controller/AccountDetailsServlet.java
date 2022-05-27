package com.FanXuyang.controller;

import com.FanXuyang.dao.OrderDao;
import com.FanXuyang.dao.UserDao;
import com.FanXuyang.model.Order;
import com.FanXuyang.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AccountDetailsServlet", value = "/accountDetails")
public class AccountDetailsServlet extends HttpServlet {

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
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            String id = user.getID();
            UserDao userDao = new UserDao();
            try {
                user = userDao.findById(con, id);
                request.setAttribute("user", user);
                OrderDao orderDao = new OrderDao();
                List<Order> orderList = orderDao.findByUserId(con, id);
                request.setAttribute("orderList", orderList);
                request.getRequestDispatcher("/WEB-INF/views/accountDetails.jsp").forward(request,response);
            } catch (SQLException e) {
                System.out.println(e);
            }
        } else {
            response.sendRedirect("login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
