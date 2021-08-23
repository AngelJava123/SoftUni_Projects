package com.company;

import java.util.Scanner;

public class PipesInPool_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int v = Integer.parseInt(scanner.nextLine()); // Обем на басейна в литри
        int p1 = Integer.parseInt(scanner.nextLine()); // дебит на първата тръба за час
        int p2 = Integer.parseInt(scanner.nextLine()); //дебит на втората тръба за час
        double h = Double.parseDouble(scanner.nextLine()); // часовете които работникът отсъства

        double poolV1 = h * p1;
        double poolV2 = h * p2;

        double totalV = poolV1 + poolV2;

        if (totalV <= v) {
            System.out.printf("The pool is %.2f%% full. Pipe 1: %.2f%%. Pipe 2: %.2f%%.", (totalV / v*100) , (p1 * h / totalV * 100) , (p2 * h / totalV * 100));
        } else {
            System.out.printf("For %.2f hours the pool overflows with %.2f liters.", h , totalV - v);
        }
    }
}
