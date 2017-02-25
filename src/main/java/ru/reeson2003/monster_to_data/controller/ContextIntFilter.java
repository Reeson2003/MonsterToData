package ru.reeson2003.monster_to_data.controller;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by reeson on 24.02.17.
 */
public class ContextIntFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        Object springContext = filterConfig.getServletContext().getAttribute("springContext");
        if(springContext == null) {
            springContext = new ClassPathXmlApplicationContext("spring_config/beans.xml");
            filterConfig.getServletContext().setAttribute("springContext", springContext);
        }
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {

    }
}
