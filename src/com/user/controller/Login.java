package com.user.controller;

import com.user.model.User;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

public class Login extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
            User user =new User();
        PrintWriter out=res.getWriter();
         out.println("<h1>UserName"+req.getParameter("username")+"</h1>");
        out.println("<h1>Password "+req.getParameter("password")+"</h1>");

    }
}
