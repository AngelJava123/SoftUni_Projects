package com.company;

import java.util.Scanner;

public class EasterDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countEasterBread = Integer.parseInt(scanner.nextLine());
        int maxPoints = Integer.MIN_VALUE;
        String bestChef = "";
        for (int easterBread = 1; easterBread <= countEasterBread ; easterBread++) {
            String chefName = scanner.nextLine();
            int totalGrades = 0;
            String command = scanner.nextLine();

            while (!command.equals("Stop")) {
                int grade = Integer.parseInt(command);
                totalGrades += grade;

                command = scanner.nextLine();
            }
            System.out.printf("%s has %d points.%n", chefName, totalGrades);

            if (totalGrades > maxPoints) {
                maxPoints = totalGrades;
                bestChef = chefName;
                System.out.printf("%s is the new number 1!%n", bestChef);
            }
        }

        System.out.printf("%s won competition with %d points!", bestChef, maxPoints);
    }
}
