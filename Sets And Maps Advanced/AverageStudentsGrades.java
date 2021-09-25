package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<Double>> grades = new TreeMap<>();

        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0) {

            String input = reader.readLine();
            String[] inputData = input.split("\\s+");
            String name = inputData[0];
            double grade = Double.parseDouble(inputData[1]);

            if (!grades.containsKey(name)) {
                grades.put(name, new ArrayList<>());
            }
            grades.get(name).add(grade);
        }
        grades.forEach((name, grade) -> {

            List<String> nums = new ArrayList<>();

            double sum = grade.stream().mapToDouble(Double::doubleValue).sum() / grade.size();

            for (double grad : grade) {
                nums.add(String.format("%.2f", grad));
            }
            System.out.println(name + " -> " + nums.toString().replaceAll("\\[", "").
                    replaceAll("]", "").replaceAll(",", "") +
                    " (" + String.format("avg: %.2f", sum) + ")");
        });
    }
}
