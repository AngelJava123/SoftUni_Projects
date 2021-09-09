package com.company;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> participants = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        Map<String, Integer> finalNames = new LinkedHashMap<>();

        String names = "([A-Za-z+])";
        Pattern pattern = Pattern.compile(names);

        String numbers = "([0-9+])";
        Pattern pattern1 = Pattern.compile(numbers);

        String input = scanner.nextLine();
        while (!input.equals("end of race")) {
            StringBuilder name = new StringBuilder();
            int kilometers = 0;

            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                name.append(matcher.group());
            }
            Matcher matcher1 = pattern1.matcher(input);
            while (matcher1.find()) {
                kilometers += Integer.parseInt(matcher1.group());
            }
            if (participants.contains(name.toString())) {
                if (!finalNames.containsKey(name.toString())) {
                    finalNames.put(name.toString(), kilometers);
                } else {
                    finalNames.put(name.toString(), finalNames.get(name.toString()) + kilometers);
                }
            }
            input = scanner.nextLine();
        }
        List<String> sortedMap = new ArrayList<>();

        finalNames.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(3)
                .forEachOrdered(x -> sortedMap.add(x.getKey()));

        for (int i = 0; i < 1 ; i++) {
            System.out.println("1st place: " + sortedMap.get(0));
            System.out.println("2nd place: " + sortedMap.get(1));
            System.out.println("3rd place: " + sortedMap.get(2));
        }
    }
}
