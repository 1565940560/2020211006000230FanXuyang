package com.FanXuyang.lab1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MyDearServlet", value = "/MyDearServletURL")
public class MyDearServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/lab1/Myjsp.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String name = request.getParameter("name");
//        String Class = request.getParameter("Class");
//        String ID = request.getParameter("ID");
//        PrintWriter writer = response.getWriter();
//        writer.println("<html>\n" +
//                "<head>\n" +
//                "    <title> Using Servlet </title>\n" +
//                "</head>\n" +
//                "<body>");
//        writer.println("<p> name:" + name);
//        writer.println("<p> class:" + Class);
//        writer.println("<p> ID: " + ID);
//        writer.println("</body>\n" +
//                "</html>");
//        writer.close();
        request.getRequestDispatcher("WEB-INF/lab1/MyDearJsp.jsp").forward(request,response);
    }

}
