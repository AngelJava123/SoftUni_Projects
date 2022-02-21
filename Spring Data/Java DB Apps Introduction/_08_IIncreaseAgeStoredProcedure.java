import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

public class _08_IIncreaseAgeStoredProcedure {
    public static void main(String[] args) throws SQLException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Properties properties = new Properties();

        String user = "root";
        String password = "";

        properties.setProperty("user", user);
        properties.setProperty("password", password);

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        CallableStatement callableStatement = connection.prepareCall("CALL usp_get_older(?);");

        int id = Integer.parseInt(reader.readLine());

        callableStatement.setInt(1, id);

        callableStatement.executeQuery();

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT m.`name` AS minion_name" +
                ", m.`age` AS minion_age FROM minions m\n" +
                "WHERE id = ?;");

        preparedStatement.setInt(1, id);

        ResultSet rs = preparedStatement.executeQuery();

        if (rs.next()) {
            System.out.println(rs.getString("minion_name") + " " + rs.getString("minion_age"));
        }

        connection.close();
    }
}
