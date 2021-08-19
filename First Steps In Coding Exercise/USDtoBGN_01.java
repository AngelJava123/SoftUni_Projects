package com.company;

import java.util.Scanner;

public class USDtoBGN_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        //Прочетете входните данни от конзолата (щатските долари):
        double USD = Double.parseDouble(scanner.nextLine());

        //Създайте нова променлива, в която ще направите конвертирането от щатски долари към български лева, като знаете валутния курс:
        double BGN = USD * 1.79549;

        //Принтирайте получените български лева.
        System.out.println(BGN);

    }
}
