package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class FixEmails {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> emails = new LinkedHashMap<>();

        String name = reader.readLine();
        while (!name.equals("stop")) {

            String email = reader.readLine().toLowerCase();

            if (!email.endsWith("us") && !email.endsWith("com") && !email.endsWith("uk")) {
                emails.put(name, email);
            }
            name = reader.readLine();
        }
        emails.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
