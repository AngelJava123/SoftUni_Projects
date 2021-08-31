package com.company;

import java.util.Scanner;

public class TrainTheTrainers_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();

        double allGradesSum = 0;
        double countPresentation = 0;

        while (!command.equals("Finish")) {
            String presentation = command;
            countPresentation++;

            double gradeSum = 0;
            double avgGrade = 0;

            for (int i = 0; i < n; i++) {
                double grade = Double.parseDouble(scanner.nextLine());
                gradeSum += grade;
            }
            avgGrade = gradeSum / n;
            allGradesSum += avgGrade;
            System.out.printf("%s - %.2f.%n", presentation, avgGrade);

            command = scanner.nextLine();
        }
        System.out.printf("Student's final assessment is %.2f.", allGradesSum / countPresentation);
    }
}
