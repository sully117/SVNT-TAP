package com.javaxiaodi.springapi.filter;

import org.slf4j.LoggerFactory;
import javax.servlet.*;
import java.io.IOException;

/**
 * @author: Xiaodi Tao
 * @className: MyFilter
 * @packageName: filter
 * @description: This is the filter
 * @data: 2019-10-25
 **/
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    // Filter for servlet
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        org.slf4j.Logger Logger = LoggerFactory.getLogger(MyFilter.class);
        Logger.info("MyFilter process...");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
    }
}