package com.Servlet.Filter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String gender = req.getParameter("gender");
        String Birthdate = req.getParameter("Birthdate");


        PrintWriter writer = resp.getWriter();
        writer.println("<br> username: " + username);
        writer.println("<br> password: " + password);
        writer.println("<br> email: " + email);
        writer.println("<br> gender: " + gender);
        writer.println("<br> Birthdate: " + Birthdate);
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
