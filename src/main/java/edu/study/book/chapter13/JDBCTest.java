package edu.study.book.chapter13;

import java.sql.*;

public class JDBCTest {
    public static void main(String[] args) throws ClassNotFoundException {
        test01();
    }

    public static void test01() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/atguigudb?useSSL=false&serverTimezone=UTC", "root", "123456");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from employees");
            while (resultSet.next()) {
                System.out.println(resultSet.getRow());
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
