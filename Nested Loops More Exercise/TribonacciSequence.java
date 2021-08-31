package com.company;

import java.util.Scanner;

public class TribonacciSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());
        int[] tribonacci = new int[Math.max(length, 3)];
        Calculation(tribonacci);

        //Използвам refferance type и печатам съдържанието на масива
        for (int i = 0; i < length; i++)
        {
            System.out.print(tribonacci[i] + " ");
        }
    }

    private static void Calculation(int[] tribonacci)
    {
        //Декларирам си първите 3 стойности на масива
        tribonacci[0] = tribonacci[1] = 1;
        tribonacci[2] = 2;

        //Започвам да пълня масива от 4-тата му стойност, защото предходните 3 са запълнени
        for (int i = 3; i < tribonacci.length; i++)
        {
            //Използвам формулата на Tribbonacci
            tribonacci[i] = tribonacci[i - 1] +
                    tribonacci[i - 2] +
                    tribonacci[i - 3];
        }
    }
}
