package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> languageCount = new LinkedHashMap<>();
        Map<String, Integer> usernamePoints = new LinkedHashMap<>();

        String command = scanner.nextLine();

        while (!command.equals("exam finished")) {

            String[] commandData = command.split("-");

            String username = commandData[0];

            if (commandData.length == 3) {
                String language = commandData[1];
                int points = Integer.parseInt(commandData[2]);

                if (!languageCount.containsKey(language)) {
                    languageCount.put(language, 1);
                } else {
                    languageCount.put(language, languageCount.get(language) + 1);
                }
                if (!usernamePoints.containsKey(username)) {
                    usernamePoints.put(username, points);
                } else {
                    int currentPoints = usernamePoints.get(username);
                    if (points > currentPoints) {
                        usernamePoints.put(username, points);
                    }
                }
            } else if (commandData.length == 2) {
                usernamePoints.remove(username);
            }
            command = scanner.nextLine();
        }
        System.out.println("Results:");
        usernamePoints.entrySet().stream().sorted((e1, e2) -> {
                    int sortedResult = Integer.compare(e2.getValue(), e1.getValue());

                    if (sortedResult == 0) {
                        sortedResult = e1.getKey().compareTo(e2.getKey());
                    }
                    return sortedResult;
                }).forEach(entry -> System.out.println(entry.getKey() + " | " + entry.getValue()));
        System.out.println("Submissions:");
        languageCount.entrySet().stream().sorted((e1, e2) -> {
            int sortedResult = Integer.compare(e2.getValue(), e1.getValue());

            if (sortedResult == 0) {
                sortedResult = e1.getKey().compareTo(e2.getKey());
            }
            return sortedResult;
        }).forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));
    }
}
