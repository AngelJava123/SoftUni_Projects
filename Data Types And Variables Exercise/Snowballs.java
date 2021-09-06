package com.company;

import java.util.Scanner;

public class Snowballs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        double maxCalculatedSnowball = Double.MIN_VALUE;
        int maxSnowballSnow = Integer.MIN_VALUE;
        int maxSnowballTime = Integer.MIN_VALUE;
        int maxSnowballQuality = Integer.MIN_VALUE;

        for (int numberOfSnowballs = 1; numberOfSnowballs <= n ; numberOfSnowballs++) {
            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());

            double snowballValue = Math.pow (snowballSnow / snowballTime, snowballQuality);

            if (snowballValue > maxCalculatedSnowball) {
                maxCalculatedSnowball = snowballValue;
                maxSnowballSnow = snowballSnow;
                maxSnowballTime = snowballTime;
                maxSnowballQuality = snowballQuality;
            }
        }
        System.out.printf("%d : %d = %.0f (%d)", maxSnowballSnow, maxSnowballTime, maxCalculatedSnowball, maxSnowballQuality  );
    }
}
