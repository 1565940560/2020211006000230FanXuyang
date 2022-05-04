package com.FanXuyang.week5;

import com.FanXuyang.dao.UserDao;
import com.FanXuyang.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    Connection con = null;
    @Override
    public void init() throws ServletException {
        super.init();
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/views/Login.jsp").forward(req,resp);
//        String id = req.getParameter("ID");
//        String password = req.getParameter("password");
//        String sql = "select * from user where ID =" + id + ";";
//
//        System.out.println(sql);
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        try {
//            ps = con.prepareStatement(sql);
//            rs = ps.executeQuery();
//            boolean ok = false;
//            while (rs.next()) {
//                String t = rs.getString("password");
//                String name = rs.getString("name");
//                if(t.equals(password)) {
////                    PrintWriter writer = resp.getWriter();
////                    writer.println("<h1>Login success!!!</h1>");
////                    writer.println("<p>Welcome " + name + "</p>");
////                    ok = true;
//                    req.setAttribute("id", rs.getString("id"));
//                    req.setAttribute("name", rs.getString("name"));
//                    req.setAttribute("password", rs.getString("password"));
//                    req.setAttribute("email", rs.getString("email"));
//                    req.setAttribute("gender", rs.getString("gender"));
//                    req.setAttribute("birthdate", rs.getString("birthdate"));
//                    req.getRequestDispatcher("usrInfo.jsp").forward(req,resp);
//                    ok = true;
//                } else {
//                    System.out.println("Fail Login!!!");
//                    req.setAttribute("messsage", "ID or password Error !!! ");
//                    req.getRequestDispatcher("Login.jsp").forward(req, resp);
////                    PrintWriter writer = resp.getWriter();
////                    writer.println("<h1>Error success!!!</h1>");
////                    writer.println("<p>Please Try again</P>");
//                }
//            }
//            if(!ok) {
////                PrintWriter writer = resp.getWriter();
////                writer.println("<h1>Error success!!!</h1>");
////                writer.println("<p>Please Try again</P>");
//                System.out.println("Fail Login!!!");
//                req.setAttribute("message", "ID or password Error !!! ");
//                req.getRequestDispatcher("Login.jsp").forward(req, resp);
//            }
//
//        } catch (SQLException e) {
//            System.out.println(e);
//        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doGet(req, resp);
        PrintWriter writer = resp.getWriter();
        String name = req.getParameter("username");
        String password = req.getParameter("password");
//        System.out.println(name + '\n' + password);
//        System.out.println(con);
        UserDao userdao = new UserDao();
        try {
            User user = userdao.findByUsernamePassword(con, name, password);
            if (user != null) {
                if(req.getParameter("rememberMe") != null && req.getParameter("rememberMe").equals("1")) {
                    Cookie usernameCookie = new Cookie("cUsername", user.getName());
                    Cookie passwordCookie = new Cookie("cpassword", user.getPassword());
                    Cookie rememberMeCookie = new Cookie("crememberMe", req.getParameter("rememberMe"));
                    usernameCookie.setMaxAge(20);
                    passwordCookie.setMaxAge(20);
                    rememberMeCookie.setMaxAge(20);
                    resp.addCookie(usernameCookie);
                    resp.addCookie(passwordCookie);
                    resp.addCookie(rememberMeCookie);
                }
                // 创建一个session
                HttpSession session = req.getSession();
                System.out.println("session id -> " + session.getId());
                session.setMaxInactiveInterval(3600);
                session.setAttribute("user", user);
                req.getRequestDispatcher("WEB-INF/views/usrInfo.jsp").forward(req, resp);
            } else {
                req.setAttribute("message", "Username or password is Error !!!");
                System.out.println(req.getContextPath() + "/WEB-INF/views/Login.jsp");
                req.getRequestDispatcher("WEB-INF/views/Login.jsp").forward(req, resp);

            }
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
