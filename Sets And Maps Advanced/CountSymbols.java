package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<Character, Integer> countSymbols = new TreeMap<>();

        String input = reader.readLine();

        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);

            if (!countSymbols.containsKey(currentSymbol)) {
                countSymbols.put(currentSymbol, 1);
            } else {
                countSymbols.put(currentSymbol, countSymbols.get(currentSymbol) + 1);
            }
        }
        countSymbols.forEach((key, value) -> System.out.println(key + ": " + value + " time/s"));
    }
}
