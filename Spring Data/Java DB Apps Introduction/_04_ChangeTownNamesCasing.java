import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class _04_ChangeTownNamesCasing {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Properties properties = new Properties();

        String user = "root";
        String password = "Harmantika123.";

        properties.setProperty("user", user);
        properties.setProperty("password", password);

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        PreparedStatement statement = connection.prepareStatement("UPDATE towns SET name = upper(name)\n" +
                "WHERE country = ?;");

        PreparedStatement statement1 = connection.prepareStatement("SELECT name FROM towns WHERE country = ?;");

        String country = scanner.nextLine();

        statement.setString(1, country);

        int rs = statement.executeUpdate();

        List<String> towns = new ArrayList<>();

        if (rs != 0) {
            System.out.println(rs + " town names were affected.");
            statement1.setString(1, country);
            ResultSet rs1 = statement1.executeQuery();

            while (rs1.next()) {
                towns.add(rs1.getString("name"));
            }
            System.out.println(towns);
        } else {
            System.out.println("No town names were affected.");
        }

        connection.close();
    }
}
