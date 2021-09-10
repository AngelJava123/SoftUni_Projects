package com.company;

import java.util.Scanner;

public class CareOfPuppy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int kilos = 1000 * Integer.parseInt(scanner.nextLine());
        int ate = 0;

        String command = scanner.nextLine();
        while (!command.equals("Adopted")){
            int gr = Integer.parseInt(command);
            ate+=gr;

            command = scanner.nextLine();
        }

        if (ate <= kilos){
            int diff = kilos - ate;
            System.out.println("Food is enough! Leftovers: " + diff + " grams.");
        }else {
            int diff = ate - kilos;
            System.out.printf("Food is not enough. You need %d grams more.", diff);
        }
    }
}




