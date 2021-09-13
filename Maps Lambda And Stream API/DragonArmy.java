package com.company;

import java.util.*;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, TreeMap<String, List<Integer>>> dragons = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            //{type} {name} {damage} {health} {armor}.

            String[] input = scanner.nextLine().split(" ");

            String type = input[0];
            String name = input[1];
            String damage = input[2];
            String health = input[3];
            String armor = input[4];

            //health 250, damage 45 and armor 10

            if (damage.equals("null")) {
                damage = "45";
            }
            if (health.equals("null")) {
                health = "250";
            }
            if (armor.equals("null")) {
                armor = "10";
            }
            if (!dragons.containsKey(type)) {

                dragons.put(type, new TreeMap<>());
                dragons.get(type).put(name, new ArrayList<>());
                dragons.get(type).get(name).add(Integer.parseInt(health));
                dragons.get(type).get(name).add(Integer.parseInt(damage));
                dragons.get(type).get(name).add(Integer.parseInt(armor));

            } else if (dragons.containsKey(type)) {
                if (dragons.get(type).containsKey(name)) {

                    dragons.get(type).get(name).add(0, Integer.parseInt(health));
                    dragons.get(type).get(name).remove(1);
                    dragons.get(type).get(name).add(1, Integer.parseInt(damage));
                    dragons.get(type).get(name).remove(2);
                    dragons.get(type).get(name).add(2, Integer.parseInt(armor));
                    dragons.get(type).get(name).remove(3);
                } else {
                    dragons.get(type).put(name, new ArrayList<>());
                    dragons.get(type).get(name).add(Integer.parseInt(health));
                    dragons.get(type).get(name).add(Integer.parseInt(damage));
                    dragons.get(type).get(name).add(Integer.parseInt(armor));
                }
            }
        }
        //Red::(160.00/2350.00/30.00)
        for (Map.Entry<String, TreeMap<String, List<Integer>>> entry : dragons.entrySet()) {
            List<Double> averages = new ArrayList<>();

            averages.add(entry.getValue().values().stream().mapToInt(x -> x.get(0)).average().getAsDouble());
            averages.add(entry.getValue().values().stream().mapToInt(x -> x.get(1)).average().getAsDouble());
            averages.add(entry.getValue().values().stream().mapToInt(x -> x.get(2)).average().getAsDouble());

            System.out.printf("%s::(%.2f/%.2f/%.2f)%n",entry.getKey(),averages.get(1),averages.get(0),averages.get(2));
            for (Map.Entry<String, List<Integer>> subEntry : entry.getValue().entrySet()) {
                String name = subEntry.getKey();
                List<Integer> values = subEntry.getValue();
                int healthIndex = values.get(0);
                int damageIndex = values.get(1);
                int armorIndex = values.get(2);

                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n",
                                  name, damageIndex, healthIndex, armorIndex);
            }
        }
    }
}
