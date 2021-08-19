package com.company;

import java.util.Scanner;

public class DepositCalculator_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double DepositSum = Double.parseDouble(scanner.nextLine());
        int months = Integer.parseInt(scanner.nextLine());
        double percent = Double.parseDouble(scanner.nextLine());

        double Sum = DepositSum + months * ((DepositSum * percent / 100) / 12);

        System.out.println(Sum);


    }
}
