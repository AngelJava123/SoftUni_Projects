package com.company;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PostOffice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());

        String firstPart = input.get(0);
        String secondPart = input.get(1);
        String thirdPart = input.get(2);

        String[] words = thirdPart.split("\\s+");

        Map<Character, Integer> symbols = new LinkedHashMap<>();

        String lettersRegex = "([#$%*&])(?<letters>[A-Z]+)\\1";
        Pattern lettersExtract = Pattern.compile(lettersRegex);
        Matcher letterMatch = lettersExtract.matcher(firstPart);

        StringBuilder letters = new StringBuilder();

        while (letterMatch.find()) {
            letters.append(letterMatch.group("letters"));
        }
        for (int i = 0; i < letters.length(); i++) {
            char current = letters.charAt(i);
            symbols.put(current, 0);
        }
        String asciiCodesRegex = "(?<capitalLetter>[0-9]{2}):(?<length>[0-9]{2})";
        Pattern asciiPattern = Pattern.compile(asciiCodesRegex);
        Matcher asciiMatcher = asciiPattern.matcher(secondPart);

        while (asciiMatcher.find()) {
            int capitalLetter = Integer.parseInt(asciiMatcher.group("capitalLetter"));
            char currentLetter = (char) capitalLetter;
            int length = Integer.parseInt(asciiMatcher.group("length"));

            if (symbols.containsKey(currentLetter)) {
                symbols.put(currentLetter, length+1);
            }
        }
        for (Map.Entry<Character, Integer> entry: symbols.entrySet()) {
            char currentLetter = entry.getKey();
            for (String word:words) {
                char firstLetter = word.charAt(0);
                if (currentLetter == firstLetter) {
                    if (entry.getValue() == word.length()) {
                        System.out.println(word);
                    }
                }
            }
        }
    }
}
