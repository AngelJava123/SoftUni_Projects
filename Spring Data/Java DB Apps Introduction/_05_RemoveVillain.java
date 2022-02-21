import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

public class _05_RemoveVillain {
    public static void main(String[] args) throws SQLException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Properties properties = new Properties();

        String password = "";
        String user = "root";

        properties.setProperty("user", user);
        properties.setProperty("password", password);

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        PreparedStatement minionsCount = connection.prepareStatement("SELECT count(m.`id`) AS minioun_count, " +
                "v.`name` AS villain_name\n" +
                "FROM villains v JOIN minions_villains mv ON v.id = mv.villain_id\n" +
                "JOIN minions m ON mv.minion_id = m.id\n" +
                "WHERE v.id = ?;");

        int id = Integer.parseInt(reader.readLine());

        minionsCount.setInt(1, id);

        ResultSet rs = minionsCount.executeQuery();

        rs.next();

        int resultCount = rs.getInt("minioun_count");

        String name = rs.getString("villain_name");

        if (resultCount == 0) {
            System.out.println("No such villain was found");
            return;
        }

        try {

            PreparedStatement villainToDeleteMappingTable = connection.prepareStatement("DELETE FROM minions_villains \n" +
                    "\t\t WHERE villain_id = ?;");

            villainToDeleteMappingTable.setInt(1, id);

            villainToDeleteMappingTable.execute();

            PreparedStatement villainToDeleteVillainTable = connection.prepareStatement("DELETE FROM villains\n" +
                    " WHERE id = ?;");

            villainToDeleteVillainTable.setInt(1, id);

            villainToDeleteVillainTable.execute();

            System.out.println(name + " was deleted");
            System.out.println(resultCount + " minions released");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        connection.close();
    }
}
