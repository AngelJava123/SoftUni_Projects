package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "%(?<name>[A-Z][a-z]+)%[^|$%.]*<(?<product>\\w+)>[^|$%.]*\\|(?<count>[0-9]+)\\|[^|$%.]*?(?<price>[0-9]+\\.*[0-9]*)\\$";
        Pattern pattern = Pattern.compile(regex);

        Map<String, LinkedHashMap<String, Double>> validLines = new LinkedHashMap<>();
        double totalIncome = 0;

        String input = scanner.nextLine();
        while (!input.equals("end of shift")) {

            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                String name = matcher.group("name");
                String product = matcher.group("product");
                int count = Integer.parseInt(matcher.group("count"));
                double price = Double.parseDouble(matcher.group("price"));
                double total = count * price;
                totalIncome += total;

                validLines.put(name, new LinkedHashMap<>());
                validLines.get(name).put(product, total);
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, LinkedHashMap<String, Double>> entry:validLines.entrySet()) {
            for (Map.Entry<String, Double> subEntry:entry.getValue().entrySet()) {
                System.out.printf("%s: %s - %.2f%n", entry.getKey(), subEntry.getKey(), subEntry.getValue());
            }
        }
        System.out.printf("Total income: %.2f",totalIncome);
    }
}
