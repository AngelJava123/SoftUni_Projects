package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] num = Arrays.stream(scanner.nextLine().split(" ")).
                mapToInt(value -> Integer.parseInt(value)).toArray();

        int[] condensedArray = new int [num.length-1];

        if (num.length == 1) {
            System.out.println(num[0]);
            return;
        }
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < condensedArray.length-i; j++) {
                condensedArray[j] = num[j] + num[j + 1];
            }
            num = condensedArray;
        }
        System.out.println(condensedArray[0]);
    }
}
