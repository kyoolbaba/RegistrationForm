package com.user.controller;

import com.user.dao.UserDao;
import com.user.model.User;

import javax.servlet.RequestDispatcher;
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
        user.setPassword(req.getParameter("pass"));
        user.setContactNo(req.getParameter("contactno"));
        user.setFirstName(req.getParameter("fname"));
        user.setLastName(req.getParameter("lname"));
        user.setEmail(req.getParameter("email"));
        try {
            UserDao userDao=new UserDao();
            boolean registered=userDao.registerUser(user);
            if(registered){
                out.println("<p class='successmessage'>You Have sucessfully registered</p>");
                RequestDispatcher requestDispatcher=req.getRequestDispatcher("/index.jsp");
                requestDispatcher.include(req, res);
            }else{
                out.println("<p class='successmessage'>UserName Already Used</p>");
                RequestDispatcher requestDispatcher=req.getRequestDispatcher("/Register.jsp");
                requestDispatcher.include(req, res);
            }
        } catch (ClassNotFoundException | ServletException e) {
            e.printStackTrace();
        }

    }
}
