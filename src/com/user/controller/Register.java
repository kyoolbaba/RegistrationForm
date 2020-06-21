package com.user.controller;

import com.user.dao.UserDao;
import com.user.model.User;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

public class Register extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws  IOException {
        User user =new User();
        PrintWriter out=res.getWriter();
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        user.setContactNo(req.getParameter("contactno"));
        user.setFirstName(req.getParameter("fname"));
        user.setLastName(req.getParameter("lname"));
        user.setEmail(req.getParameter("email"));
        out.println("<h1>UserName :"+req.getParameter("username")+"</h1>");
        out.println("<h1>Password :"+req.getParameter("password")+"</h1>");
        out.println("<h1>ContactNo :"+req.getParameter("contactno")+"</h1>");
        out.println("<h1>FirstName :"+req.getParameter("fname")+"</h1>");
        out.println("<h1>LastName :"+req.getParameter("lname")+"</h1>");
        out.println("<h1>Email :"+req.getParameter("email")+"</h1>");
        UserDao userDao=new UserDao();
        userDao.registerUser(user);
    }
}
