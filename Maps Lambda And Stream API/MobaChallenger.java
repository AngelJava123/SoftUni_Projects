package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MobaChallenger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Integer>> mobaPlayers = new LinkedHashMap<>();

        String command = scanner.nextLine();
        while (!command.equals("Season end")) {

            String[] commandData = command.split(" ");

            if (commandData[1].equals("->")) {
                String player = commandData[0];
                String position = commandData[2];
                int skill = Integer.parseInt(commandData[4]);

                LinkedHashMap<String, Integer> positionSkill = new LinkedHashMap<>();
                positionSkill.put(position, skill);

                if (!mobaPlayers.containsKey(player)) {
                    mobaPlayers.put(player, positionSkill);
                } else {
                    Integer currentSkill = mobaPlayers.get(player).get(position);
                    if (!mobaPlayers.get(player).containsKey(position)) {
                        mobaPlayers.get(player).put(position, skill);
                    } else {
                        if (currentSkill < skill) {
                            mobaPlayers.get(player).put(position, skill);
                        }
                    }
                }
            } else if (commandData[1].equals("vs")) {
                String player1 = commandData[0];
                String player2 = commandData[2];

                if (mobaPlayers.containsKey(player1) && mobaPlayers.containsKey(player2)) {

                boolean commonPosition = false;
                for (String s : mobaPlayers.get(player1).keySet()) {
                    for (String s1 : mobaPlayers.get(player2).keySet()) {
                        if (s.equals(s1)) {
                            commonPosition = true;
                        }
                    }
                }
                if (commonPosition) {
                    if (mobaPlayers.get(player1).values().stream().mapToInt(i -> i).sum() >
                            mobaPlayers.get(player2).values().stream().mapToInt(i -> i).sum()) {
                        mobaPlayers.remove(player2);
                    } else if (mobaPlayers.get(player1).values().stream().mapToInt(i -> i).sum() <
                            mobaPlayers.get(player2).values().stream().mapToInt(i -> i).sum()) {
                        mobaPlayers.remove(player1);
                    }
                }
            }
        }
        command = scanner.nextLine();
        }
        mobaPlayers.entrySet().stream().sorted((p1, p2) -> {
                    int result = Integer.compare(p2.getValue().values().stream().mapToInt(i -> i).sum(),
                            p1.getValue().values().stream().mapToInt(i -> i).sum());
                    if (result == 0) {
                        result = p1.getKey().compareTo(p2.getKey());
                    }
                    return result;
                }).forEach(entry -> {
                    System.out.printf("%s: %d skill%n", entry.getKey(), entry.getValue().values().stream().mapToInt(i -> i).sum());
                    entry.getValue().entrySet().stream().sorted((e1, e2) -> {
                                int res = Integer.compare(e2.getValue(), e1.getValue());
                                if (res == 0) {
                                    res = e1.getKey().compareTo(e2.getKey());
                                }
                                return res;
                            }).forEach(e -> {
                        System.out.printf("- %s <::> %d%n", e.getKey(), e.getValue());
                });
         });
    }
}
