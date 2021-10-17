package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Selling_MATRIX {
    static int playerRow = 0;
    static int playerCol = 0;
    static int willBeRow = 0;
    static int willBeCol = 0;
    static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        char[][] matrix = new char[n][n];

        for (int row = 0; row < n; row++) {
            matrix[row] = reader.readLine().toCharArray();
        }
        findPlayer(n, matrix);
        boolean outOfTheMatrix = false;
        label:
        while (sum < 50) {
            String command = reader.readLine();

            switch (command) {
                case "up":
                    if (isOutBounds(willBeRow - 1, willBeCol, matrix)) {
                        matrix[playerRow][playerCol] = '-';
                        outOfTheMatrix = true;
                        break label;
                    } else {
                        movePlayer(playerRow, playerCol, willBeRow - 1, willBeCol, matrix);
                        findPlayer(n, matrix);
                    }
                    break;
                case "down":
                    if (isOutBounds(willBeRow + 1, willBeCol, matrix)) {
                        matrix[playerRow][playerCol] = '-';
                        outOfTheMatrix = true;
                        break label;
                    } else {
                        movePlayer(playerRow, playerCol, willBeRow + 1, willBeCol, matrix);
                        findPlayer(n, matrix);
                    }
                    break;
                case "right":
                    if (isOutBounds(willBeRow, willBeCol + 1, matrix)) {
                        matrix[playerRow][playerCol] = '-';
                        outOfTheMatrix = true;
                        break label;
                    } else {
                        movePlayer(playerRow, playerCol, willBeRow, willBeCol + 1, matrix);
                        findPlayer(n, matrix);
                    }
                    break;
                case "left":
                    if (isOutBounds(willBeRow, willBeCol - 1, matrix)) {
                        matrix[playerRow][playerCol] = '-';
                        outOfTheMatrix = true;
                        break label;
                    } else {
                        movePlayer(playerRow, playerCol, willBeRow, willBeCol - 1, matrix);
                        findPlayer(n, matrix);
                    }
                    break;
            }
        }
        if (outOfTheMatrix) {
            System.out.println("Bad news, you are out of the bakery.");
        }
        if (sum >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.println("Money: " + sum);
        printMatrix(n, matrix);
    }

    private static void printMatrix(int n, char[][] matrix) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void findPlayer(int n, char[][] matrix) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == 'S') {
                    playerRow = row;
                    playerCol = col;
                    willBeRow = row;
                    willBeCol = col;
                }
            }
        }
    }

    private static void movePlayer(int playerRow, int playerCol, int willBeRow, int willBeCol, char[][] matrix) {
        if (matrix[willBeRow][willBeCol] == 'O') {
            matrix[playerRow][playerCol] = '-';
            matrix[willBeRow][willBeCol] = '-';
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[row].length; col++) {
                    if (matrix[row][col] == 'O') {
                        matrix[row][col] = 'S';
                    }
                }
            }
        } else if (Character.isDigit(matrix[willBeRow][willBeCol])) {
            int value = Character.getNumericValue(matrix[willBeRow][willBeCol]);
            sum += value;
            matrix[willBeRow][willBeCol] = 'S';
            matrix[playerRow][playerCol] = '-';
        } else if (matrix[willBeRow][willBeCol] == '-') {
            matrix[playerRow][playerCol] = '-';
            matrix[willBeRow][willBeCol] = 'S';
        }
    }

    public static boolean isOutBounds(int row, int col, char[][] matrix) {
        return row >= matrix.length || row < 0 ||
                col >= matrix[row].length || col < 0;
    }
}
