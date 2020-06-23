package com.user.controller;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.*;
import java.io.IOException;

public class Logout extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws  IOException {
        HttpSession session=req.getSession();
//        removing all the attributes from HTTPsession using session.invalidate()
        session.invalidate();
//        used for removing a cookies during logout
        Cookie cookie=new Cookie("username",null);
        cookie.setMaxAge(0);
        res.sendRedirect("index.jsp");
    }
}
