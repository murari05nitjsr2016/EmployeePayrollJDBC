package com.jdbc.emppayrollservice;
import java.sql.*;

public class EmployeePayRollService {
    static final String userName = "root";
    static final String passWord = "root";
    static final String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service";
    public  static Connection connection;
    public static Statement statement;

    public static  void loadAndEstablishConnectionWithDB()
    {

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

    public static void createTableWithAttributes() throws SQLException {
        statement = connection.createStatement();
        String sql = "CREATE TABLE employee_payroll " +
                "(id INTEGER not NULL auto_increment, " +
                " name VARCHAR(150), " +
                " salary double not null, " +
                " start date not null, " +
                " PRIMARY KEY ( id ))";
        statement.executeUpdate(sql);
    }

    public static void insertRow() throws SQLException {
        statement = connection.createStatement();
        String insertQuery = "INSERT INTO employee_payroll (name, salary, start) VALUES (?, ?, ?)";
        PreparedStatement pstmt = connection.prepareStatement(insertQuery);
        pstmt.setString(1,"Bill");
        pstmt.setDouble(2,1000000.0);
        pstmt.setDate(3, Date.valueOf("2018-01-03"));
        pstmt.execute();

    }
    public static void main(String[] args) throws SQLException {
        System.out.println("welcome in employee payroll system");
        loadAndEstablishConnectionWithDB();
        insertRow();

    }
}
