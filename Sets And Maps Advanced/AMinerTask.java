package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class AMinerTask {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> elements = new LinkedHashMap<>();

        String input = reader.readLine();
        while (!input.equals("stop")) {

            int quantity = Integer.parseInt(reader.readLine());

            if (!elements.containsKey(input)) {
                elements.put(input, quantity);
            } else {
                elements.put(input, elements.get(input) + quantity);
            }
            input = reader.readLine();
        }
        elements.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
