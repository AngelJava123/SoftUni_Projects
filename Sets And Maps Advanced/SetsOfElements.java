package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Set<String> numbers1 = new LinkedHashSet<>();
        Set<String> numbers2 = new LinkedHashSet<>();

        int[] range = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int range1 = range[0];
        int range2 = range[1];

        while (range1-- > 0) {
            String number = reader.readLine();

            numbers1.add(number);
        }
        while (range2-- > 0) {
            String number = reader.readLine();

            numbers2.add(number);
        }
        numbers1.retainAll(numbers2);

        System.out.print(String.join(" ", numbers1));
    }
}
