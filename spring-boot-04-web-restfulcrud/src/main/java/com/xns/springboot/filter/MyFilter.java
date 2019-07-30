package com.xns.springboot.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Classname MyFilter
 * @Description TODO
 * @Date 19-7-30 上午9:11
 * @Created by xns
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("MyFilter process...");
        chain.doFilter(request,response);
    }
}
