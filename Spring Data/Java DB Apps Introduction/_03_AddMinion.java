import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

public class _03_AddMinion {
    public static void main(String[] args) throws SQLException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Properties properties = new Properties();

        String user = "root";
        String password = "";

        properties.setProperty("user", user);
        properties.setProperty("password", password);

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        PreparedStatement statement = connection.prepareStatement("SELECT t.`id` AS town_id, t.`name` AS town_name\n" +
                "FROM towns t\n" +
                "WHERE t.`name` = ?;");

        String[] minion = reader.readLine().split("\\s+");
        String[] villain = reader.readLine().split("\\s+");

        String minionName = minion[1];
        int age = Integer.parseInt(minion[2]);
        String town = minion[3];
        String villainName = villain[1];

        statement.setString(1, town);

        ResultSet rs = statement.executeQuery();

        if (!rs.next()) {
            PreparedStatement insertTown = connection.prepareStatement("INSERT INTO towns(`name`) VALUES(?);");

            insertTown.setString(1, town);

            insertTown.execute();

            System.out.println("Town " + town + " was added to the database.");
        }

        ResultSet rs1 = statement.executeQuery();

        rs1.next();
        int idOfTown = rs1.getInt("town_id");
        int villainId = 0;

        PreparedStatement ifVillainExist = connection.prepareStatement("SELECT v.`id` AS villain_id, v.`name` AS villain_name \n" +
                "FROM villains v \n" +
                "WHERE v.`name` = ?;");

        ifVillainExist.setString(1, villainName);

        ResultSet rs2 = ifVillainExist.executeQuery();

        if (!rs2.next()) {
            PreparedStatement insertVillain = connection.prepareStatement("INSERT INTO villains(`name`, `evilness_factor`) VALUES (?, ?);");

            insertVillain.setString(1, villainName);
            insertVillain.setString(2, "evil");

            insertVillain.execute();

            System.out.println("Villain " + villainName + " was added to the database.");

            ifVillainExist.setString(1, villainName);

            ResultSet rs3 = ifVillainExist.executeQuery();
            rs3.next();
            villainId = rs3.getInt("villain_id");

        } else {
            villainId = rs2.getInt("villain_id");
        }

        PreparedStatement insertMinion = connection.prepareStatement("INSERT INTO minions(`name`, `age`, `town_id`) \n" +
                "VALUES (?, ?, ?);");

        insertMinion.setString(1, minionName);
        insertMinion.setInt(2, age);
        insertMinion.setInt(3, idOfTown);

        insertMinion.execute();

        int minionId = 0;

        PreparedStatement idOfMinion = connection.prepareStatement("SELECT m.`id` AS minion_id FROM minions m \n" +
                "WHERE m.`name` = ?;");

        idOfMinion.setString(1, minionName);

        ResultSet rs4 = idOfMinion.executeQuery();
        rs4.next();
        minionId = rs4.getInt("minion_id");

        PreparedStatement insertMappingTable = connection.prepareStatement("INSERT INTO minions_villains" +
                "(`minion_id`, `villain_id`) VALUES (?, ?);");

        insertMappingTable.setInt(1, minionId);
        insertMappingTable.setInt(2, villainId);

        insertMappingTable.execute();

        System.out.println("Successfully added " + minionName + " to be minion of " + villainName);

        connection.close();
    }
}
