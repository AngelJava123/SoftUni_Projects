package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Set<String> names = new LinkedHashSet<>();

        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0) {
            String name = reader.readLine();

            names.add(name);
        }
        names.forEach(System.out::println);
    }
}
