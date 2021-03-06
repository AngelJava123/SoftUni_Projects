package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] numbers = Arrays.stream(scanner.nextLine().split(" ")).
                mapToInt(value -> Integer.parseInt(value)).toArray();

        int sumOfOddNumbers = 0;
        int sumOfEvenNumbers = 0;

        for (int number : numbers) {
            if (number % 2 == 0) {
                sumOfEvenNumbers += number;
        } else {
                sumOfOddNumbers += number;
            }
        }
        int diff = sumOfEvenNumbers - sumOfOddNumbers;
        System.out.println(diff);
    }
}
