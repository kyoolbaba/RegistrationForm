package com.user;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        PrintWriter out=servletResponse.getWriter();
        Matcher matcher;
        boolean validate=false;
        String VALIDATE_EMAIL="^(.+)@(.+)$";
        Pattern pattern=Pattern.compile(VALIDATE_EMAIL);
        matcher=pattern.matcher(servletRequest.getParameter("email"));
        validate=matcher.matches();
        if(validate){
            System.out.println("Filter transfered control to next source");
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            System.out.println("Redirecting to Register page");
            out.println("<p class='successmessage'>InValid Email Enter correct email</p>");
            RequestDispatcher requestDispatcher=servletRequest.getRequestDispatcher("Register.jsp");
            requestDispatcher.include(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
