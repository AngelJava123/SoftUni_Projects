import java.sql.*;
import java.util.Arrays;
import java.util.Properties;
import java.util.Scanner;

public class _07_IncreaseMinionsAge {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Properties properties = new Properties();

        String user = "root";
        String password = "";

        properties.setProperty("user", user);
        properties.setProperty("password", password);

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        PreparedStatement statement = connection.prepareStatement("UPDATE minions SET name = lower(name), age = age + 1\n" +
                "WHERE id IN (?);");

        PreparedStatement statement1 = connection.prepareStatement("SELECT m.`name` AS minion_name, m.`age` AS minion_age\n" +
                "FROM minions m;");

        int[] values = Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < values.length; i++) {
            statement.setInt(1, values[i]);
            statement.execute();
        }

        ResultSet rs1 = statement1.executeQuery();

        while (rs1.next()) {
            System.out.println(rs1.getString("minion_name") + " " + rs1.getString("minion_age"));
        }

        connection.close();
    }
}

