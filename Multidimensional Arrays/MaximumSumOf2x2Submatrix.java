package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt).toArray();

            matrix[row] = arr;
        }
        int sum = 0;

        int[][] finalMatrix = new int[2][2];

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int currentCol = matrix[row][col];
                int down = matrix[row + 1][col];
                int right = matrix[row][col + 1];
                int diagonal = matrix[row + 1][col + 1];

                int sumValue = currentCol + down + right + diagonal;

                if (sumValue > sum) {
                    sum = sumValue;
                    finalMatrix = new int[][] {
                            {currentCol, right},
                            {down, diagonal}
                    };
                }
            }
        }
        for (int row = 0; row < finalMatrix.length; row++) {
            for (int col = 0; col < finalMatrix[row].length; col++) {
                System.out.print(finalMatrix[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println(sum);
    }
}
