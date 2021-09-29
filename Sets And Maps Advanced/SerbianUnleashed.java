package com.company;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SerbianUnleashed {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // singer @venue ticketsPrice ticketsCount

        Map<String, LinkedHashMap<String, Integer>> profit = new LinkedHashMap<>();

        // Lepa Brena @Sunny Beach 25 3500

        String input = reader.readLine();
        while (!input.equals("End")) {

            String[] inputData = input.split("\\s+");

            if (inputData.length < 4 || !input.contains(" @")) {
                input = reader.readLine();
                continue;
            } else {
                String[] data = input.split(" @");
                String singer = data[0];
                String pricePeople = data[1];
                List<String> split = new java.util.ArrayList<>(List.of(pricePeople.split("\\s+")));

                String ticketsCount = split.get(split.size() - 1);
                split.remove(split.size() - 1);
                String price = split.get(split.size() - 1);
                split.remove(split.size() - 1);

                if (Character.isLetter(ticketsCount.charAt(0)) || Character.isLetter(price.charAt(0))) {
                    input = reader.readLine();
                    continue;
                }
                String venueFinal = "";
                if (split.size() == 1) {
                    venueFinal += split.get(0);
                } else if (split.size() == 2) {
                    venueFinal += split.get(0);
                    venueFinal += " ";
                    venueFinal += split.get(1);
                } else if (split.size() == 3) {
                    venueFinal += split.get(0);
                    venueFinal += " ";
                    venueFinal += split.get(1);
                    venueFinal += " ";
                    venueFinal += split.get(2);
                }
                int value = Integer.parseInt(ticketsCount) * Integer.parseInt(price);
                if (!profit.containsKey(venueFinal)) {
                    profit.put(venueFinal, new LinkedHashMap<>());
                    profit.get(venueFinal).put(singer, value);
                } else {
                    if (!profit.get(venueFinal).containsKey(singer)) {
                        profit.get(venueFinal).put(singer, value);
                    } else {
                        profit.get(venueFinal).put(singer, profit.get(venueFinal).get(singer) + value);
                    }
                }
            }
            input = reader.readLine();
        }
        profit.forEach((key, value) -> {
            System.out.println(key);
            value.entrySet().stream()
                    .sorted((singer1, singer2) -> singer2.getValue().compareTo(singer1.getValue()))
                    .forEach(singer -> System.out.printf("#  %s -> %d%n", singer.getKey(), singer.getValue()));
        });
    }
}
