package com.FanXuyang.week3;

import com.FanXuyang.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

public class register extends HttpServlet {
    Connection con = null;
    @Override
    public void init() throws ServletException {
        super.init();
//        String driver = getServletContext().getInitParameter("driver");
//        String url = getServletContext().getInitParameter("url");
//        String usr = getServletContext().getInitParameter("usr");
//        String password = getServletContext().getInitParameter("password");
//        try {
//            Class.forName(driver);
//            con = DriverManager.getConnection(url, usr, password);
//            System.out.println("连接成功");
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
        con = (Connection) getServletContext().getAttribute("con");
        if(con == null) {
            System.out.println("wochao");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/views/register.jsp").forward(req, resp);
//        resp.sendRedirect("Login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("username");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String gender = req.getParameter("gender");
        String Birthdate = req.getParameter("birthdate");
        String sql = "insert into user values ('" + id + "', '" + username + "', '" + password + "', '" +
                email + "', '" + gender + "', '" + Birthdate + "');";
        System.out.println(sql);
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("插入成功");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        ArrayList<User> list = new ArrayList<User>();
        User x = new User();

        try {
            ps = con.prepareStatement("select  * from user");
            ResultSet rs = null;
            rs = ps.executeQuery();
            while (rs.next()) {
                x = new User();
                x.setID(rs.getString("ID"));
                x.setName(rs.getString("name"));
                x.setPassword(rs.getString("password"));
                x.setEmail(rs.getString("Email"));
                x.setGender(rs.getString("Gender"));
                x.setBirthdate(rs.getString("Birthdate"));
                list.add(x);
            }
            PrintWriter writer = resp.getWriter();
            writer.println("<table border=\"1\">  <tr> <th>ID</th> <th>name</th> <th>password</th> <th>Email</th> <th>Gender</th> <th>Birthdate</th> </tr>");
            for (User ur: list) {
                writer.println("<tr>");
                writer.println("<td>" + ur.getID() + "</td>"
                        + "<td>" + ur.getName() + "</td>"
                        + "<td>" + ur.getPassword() + "</td>"
                        + "<td>" + ur.getEmail() + "</td>"
                        + "<td>" + ur.getGender() + "</td>"
                        + "<td>" + ur.getBirthdate() + "</td>");
                writer.println("</tr>");
            }
            writer.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
