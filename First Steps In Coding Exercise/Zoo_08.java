package com.company;

import java.util.Scanner;

public class Zoo_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dogs = Integer.parseInt(scanner.nextLine());
        int otherAnimals = Integer. parseInt(scanner.nextLine());

        double foodForDogs = dogs * 2.50;
        int foodForOthers = otherAnimals * 4;

        double sum = foodForDogs + foodForOthers;
        System.out.printf("%.1f lv.", sum);








    }
}
