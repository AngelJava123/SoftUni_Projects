package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Phonebook {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> numbers = new LinkedHashMap<>();

        String input = reader.readLine();
        while (!input.equals("search")) {

            String[] inputData = input.split("-");

            String name = inputData[0];
            String phoneNumber = inputData[1];

            numbers.put(name, phoneNumber);

            input = reader.readLine();
        }
        String input1 = reader.readLine();
        while (!input1.equals("stop")) {

            if (numbers.containsKey(input1)) {
                System.out.println(input1 + " -> " + numbers.get(input1));
            } else {
                System.out.println("Contact " + input1 + " does not exist.");
            }
            input1 = reader.readLine();
        }
    }
}
