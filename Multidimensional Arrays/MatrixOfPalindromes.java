package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char letter = (char) 97;

                String chars = "";

                if (row == 0 && col == 0) {
                    chars += (letter);
                    chars += (letter);
                    chars += (letter);
                    matrix[row][col] = chars;
                } else {
                    int first = row + letter;
                    int middle = row + col + letter;
                    int last = row + letter;
                    chars += (char) first;
                    chars += (char) middle;
                    chars += (char) last;
                    matrix[row][col] = chars;
                }
            }
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
