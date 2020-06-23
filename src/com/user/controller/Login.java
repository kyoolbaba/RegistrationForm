package com.user.controller;

import com.user.dao.UserDao;
import com.user.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Login extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws  IOException {
        PrintWriter out=res.getWriter();
        User user= new User();
        //If you use the below parameter in some other servlet or jsp then this is URL Rewriting
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("pass"));
        try {
            UserDao userDao=new UserDao();
            boolean login=userDao.validateUser(user);
           if(login){
//               Implementing HttpSession
               HttpSession httpSession=req.getSession();
               httpSession.setAttribute("username",user.getUsername());
               httpSession.setAttribute("pass",user.getPassword());
//               Implementing Cookie
               Cookie usernamecookie=new Cookie("username",user.getUsername());
               res.addCookie(usernamecookie);
               Cookie check=new Cookie("password","thisisnotPassword");
                res.addCookie(check);
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
