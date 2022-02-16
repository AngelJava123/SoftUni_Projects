package com.company;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class diablo_db {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);

        Properties properties = new Properties();
        String password = " ";
        String user = " ";

        properties.setProperty("user", user);
        properties.setProperty("password", password);

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/diablo", properties);

        PreparedStatement statement = connection.prepareStatement("SELECT u.first_name, u.last_name, count(g.id) AS games_played\n" +
                "FROM users u JOIN users_games ug ON u.id = ug.user_id\n" +
                "JOIN games g ON ug.game_id = g.id\n" +
                "WHERE u.last_name = ?\n" +
                "GROUP BY u.first_name;");

        String lastName = sc.nextLine();

        statement.setString(1, lastName);

        ResultSet rs = statement.executeQuery();

        if (rs.next()) {
            System.out.println("User: " + lastName);
            System.out.println(rs.getString("first_name") + " " + rs.getString("last_name") + " "
            + "has played " + rs.getString("games_played") + " games");
        } else {
            System.out.println("No such user exists");
        }
    }
}
