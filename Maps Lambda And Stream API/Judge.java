package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, Integer>> contests = new LinkedHashMap<>();

        String command = scanner.nextLine();
        while (!command.equals("no more time")) {

            String[] commandData = command.split(" -> ");

            String username = commandData[0];
            String contest = commandData[1];
            int points = Integer.parseInt(commandData[2]);

            LinkedHashMap<String, Integer> contestPoints = new LinkedHashMap<>();

            if (!contests.containsKey(contest)) {

                contests.put(contest, contestPoints);

                if (!contests.get(contest).containsKey(username)) {
                    contestPoints.put(username, points);
                    contests.put(contest, contestPoints);
                }
            } else {
                if (!contests.get(contest).containsKey(username)) {
                    contests.get(contest).put(username, points);
                } else {
                    contests.get(contest).put(username, Math.max(points, contests.get(contest).get(username)));
                }
            }
            command = scanner.nextLine();
        }
        contests.forEach((key, value) -> {
            System.out.printf("%s: %d participants%n", key, value.size());
            AtomicInteger count = new AtomicInteger();
            value.entrySet().stream().
                    sorted((f, s) -> {
                        int res = Integer.compare(s.getValue(), f.getValue());
                        if (res == 0) {
                            res = f.getKey().compareTo(s.getKey());
                        }
                        return res;
                    }).forEach(i -> System.out.printf("%d. %s <::> %d%n", count.incrementAndGet(), i.getKey(), i.getValue()));
        });
        Map<String, Integer> totalPoints = new LinkedHashMap<>();
        for (var stringLinkedHashMapEntry : contests.entrySet()) {
            stringLinkedHashMapEntry.getValue()
                    .forEach((key, value) -> {
                        if (totalPoints.containsKey(key)) {
                            totalPoints.put(key, totalPoints.get(key) + value);
                        } else {
                            totalPoints.put(key, value);
                        }
                    });
        }
        System.out.println("Individual standings:");
        AtomicInteger count1 = new AtomicInteger();
        totalPoints.entrySet().stream()
                .sorted((e1, e2) -> {
                   int result = Integer.compare(e2.getValue(), e1.getValue());
                    if (result == 0) {
                        result = e1.getKey().compareTo(e2.getKey());
                    }
                    return result;
                }).forEach(entry -> {
            System.out.printf("%s. %s -> %d%n", count1.incrementAndGet(), entry.getKey(), entry.getValue());
        });
    }
}
