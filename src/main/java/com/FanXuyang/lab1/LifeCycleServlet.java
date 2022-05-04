package com.FanXuyang.lab1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LifeCycleServlet", value = "/life")
public class LifeCycleServlet extends HttpServlet {

    public LifeCycleServlet() {
        System.out.println("[debug] === I Am from default constructor");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("[debug] === start init()");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("[debug] === start service");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("[debug] === start destroy()");
    }
}
