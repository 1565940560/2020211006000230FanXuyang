package com.FanXuyang.controller;

import com.FanXuyang.dao.CategoryDao;
import com.FanXuyang.dao.ProductDao;
import com.FanXuyang.model.Category;
import com.FanXuyang.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AddProductServlet", value = "/admin/addProduct")
@MultipartConfig(maxFileSize = 16177215)
public class AddProductServlet extends HttpServlet {
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
        CategoryDao categoryDao = new CategoryDao();
        try {
            List<Category> categoryList = categoryDao.findAllCategory(con);
            request.setAttribute("categoryList", categoryList);
            request.getRequestDispatcher("/WEB-INF/views/admin/addProduct.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productName = request.getParameter("productName");
        Double price = request.getParameter("price") != null ? Double.parseDouble(request.getParameter("price")) : 0.0;
        int categoryId = request.getParameter("categoryId") != null ? Integer.parseInt(request.getParameter("categoryId")) : 0;
        String productDescription = request.getParameter("productDescription");
        InputStream inputStream = null;
        Part filePart = request.getPart("picture");
        if(filePart != null) {
            System.out.println("file name : " + filePart.getName() + " size " + filePart.getSize() + " file type " + filePart.getContentType());
            inputStream = filePart.getInputStream();
        }
        Product product = new Product();
        product.setProductName(productName); product.setPrice(price);product.setProductDescription(productDescription); product.setCategoryId(categoryId);
        product.setPicture(inputStream);
        ProductDao dao = new ProductDao();
        int i = 0 ;

        try {
            i = dao.save(product,  con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(i);
        if(i > 0) {
            response.sendRedirect(request.getContextPath() + "/ok.jsp");
        }
//        else {
//            response.sendRedirect(request.getContextPath()+"/fail.jsp");
//        }
    }
}
