package com.company;

import java.util.Scanner;

public class Bills_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int months = Integer.parseInt(scanner.nextLine());


        double waterBill = 20;
        double netBill = 15;
        double otherBills = 0;

        double waterBillCnt = 0;
        double internetBillCnt = 0;
        double electricityBillCnt = 0;
        double otherBillsCnt = 0;


        for (int i = 1; i <= months; i++) {
            double electricityBill = Double.parseDouble(scanner.nextLine());

            electricityBillCnt += electricityBill;
            waterBillCnt += waterBill;
            internetBillCnt += netBill;
            otherBills = (electricityBill + waterBill + netBill) * 1.2;
            otherBillsCnt += otherBills;
        }
        double avg = (electricityBillCnt+waterBillCnt+internetBillCnt+otherBillsCnt)/ months;
        System.out.printf("Electricity: %.2f lv%n", electricityBillCnt);
        System.out.printf("Water: %.2f lv%n", waterBillCnt);
        System.out.printf("Internet: %.2f lv%n", internetBillCnt);
        System.out.printf("Other: %.2f lv%n", otherBillsCnt);
        System.out.printf("Average: %.2f lv%n", avg);

    }
}
