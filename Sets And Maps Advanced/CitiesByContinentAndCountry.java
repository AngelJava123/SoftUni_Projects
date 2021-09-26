package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, LinkedHashMap<String, List<String>>> countries = new LinkedHashMap<>();

        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0) {
            String[] input = reader.readLine().split("\\s+");

            String continent = input[0];
            String country = input[1];
            String city = input[2];

            if (!countries.containsKey(continent)) {
                countries.put(continent, new LinkedHashMap<>());
                countries.get(continent).put(country, new ArrayList<>());
            } else {
                if (!countries.get(continent).containsKey(country)) {
                    countries.get(continent).put(country, new ArrayList<>());
                }
            }
            countries.get(continent).get(country).add(city);
        }
        countries.forEach((key, value) -> {
            System.out.println(key + ":");
            value.forEach((key1, value1) -> {
                System.out.println(key1 + " -> " + String.join(", ", value1));
            });
        });
    }
}
