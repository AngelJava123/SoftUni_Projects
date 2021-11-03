package FootballTeamGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Team> teams = new LinkedHashMap<>();

        String command = reader.readLine();
        while (!command.equals("END")) {

            String[] input = command.split(";");
            String commandType = input[0];

            if (commandType.equals("Team")) {
                String name = input[1];
                Team team = new Team(name);
                teams.putIfAbsent(name, team);
            }

            if (commandType.equals("Add")) {
                String teamName = input[1];
                String playerName = input[2];
                int endurance = Integer.parseInt(input[3]);
                int sprint = Integer.parseInt(input[4]);
                int dribble = Integer.parseInt(input[5]);
                int passing = Integer.parseInt(input[6]);
                int shooting = Integer.parseInt(input[7]);

                Player player;
                if (!teams.containsKey(teamName)) {
                    System.out.println("Team " + teamName + " does not exist.");
                } else {
                    try {
                        player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                        teams.get(teamName).addPlayer(player);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }

            if (commandType.equals("Remove")) {
                String teamName = input[1];
                String playerName = input[2];

                try {
                    teams.get(teamName).removePlayer(playerName);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            if (commandType.equals("Rating")) {
                String teamName = input[1];

                if (!teams.containsKey(teamName)) {
                    System.out.println("Team " + teamName + " does not exist.");
                } else {
                    System.out.println(teamName + " - " + (int) Math.round(teams.get(teamName).getRating()));
                }
            }
            command = reader.readLine();
        }
    }
}
