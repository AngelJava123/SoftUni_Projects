package com.company;

import java.util.Scanner;

public class TrainingLab_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double longInMetres = Double.parseDouble(scanner.nextLine());
        double wideInMetres = Double.parseDouble(scanner.nextLine());

        longInMetres = longInMetres * 100;
        wideInMetres = wideInMetres * 100;

         int longOfWorkplaces = (int)((wideInMetres - 100) / (70));
         int wideOfWorkplaces = (int)(longInMetres/120);

        int totalSum = (longOfWorkplaces * wideOfWorkplaces) - 3;
        System.out.println(totalSum);
    }
}
