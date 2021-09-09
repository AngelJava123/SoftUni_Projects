package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        List<String> attacked = new ArrayList<>();
        List<String> destroyed = new ArrayList<>();

        for (int i = 0; i < number; i++) {

            StringBuilder decryption = new StringBuilder();

            int symbolCount = 0;

            String input = scanner.nextLine();
            String regex = "[starSTAR]";
            Pattern symbolPattern = Pattern.compile(regex);
            Matcher symbolMatcher = symbolPattern.matcher(input);

            while (symbolMatcher.find()) {
                symbolCount++;
            }
            for (int j = 0; j < input.length(); j++) {
                char currentChar = input.charAt(j);
                decryption.append((char) (currentChar - symbolCount));
            }
            String decryptedRegex = "@(?<planet>[A-Za-z]+)[^@\\-!:>]*:(?<population>\\d+)[^@\\-!:>]*!(?<type>[AD])![^@\\-!:>]*->(?<attack>\\d+)";
            Pattern decryptedMessage = Pattern.compile(decryptedRegex);
            Matcher validPlanets = decryptedMessage.matcher(decryption.toString());

            while (validPlanets.find()) {
                String planet = validPlanets.group("planet");
                int population = Integer.parseInt(validPlanets.group("population"));
                String type = validPlanets.group("type");
                int attack = Integer.parseInt(validPlanets.group("attack"));

                if (type.equals("A")) {
                    attacked.add(planet);
                } else if (type.equals("D")) {
                    destroyed.add(planet);
                }
            }
        }
        java.util.Collections.sort(attacked);
        java.util.Collections.sort(destroyed);

        if (attacked.isEmpty()) {
            System.out.println("Attacked planets: 0");
        } else {
            System.out.println("Attacked planets: " + attacked.size());
            for (String planet:attacked) {
                System.out.println("-> " + planet);
            }
        }
        if (destroyed.isEmpty()) {
            System.out.println("Destroyed planets: 0");
        } else {
            System.out.println("Destroyed planets: " + destroyed.size());
            for (String planet:destroyed) {
                System.out.println("-> " + planet);
            }
        }
    }
}
