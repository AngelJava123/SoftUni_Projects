package com.company;

import java.util.Scanner;

public class SleepyTomCat_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine()); // броят почивни дни
        double totalRestDays = n * 127; // минутите игра в почивните дни
        double totalWorkDays = (365 - n) * 63; // минутите игра в работните дни
        double totalMinutes = totalRestDays + totalWorkDays;

        if (30000 >= totalMinutes) {
            System.out.printf("Tom sleeps well%n");
            System.out.printf("%.0f hours and %.0f minutes less for play", Math.abs(30000 - totalMinutes) / 60 , Math.abs(30000 - totalMinutes) % 60);
        } else {
            System.out.printf("Tom will run away%n");
            System.out.printf("%.0f hours and %.0f minutes more for play", Math.abs(totalMinutes - 30000) / 60, Math.abs(totalMinutes - 30000) % 60 );
        }
    }
}
