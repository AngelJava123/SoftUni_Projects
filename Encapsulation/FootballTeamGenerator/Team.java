package FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        setName(name);
        players = new ArrayList<>();
    }

    public void setName(String name) {

        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(String player) {

        String removed = null;

        for (Player player1 : players) {
            if (player1.getName().equals(player)) {
                removed = player;
                players.remove(player1);
                break;
            }
        }

        if (removed == null) {
            throw new IllegalArgumentException("Player " + player + " is not in " + name + " team.");
        }
    }

    public double getRating() {

        double result = 0;
        for (Player player : players) {
            result += player.overallSkillLevel();
        }
        return result / players.size();
    }
}
