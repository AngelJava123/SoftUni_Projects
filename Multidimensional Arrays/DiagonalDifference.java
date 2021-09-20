package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];

        for (int row = 0; row < matrix.length; row++) {

            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            matrix[row] = arr;
        }
        int sumFirst = 0;
        int sumSecond = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {

                if (row == col) {
                    int value = matrix[row][col];
                    sumFirst += value;
                }
            }
        }
        for (int row = n; row >= 0; row--) {
            for (int col = n; col >= 0; col--) {

                if ((row + col) == (n - 1)) {
                    sumSecond += matrix[row][col];
                }
            }
        }
        int difference = Math.abs(sumFirst - sumSecond);
        System.out.println(difference);
    }
}
