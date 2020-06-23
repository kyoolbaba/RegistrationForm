package com.user.dao;

import com.mysql.cj.protocol.Resultset;
import com.user.model.User;


import java.sql.*;
public class UserDao {
    public static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
    public static final String JDBC_URL="jdbc:mysql://localhost:3306/bridgelabz";
    public static final String JDBC_USER="root";
    public static final String JDBC_PASSWORD=                                                                                                "Harshita*7";

    Connection connection;


    public boolean registerUser(User user) throws ClassNotFoundException {
        String INSERT_USERS="INSERT INTO bridgelabz.registration_details (username,first_name,second_name,email,contact_no" +
                ",password) VALUES (?,?,?,?,?,?);";
        Class.forName(JDBC_DRIVER);
        int res=0;
        try{
            connection= DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
                    PreparedStatement preparedStatement=connection.prepareStatement(INSERT_USERS);
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getFirstName());
            preparedStatement.setString(3,user.getLastName());
            preparedStatement.setString(4,user.getEmail());
            preparedStatement.setString(5,user.getContactNo());
            preparedStatement.setString(6,user.getPassword());
            res=preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        }catch(SQLException|RuntimeException e){
            e.printStackTrace();
            res=0;
        }
        return res!=0;
    }

    public boolean validateUser(User user) throws SQLException, ClassNotFoundException {
        Class.forName(JDBC_DRIVER);
        connection= DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
        String VALIDATE_USERS="SELECT username,password from bridgelabz.registration_details where username=? and password=?;";
        PreparedStatement preparedStatement=connection.prepareStatement(VALIDATE_USERS);
        preparedStatement.setString(1,user.getUsername());
        preparedStatement.setString(2,user.getPassword());
        ResultSet resultSet=  preparedStatement.executeQuery();
        boolean present = false;
       while(resultSet.next()) {
           present = (resultSet.getString("username").equals(user.getUsername())) &&
                   (resultSet.getString("password").equals(user.getPassword()));
       }
        resultSet.close();
       preparedStatement.close();
        connection.close();
        return present;
    }
}