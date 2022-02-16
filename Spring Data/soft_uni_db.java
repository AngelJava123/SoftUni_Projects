package com.company;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class soft_uni_db {
    public static void main(String[] args) throws IOException, SQLException {
        Scanner sc = new Scanner(System.in);

        Properties props = new Properties();

        String password = " ";
        String user = " ";

        props.setProperty("user", user);
        props.setProperty("password", password);

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/soft_uni", props);

        PreparedStatement stmt = connection.prepareStatement("SELECT first_name, last_name " +
                "FROM employees WHERE salary > ?");

        String salary = sc.nextLine();

        stmt.setDouble(1, Double.parseDouble(salary));

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString("first_name") + " " + rs.getString("last_name"));
        }
    }
}
