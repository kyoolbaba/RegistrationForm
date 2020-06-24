<%--
  Created by IntelliJ IDEA.
  User: KYOOLBABAA
  Date: 22-06-2020
  Time: 00:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration Form</title>
    <style type="text/css">
        body{
            background-color:#cf6e48;
            /*background-image:url('C:\Users\KYOOLBABAA\Desktop\New folder\LoginForm\WebContent\Phsyco.jpg');*/
            background-size:cover;
        }

        h1{
            background-color: #f64b07;
            height:50px;
            width:300px;
            position:absolute;
            padding:15px;
            line-height:2;
            color: white;
            margin-top:60px;
            margin-left:10%;
            text-align:center;
            padding-bottom:15px;
            border:2px solid;
            font-style:oblique;
            font-family: sans-serif;
            border-width:5px;
            border-color:#ff4800;
            border-radius:25px;
        }

        .user{
            color:#00ffdd;
            font-family:cursive;
            font-size:20px;
            position:absolute;
            top:170px;
            left:13%;
        }
        input[type=text]:focus{
            width:300px;
            height:50px;
        }
        input[type=password]:focus{
            width:300px;
            height:50px;
        }
        .successmessage{
            color: #0029ff;
            font-family:cursive;
            font-size:20px;
            position:absolute;
            top:200px;
            left:50%;
        }

    </style>
</head>
<body>

<%
    response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");

    if(session.getAttribute("username")!=null)
    {
        response.sendRedirect("ProFilePage.jsp");
    }
%>
<form action="register" method="post">
    <h1>Register</h1>
    <div class="user" >
        FirstName:<input type="text" name="fname" placeholder="First Name"><br>
        LastName:<input type="text" name="lname" placeholder="Last Name"><br>
        Email:<input type="text" name="email" placeholder="email"><br>
        ContactNumber:<input type="text" name="contactno" placeholder="Contact"><br>
        Username:<input type="text" name="username" placeholder="Username" ><br>
        Password:<input type="password" name="pass" placeholder="password"><br>
        <button type="submit">Register</button>
        <a href="index.jsp">Click here to login</a>
    </div>>
</form>
</body>
</html>