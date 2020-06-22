package com.example.mb_demo.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("I am filter!");
        HttpServletRequest httpServletRequest= (HttpServletRequest) servletRequest;
        String requestURI = httpServletRequest.getRequestURI();
        String remoteAddr = httpServletRequest.getRemoteAddr();
        System.out.println(requestURI+"\t"+remoteAddr);
        filterChain.doFilter(httpServletRequest,servletResponse);
    }
}
