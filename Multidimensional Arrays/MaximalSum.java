package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        fillMatrix(scanner, matrix);

        // 1 5 5 2 4
        // 2 1 4 14 3
        // 3 7 11 2 8
        // 4 8 12 16 4

        int[][] finalMatrix = new int[3][3];

        int totalSum = 0;
        for (int row = 1; row < matrix.length - 1; row++) {
            for (int col = 1; col < matrix[row].length - 1; col++) {

                int current = matrix[row][col];
                int left = matrix[row][col - 1];
                int right = matrix[row][col + 1];
                int up = matrix[row - 1][col];
                int down = matrix[row + 1][col];
                int diagonalLeft = matrix[row - 1][col - 1];
                int diagonalRight = matrix[row + 1][col + 1];
                int diagonalUp = matrix[row - 1][col + 1];
                int diagonalDown = matrix[row + 1][col - 1];

                int sumValues = current + left + right + up + down +
                        diagonalLeft + diagonalRight + diagonalUp + diagonalDown;

                if (sumValues > totalSum) {
                    totalSum = sumValues;

                    finalMatrix = new int[][]{
                            {diagonalLeft, up, diagonalUp},
                            {left, current, right},
                            {diagonalDown, down, diagonalRight}
                    };
                }
            }
        }
        System.out.println("Sum = " + totalSum);
        for (int row = 0; row < finalMatrix.length; row++) {
            for (int col = 0; col < finalMatrix[row].length; col++) {
                System.out.print(finalMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(Scanner scanner, int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {

            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            matrix[row] = arr;
        }
    }
}
