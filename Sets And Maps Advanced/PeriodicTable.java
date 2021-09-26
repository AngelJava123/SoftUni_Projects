package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Set<String> elements = new TreeSet<>();

        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0) {
            String[] compounds = reader.readLine().split("\\s+");

            elements.addAll(Arrays.asList(compounds));
        }
        System.out.print(String.join(" ", elements));
    }
}
