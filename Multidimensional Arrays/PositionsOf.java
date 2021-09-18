package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 2 3
        // 1 2 3
        // 4 2 2
        // 2

        int[] rowsCols = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = rowsCols[0];
        int cols = rowsCols[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            matrix[row] = arr;
        }
        int numberToFind = Integer.parseInt(scanner.nextLine());

        boolean isFound = true;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == numberToFind) {
                    isFound = false;
                    System.out.println(row + " " + col);
                }
            }
        }
        if (isFound) {
            System.out.println("not found");
        }
    }
}
