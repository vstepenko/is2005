package ua.edu.duan.is2005.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import org.apache.catalina.connector.RequestFacade;

import java.io.IOException;

public class StudentFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

      /*  if(!"true".equals(((RequestFacade) servletRequest).getHeader("demo-mode"))  ){
            throw new ServletException("demo-mode not set");
        }*/
        System.out.println("StudentFilter");

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
