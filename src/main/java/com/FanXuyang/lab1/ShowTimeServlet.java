package com.FanXuyang.lab1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ShowTimeServlet", value = "/show")
public class ShowTimeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer count = (Integer) getServletContext().getAttribute("count");
        if(count == null) {
            count = new Integer(1);
        } else {
            count = new Integer(count.intValue() + 1);
        }
        PrintWriter writer = response.getWriter();
        writer.println("<h1>since loading, this servlet has benn accessed " + count + "times</h1>");
        getServletContext().setAttribute("count", count);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
