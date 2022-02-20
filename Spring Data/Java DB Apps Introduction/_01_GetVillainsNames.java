import java.sql.*;
import java.util.Properties;

public class _01_GetVillainsNames {
    public static void main(String[] args) throws SQLException {

        Properties properties = new Properties();

        String user = "root";
        String password = "Harmantika123.";

        properties.setProperty("user", user);
        properties.setProperty("password", password);

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        PreparedStatement statement = connection.prepareStatement("SELECT v.`name` AS villain_name, count(DISTINCT m.`id`) AS number_of_minions FROM\n" +
                "villains v JOIN minions_villains mv ON v.id = mv.villain_id\n" +
                "JOIN minions m ON mv.minion_id = m.id\n" +
                "GROUP BY v.`name`\n" +
                "HAVING number_of_minions > 15\n" +
                "ORDER BY number_of_minions DESC;");

        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString("villain_name") + " " + rs.getString("number_of_minions"));
        }

        connection.close();
    }
}
