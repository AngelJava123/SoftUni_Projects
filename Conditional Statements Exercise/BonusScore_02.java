package com.company;

import java.util.Scanner;

public class BonusScore_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int score = Integer.parseInt(scanner.nextLine());

        double bonus = 0;

        if (score <= 100) {
            bonus = 5;
        } else if (score > 1000) {
            bonus = score * 0.1;
        } else  {
            bonus = score * 0.2;
        }

        if (score % 2 == 0) {
            bonus = bonus + 1;
        } else if (score % 10 == 5) {
            bonus = bonus + 2;
        }

        System.out.println(bonus);
        System.out.println(score + bonus);
    }
}
