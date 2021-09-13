package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Double> studentGradesSum = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            if (!studentGradesSum.containsKey(name)) {
                studentGradesSum.put(name, grade);
            } else {
                //средната оценка я смяташ при добавяне,
                // просто ако има оценка новата се получава
                // от (старата + новата) / 2.
                studentGradesSum.put(name, (studentGradesSum.get(name) + grade) / 2);
            }
        }
        studentGradesSum.entrySet().stream().filter(map -> map.getValue() >= 4.50).
                sorted((e1, e2) -> Double.compare(e2.getValue(), e1.getValue()))
                .forEach(entry -> {
                    System.out.printf("%s -> %.2f%n", entry.getKey(),entry.getValue());
                });
    }
}
