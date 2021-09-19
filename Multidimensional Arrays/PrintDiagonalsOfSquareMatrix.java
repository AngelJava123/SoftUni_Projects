package com.company;

import java.util.*;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[matrixSize][matrixSize];

        for (int row = 0; row < matrixSize; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            matrix[row] = arr;
        }

        for (int row = 0; row < matrixSize; row++) {
            for (int col = 0; col < matrixSize; col++) {

                // Condition for principal diagonal
                if (row == col) {
                    System.out.print(matrix[row][col] + " ");
                }
            }
        }
        System.out.println();
        for (int row = matrixSize; row >= 0; row--) {
            for (int col = matrixSize; col >= 0; col--) {

                // Condition for secondary diagonal
                if ((row + col) == (matrixSize - 1)) {
                    System.out.print(matrix[row][col] + " ");
                }
            }
        }
    }
}
