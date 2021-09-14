package com.company;

import java.util.Scanner;

public class Workout {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double M = Double.parseDouble(scanner.nextLine());
        double sum = M;

        for (int i = 0; i < n; i++)
        {
            int K = Integer.parseInt(scanner.nextLine());
            M *= 1 + K / 100.0;
            sum += M;
        }
        if (sum <= 1000.00)
        {
            System.out.printf("Sorry Mrs. Ivanova, you need to run %.0f more kilometers", Math.ceil(1000.00 - sum));
        }
        else
        {
            System.out.printf("You've done a great job running %.0f more kilometers! ", Math.ceil(sum - 1000.00));
        }
    }
}
