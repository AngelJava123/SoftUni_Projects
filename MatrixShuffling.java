package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < matrix.length; row++) {

            String[] arr = scanner.nextLine().split("\\s+");

            matrix[row] = arr;
        }

        String input = scanner.nextLine();
        while (!input.equals("END")) {

            if (!isItValidInput(input, matrix, rows, cols)) {
                System.out.println("Invalid input!");
                input = scanner.nextLine();
                continue;
            } else {
                String[] inputData = input.split("\\s+");
                int row1 = Integer.parseInt(inputData[1]);
                int col1 = Integer.parseInt(inputData[2]);
                int row2 = Integer.parseInt(inputData[3]);
                int col2 = Integer.parseInt(inputData[4]);

                String element1 = matrix[row1][col1];
                String element2 = matrix[row2][col2];

                matrix[row1][col1] = element2;
                matrix[row2][col2] = element1;

                for (int row = 0; row < matrix.length; row++) {
                    for (int col = 0; col < matrix[row].length; col++) {
                        System.out.print(matrix[row][col] + " ");
                    }
                    System.out.println();
                }
            }
            input = scanner.nextLine();
        }
    }

    private static boolean isItValidInput(String input, String[][] matrix, int rows, int cols) {

        // swap row1 col1 row2 col2

        String[] inputData = input.split("\\s+");

        if (!inputData[0].equals("swap")) {
            return false;
        }
        if (inputData.length != 5) {
            return false;
        }
        int row1 = Integer.parseInt(inputData[1]);
        int col1 = Integer.parseInt(inputData[2]);
        int row2 = Integer.parseInt(inputData[3]);
        int col2 = Integer.parseInt(inputData[4]);

        if (row1 > rows || row2 > rows || col1 > cols || col2 > cols) {
            return false;
        }
        return true;
    }
}
