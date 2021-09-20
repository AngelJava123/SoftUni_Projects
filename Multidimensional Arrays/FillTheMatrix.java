package com.company;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1 4 7
        // 2 5 8
        // 3 6 9

        String[] command = scanner.nextLine().split(", ");

        int dimension = Integer.parseInt(command[0]);
        String pattern = command[1];

        int[][] matrix = new int[dimension][dimension];

        if (pattern.equals("A")) {
            fillMatrixA(dimension, matrix);
        } else if (pattern.equals("B")) {
            fillMatrixB(dimension, matrix);
        }
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrixB(int dimension, int[][] matrix) {
        int numberForIncrement = 1;
        for (int col = 0; col < dimension; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < dimension; row++) {
                    matrix[row][col] = numberForIncrement++;
                }
            } else {
                for (int row = dimension - 1; row >= 0; row--) {
                    matrix[row][col] = numberForIncrement++;
                }
            }
        }
    }

    private static void fillMatrixA(int dimension, int[][] matrix) {
        int incrementNumber = 1;

        for (int col = 0; col < dimension; col++) {
            for (int row = 0; row < dimension; row++) {
                matrix[row][col] = incrementNumber++;
            }
        }
    }
}
