package com.FanXuyang.week2;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorldServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //        当客户端请求方式是GET

        PrintWriter writer = response.getWriter();
        writer.println("Nickname: FanXuyang");
        writer.println("ID: 2020211001001113");
        writer.println("Date and Time: 2022-03-07 19:13");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        //        当客户端请求方式是Post
    }
}
