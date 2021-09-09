package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "\\+359([ -])2\\1[0-9]{3}\\1[0-9]{4}\\b";
        String input = scanner.nextLine();

        List<String> numbers = new ArrayList<>();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            numbers.add(matcher.group());
        }
        System.out.println(numbers.toString().replace("[", "").
                                              replace("]",""));
    }
}
