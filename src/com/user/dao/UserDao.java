package com.user.dao;

import com.user.model.User;

import java.sql.*;

public class UserDao {

    public void registerUser(User user)  {
        String INSERT_USERS="INSERT INTO bridgelabz.registration_details (username,first_name.second_name,email,contact_np" +
                ",password) VALUES (?,?,?,?,?,?);";
        try(Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bridgelabz","root",                                                                    "Harshita*7")){
            PreparedStatement preparedStatement=con.prepareStatement(INSERT_USERS);
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getFirstName());
            preparedStatement.setString(3,user.getLastName());
            preparedStatement.setString(4,user.getEmail());
            preparedStatement.setString(5,user.getContactNo());
            preparedStatement.setString(6,user.getPassword());
            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}
