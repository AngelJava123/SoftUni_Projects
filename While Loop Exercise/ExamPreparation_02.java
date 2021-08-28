package com.company;

import java.util.Scanner;

public class ExamPreparation_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int failedThreshold = Integer.parseInt(scanner.nextLine());

        int failedTimes = 0; // •	брояч за незадоволителни оценки
        int solvedProblemsCount = 0; // •	брояч за решените упражнения
        double gradeSum = 0; // •	сумата на всички оценки
        String lastProblem = ""; // •	коя е последната задача
        boolean isFailed = true; // •	дали се е провалил или не

        while (failedTimes < failedThreshold) {
            String problemName = scanner.nextLine();
            if (problemName.equals("Enough")) {
                isFailed = false;
                break;
            }
            int grade = Integer.parseInt(scanner.nextLine());
            if (grade <= 4) {
                failedTimes++;
            }
            gradeSum += grade;
            solvedProblemsCount++;
            lastProblem = problemName;
        }
        if (isFailed) {
            System.out.printf("You need a break, %d poor grades.", failedThreshold);
        } else {
            System.out.printf("Average score: %.2f%n", gradeSum / solvedProblemsCount);
            System.out.printf("Number of problems: %d%n", solvedProblemsCount);
            System.out.printf("Last problem: %s", lastProblem);
        }
    }
}
