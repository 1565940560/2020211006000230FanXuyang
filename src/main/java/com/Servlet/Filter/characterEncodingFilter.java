package com.Servlet.Filter;

import javax.servlet.*;
import java.io.IOException;

public class characterEncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        System.out.println("characterEncodingFilter初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html; charset=UTF-8");
//        System.out.println("characterEncodingFilter执行前......\n");
        filterChain.doFilter(servletRequest, servletResponse);
//        System.out.println("characterEncodingFilter执行后......\n");
    }

    @Override
    public void destroy() {
//        System.out.println("characterEncodingFilter销毁");
    }
}
