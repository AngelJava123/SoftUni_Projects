package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String resources = scanner.nextLine();

        Map<String, Integer> occurrences = new LinkedHashMap<>();

        while (!resources.equals("stop")) {

            int quantity = Integer.parseInt(scanner.nextLine());

            if (!occurrences.containsKey(resources)) {
                occurrences.put(resources, quantity);
            } else {
                occurrences.put(resources, occurrences.get(resources) + quantity);
            }

            resources = scanner.nextLine();
        }
        occurrences.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
