package com.company;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> demons = Arrays.stream(scanner.nextLine().split("[, ]+")).
                sorted(String::compareTo).collect(Collectors.toList());

        for (String demon:demons) {

            int health = 0;
            double damage = 0;

            String sumOfLettersRegex = "([^\\d+\\-*./])";
            Pattern asciiSumPattern = Pattern.compile(sumOfLettersRegex);
            Matcher matchLetters = asciiSumPattern.matcher(demon);

            while (matchLetters.find()) {
                String current = matchLetters.group();
                char currentChar = current.charAt(0);
                health += currentChar;
            }
            String damageRegex = "(-?\\d+\\.?\\d*)";
            Pattern damagePattern = Pattern.compile(damageRegex);
            Matcher matcherNumbers = damagePattern.matcher(demon);

            while (matcherNumbers.find()) {
                double number = Double.parseDouble(matcherNumbers.group());
                damage += number;
            }
            String operationRegex = "[*/]";
            Pattern damageOperation = Pattern.compile(operationRegex);
            Matcher operations = damageOperation.matcher(demon);

            while (operations.find()) {
                if (operations.group().equals("*")) {
                    damage *= 2;
                } else if (operations.group().equals("/")) {
                    damage /= 2;
                }
            }
            System.out.printf("%s - %d health, %.2f damage%n", demon, health, damage);
        }
    }
}
