package com.FanXuyang.controller;

import com.FanXuyang.dao.ProductDao;
import com.FanXuyang.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;

@WebServlet(name = "GetImgServlet", value = "/getImg")
public class GetImgServlet extends HttpServlet {
    private Connection con = null;
    @Override
    public void init() throws ServletException {
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDao productDao = new ProductDao();
        int id = 0;
        if(request.getParameter("id") != null) {
            id= Integer.parseInt(request.getParameter("id"));
        }
        try {
            byte[] imgByte = new byte[0];
            imgByte = productDao.getPictureById(id, con);
            if(imgByte != null) {
                response.setContentType("image/gif");
                OutputStream os = response.getOutputStream();
                os.write(imgByte);
                os.flush();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
