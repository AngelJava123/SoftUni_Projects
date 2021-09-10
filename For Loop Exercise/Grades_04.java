package com.company;

import java.util.Scanner;

public class Grades_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int students = Integer.parseInt(scanner.nextLine());

        double st1 = 0; // Top students: {процент студенти с успех 5.00 или повече}%
        double st2 = 0; // Between 4.00 and 4.99: {между 4.00 и 4.99 включително}%
        double st3 = 0; // Between 3.00 and 3.99: {между 3.00 и 3.99 включително}%
        double st4 = 0; // Fail: {по-малко от 3.00}%

        double markResult = 0;

        for (int i = 1; i <= students; i++) {
            double grades = Double.parseDouble(scanner.nextLine());

            if (grades >= 5.00) {
                st1 += 1;
            } else if (grades >= 4.00 && grades <= 4.99) {
                st2 += 1;
            } else if (grades >= 3.00 && grades <= 3.99) {
                st3 += 1;
            } else if (grades < 3.00) {
                st4 += 1;
            }
            markResult += grades;
        }
        double topStudents = 100.0 * st1 /  students; // процента студенти получили grades >= 5.00
        double fourStudents = 100.0 * st2 /  students; // процента студенти получили grades >= 4.00 && grades <= 4.99
        double threeStudents = 100.0 * st3 / students; // процента студенти получили grades >= 3.00 && grades <= 3.99
        double twoStudents = 100.0 * st4 /  students; // процента студенти получили grades < 3.00


        System.out.printf("Top students: %.2f%%%n", topStudents);
        System.out.printf("Between 4.00 and 4.99: %.2f%%%n", fourStudents);
        System.out.printf("Between 3.00 and 3.99: %.2f%%%n", threeStudents);
        System.out.printf("Fail: %.2f%%%n", twoStudents);
        System.out.printf("Average: %.2f", markResult / students);
    }
}
