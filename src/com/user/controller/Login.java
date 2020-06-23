package com.user.controller;

import com.user.dao.UserDao;
import com.user.model.User;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Login extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws  IOException {
        PrintWriter out=res.getWriter();
//         out.println("<h1>UserName :"+req.getParameter("username")+"</h1>");
//        out.println("<h1>Password :"+req.getParameter("pass")+"</h1>");
        User user= new User();
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("pass"));
        try {
            UserDao userDao=new UserDao();
            boolean login=userDao.validateUser(user);
           if(login){
               HttpSession httpSession=req.getSession();
               httpSession.setAttribute("username",user.getUsername());
               httpSession.setAttribute("pass",user.getPassword());
               RequestDispatcher rd=req.getRequestDispatcher("ProFilePage.jsp");
               rd.include(req, res);
           }else{
               out.println("<p class='successmessage'>InCorrect Password and Username try Again with Correct Credentials</p>");
               RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
               rd.include(req, res);
           }
        } catch (SQLException | ClassNotFoundException | ServletException throwables) {
            throwables.printStackTrace();
        }
    }
}
