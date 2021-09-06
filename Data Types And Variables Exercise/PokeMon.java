package com.company;

import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine()); // poke power
        int m = Integer.parseInt(scanner.nextLine()); //distance between the poke targets
        int y = Integer.parseInt(scanner.nextLine()); // exhaustionFactor Y

        int targetsPoked = 0;

        double originalValue = n * 0.50;

        while (n >= m)  {

            if (n == originalValue)  {
                if (y > 0) {
                n = n / y;
                }
                if (n < m) {
                    break;
                }
            }
            n -= m;
            targetsPoked++;
        }
        System.out.println(n);
        System.out.println(targetsPoked);
    }
}


