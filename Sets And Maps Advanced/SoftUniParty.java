package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Set<String> vip = new TreeSet<>();
        Set<String> regular = new TreeSet<>();

        String input = reader.readLine();
        while (!input.equals("PARTY")) {

            if (Character.isDigit(input.charAt(0))) {
                vip.add(input);
            } else {
                regular.add(input);
            }
            input = reader.readLine();
        }
        String input2 = reader.readLine();
        while (!input2.equals("END")) {

            vip.remove(input2);
            regular.remove(input2);

            input2 = reader.readLine();
        }
        System.out.println(vip.size() + regular.size());
        vip.forEach(System.out::println);
        regular.forEach(System.out::println);
    }
}
