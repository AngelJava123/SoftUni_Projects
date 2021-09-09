package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchDates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regex = "\\b(?<day>[0-9]{2})([.\\-/])(?<month>[A-Z][a-z]{2})\\2(?<year>[0-9]{4})\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher datesMatcher = pattern.matcher(input);

        while (datesMatcher.find()) {

            String day = datesMatcher.group("day");
            String month = datesMatcher.group("month");
            String year = datesMatcher.group("year");

            System.out.printf("Day: %s, Month: %s, Year: %s%n", day,month,year);
        }
    }
}
