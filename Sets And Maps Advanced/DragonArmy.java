package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DragonArmy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Red Bazgargal 100 2500 25

        LinkedHashMap<String, TreeMap<String, List<Integer>>> dragons = new LinkedHashMap<>();

        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0) {
            String[] input = reader.readLine().split("\\s+");

            String type = input[0];
            String dragon = input[1];
            int damage = 0;
            int health = 0;
            int armour = 0;

            if (input[2].equals("null")) {
                damage = 45;
            } else {
                damage = Integer.parseInt(input[2]);
            }
            if (input[3].equals("null")) {
                health = 250;
            } else {
                health = Integer.parseInt(input[3]);
            }
            if (input[4].equals("null")) {
                armour = 10;
            } else {
                armour = Integer.parseInt(input[4]);
            }

            if (!dragons.containsKey(type)) {
                dragons.put(type, new TreeMap<>());
                dragons.get(type).put(dragon, new ArrayList<>());
                dragons.get(type).get(dragon).add(damage);
                dragons.get(type).get(dragon).add(health);
                dragons.get(type).get(dragon).add(armour);
            } else {
                if (!dragons.get(type).containsKey(dragon)) {
                    dragons.get(type).put(dragon, new ArrayList<>());
                    dragons.get(type).get(dragon).add(damage);
                    dragons.get(type).get(dragon).add(health);
                    dragons.get(type).get(dragon).add(armour);
                } else {
                    dragons.get(type).get(dragon).set(0, damage);
                    dragons.get(type).get(dragon).set(1, health);
                    dragons.get(type).get(dragon).set(2, armour);
                }
            }
        }
        // Red::(160.00/2350.00/30.00)

        for (Map.Entry<String, TreeMap<String, List<Integer>>> key : dragons.entrySet()) {

            List<String> dragonData = new ArrayList<>();

            double damageAverage = 0;
            double healthAverage = 0;
            double armourAverage = 0;
            for (Map.Entry<String, List<Integer>> value : key.getValue().entrySet()) {

                damageAverage += value.getValue().get(0);
                healthAverage += value.getValue().get(1);
                armourAverage += value.getValue().get(2);

                dragonData.add(String.format("-%s -> damage: %d, health: %d, armor: %d",
                        value.getKey(), value.getValue().get(0), value.getValue().get(1), value.getValue().get(2)));
            }
            damageAverage = damageAverage / key.getValue().size();
            healthAverage = healthAverage / key.getValue().size();
            armourAverage = armourAverage / key.getValue().size();

            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", key.getKey(), damageAverage, healthAverage, armourAverage);
            for (String dragon:dragonData) {
                System.out.println(dragon);
            }
        }
    }
}
