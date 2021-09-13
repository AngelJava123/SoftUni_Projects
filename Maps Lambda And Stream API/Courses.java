package com.company;

import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> courses = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("end")) {

            String[] inputData = input.split(" : ");

            String courseName = inputData[0];
            String studentName = inputData[1];

            if (!courses.containsKey(courseName)) {
                courses.put(courseName, new ArrayList<>());
            }
            courses.get(courseName).add(studentName);

            input = scanner.nextLine();
        }

        courses.entrySet().stream().
                sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                            .forEach(entry -> {
           System.out.println(entry.getKey() + ": " + entry.getValue().size());
           List<String> studentNames = entry.getValue();
           studentNames.stream().sorted().forEach(studentName -> System.out.println("-- " + studentName));
        });
    }
}
