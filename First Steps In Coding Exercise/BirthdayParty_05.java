package com.company;

import java.util.Scanner;

public class BirthdayParty_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Прочитаме наема на залата:
        int rent = Integer.parseInt(scanner.nextLine());

        //Изчисляваме цената на тортата (20% от rent):
        double cake = rent * 0.2;

        //Изчисляваме цената за напитките (с 45% по-малка от цената на cake, т.е. те са 55% от цената на cake):
        double drinks = cake * 0.55;

        //Изчисляваме цената за animator (1/3 от rent):
        double animator = rent / 3;

        //Изчисляваме общата сума като съберем всички компоненти:
        double sum = rent + cake + animator + drinks;

        //Извеждаме totalCost на конзолата
        System.out.println(sum);

    }
}
