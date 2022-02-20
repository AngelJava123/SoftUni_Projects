import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class _02_GetMinionNames {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Properties properties = new Properties();

        String user = "root";
        String password = "Harmantika123.";

        properties.setProperty("user", user);
        properties.setProperty("password", password);

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        PreparedStatement statement = connection.prepareStatement("SELECT v.`name` AS villain_name, m.`name` AS minion_name, m.`age` AS minion_age FROM\n" +
                "villains v JOIN minions_villains mv ON v.id = mv.villain_id\n" +
                "JOIN minions m ON mv.minion_id = m.id\n" +
                "WHERE v.id = ?;");

        int id = Integer.parseInt(scanner.nextLine());

        statement.setInt(1, id);

        ResultSet rs = statement.executeQuery();

        int count = 1;

        if (rs.next()) {
            System.out.println("Villain: " + rs.getString("villain_name"));
            System.out.println(count++ + "." + " " + rs.getString("minion_name")
                    + " " + rs.getString("minion_age"));
        } else {
            System.out.println("No villain with ID" + " " + id + " " +  "exists in the database.");
            return;
        }

        while (rs.next()) {
            System.out.println(count++ + "." + " " + rs.getString("minion_name")
                    + " " + rs.getString("minion_age"));
        }

        connection.close();
    }
}
