package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> plates = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            String[] data = scanner.nextLine().split(" ");

            String type = data[0];
            String username = data[1];

            if (type.equals("register")) {
                String licensePlate = data[2];
                if (!plates.containsKey(username)) {
                    plates.put(username, licensePlate);
                     System.out.println(username +
                                    " registered " + licensePlate + " successfully");
                } else {
                    System.out.println("ERROR: already registered with plate number " + plates.get(username));
                }
            } else if (type.equals("unregister")) {
                if (!plates.containsKey(username)) {
                    System.out.println("ERROR: user " + username + " not found");
                } else {
                    System.out.println(username + " unregistered successfully");
                    plates.remove(username);
                }
            }
        }
        plates.forEach((key, value) -> System.out.println(key + " => " + value));
    }
}
