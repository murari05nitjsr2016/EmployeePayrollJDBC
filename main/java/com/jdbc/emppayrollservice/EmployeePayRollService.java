package com.jdbc.emppayrollservice;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EmployeePayRollService {
    public static  void loadAndEstablishConnectionWithDB()
    {
        String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service";
        String userName = "root";
        String passWord = "root";
        Connection connection;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver sucessfully Loaded");
            System.out.println("Connecting to the database: " + jdbcURL);
            connection = DriverManager.getConnection(jdbcURL, userName, passWord);
            System.out.println("Connected  successfully" + connection);
        } catch (ClassNotFoundException e) {
            System.out.println("driver not found in that path");
        } catch (SQLException throwables) {
            System.out.println("connection failed");
        }
    }
    public static void main(String[] args) {
        System.out.println("welcome in employee payroll system");
        loadAndEstablishConnectionWithDB();
    }
}
