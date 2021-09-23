package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[rows][];

        int[][] matrixToReplace = new int[rows][];

        for (int row = 0; row < rows; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            matrix[row] = arr;
            matrixToReplace[row] = Arrays.copyOf(arr, arr.length);
        }
        int[] wrongValue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rowValue = wrongValue[0];
        int colValue = wrongValue[1];

        int valueFromMatrix = matrix[rowValue][colValue];

        boolean notChanged = true;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {

                int sum = 0;
                if (matrix[row][col] == valueFromMatrix) {

                    if (isInBounds(row, col - 1, matrix) && matrix[row][col - 1] != valueFromMatrix) { // left
                        sum += matrix[row][col - 1];
                        matrixToReplace[row][col] = sum;
                        notChanged = false;
                    }
                    if (isInBounds(row, col + 1, matrix) && matrix[row][col + 1] != valueFromMatrix) { // right
                        sum += matrix[row][col + 1];
                        matrixToReplace[row][col] = sum;
                        notChanged = false;
                    }
                    if (isInBounds(row - 1, col, matrix) && matrix[row - 1][col] != valueFromMatrix) { // up
                        sum += matrix[row - 1][col];
                        matrixToReplace[row][col] = sum;
                        notChanged = false;
                    }
                    if (isInBounds(row + 1, col, matrix) && matrix[row + 1][col] != valueFromMatrix) { // down
                        sum += matrix[row + 1][col];
                        matrixToReplace[row][col] = sum;
                        notChanged = false;
                    }
                }
            }
        }
        if (notChanged) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[row].length; col++) {
                    System.out.print(matrix[row][col] + " ");
                }
                System.out.println();
            }
        } else {
            for (int row = 0; row < matrixToReplace.length; row++) {
                for (int col = 0; col < matrixToReplace[row].length; col++) {
                    System.out.print(matrixToReplace[row][col] + " ");
                }
                System.out.println();
            }
        }
    }


    public static boolean isInBounds(int row, int col, int[][] matrix) {
        return row < matrix.length && row >= 0 &&
                col < matrix[row].length && col >= 0;
    }
}
