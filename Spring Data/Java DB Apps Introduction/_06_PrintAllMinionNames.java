import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class _06_PrintAllMinionNames {
    public static void main(String[] args) throws SQLException {

        Properties properties = new Properties();

        String user = "root";
        String password = "";

        properties.setProperty("user", user);
        properties.setProperty("password", password);

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        PreparedStatement statement = connection.prepareStatement("SELECT name FROM minions;");

        ResultSet resultSet = statement.executeQuery();

        List<String> names = new ArrayList<>();

        while (resultSet.next()) {
            names.add(resultSet.getString("name"));
        }

        int start = 0;
        int end = names.size() - 1;

        for (int i = 0; i < names.size(); i++) {
            System.out.println(i % 2 == 0 ? names.get(start++)
                                          : names.get(end--));
        }

        connection.close();
    }
}
