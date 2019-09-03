package com.filter;

import com.config.SystemConfig;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @autor sunyiban
 * @date 2019/9/2 9:59
 * @descrpition
 */
// filter 配置方式1
//@WebFilter(filterName = "signFilter", urlPatterns = "/*")
public class SignFilter implements Filter {

    @Autowired
    private SystemConfig systemConfig;

    public SignFilter(SystemConfig systemConfig) {
        this.systemConfig = systemConfig;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter doFilter");
        System.out.println(systemConfig.toString());
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        System.out.println(request.getRequestURI());

        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        PrintWriter pw = response.getWriter();
//        pw.write("this is over");

        filterChain.doFilter(servletRequest, response);
    }

    @Override
    public void destroy() {
        System.out.println("filter destroy");
    }
}
