package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CookingJourney_MATRIX {
    static int playerRow = 0;
    static int playerCol = 0;
    static int willBeRow = 0;
    static int willBeCol = 0;
    static int money = 0;
    static boolean outOfMatrix = false;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        char[][] matrix = new char[n][n];

        for (int row = 0; row < n; row++) {
            matrix[row] = reader.readLine().toCharArray();
        }
        findPlayer(n, matrix);

        while (money < 50) {
            String command = reader.readLine();

            if (command.equals("up")) {
                if (isOutBounds(playerRow - 1, playerCol, matrix)) {
                    outOfMatrix = true;
                    matrix[playerRow][playerCol] = '-';
                    break;
                }
                movePlayer(playerRow, playerCol, willBeRow - 1, willBeCol, matrix);
                findPlayer(n, matrix);
            }
            if (command.equals("down")) {
                if (isOutBounds(playerRow + 1, playerCol, matrix)) {
                    outOfMatrix = true;
                    matrix[playerRow][playerCol] = '-';
                    break;
                }
                movePlayer(playerRow, playerCol, willBeRow + 1, willBeCol, matrix);
                findPlayer(n, matrix);
            }
            if (command.equals("left")) {
                if (isOutBounds(playerRow, playerCol - 1, matrix)) {
                    outOfMatrix = true;
                    matrix[playerRow][playerCol] = '-';
                    break;
                }
                movePlayer(playerRow, playerCol, willBeRow, willBeCol - 1, matrix);
                findPlayer(n, matrix);
            }
            if (command.equals("right")) {
                if (isOutBounds(playerRow, playerCol + 1, matrix)) {
                    outOfMatrix = true;
                    matrix[playerRow][playerCol] = '-';
                    break;
                }
                movePlayer(playerRow, playerCol, willBeRow, willBeCol + 1, matrix);
                findPlayer(n, matrix);
            }
        }
        if (outOfMatrix) {
            System.out.println("Bad news! You are out of the pastry shop.");
        } else {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.println("Money: " + money);

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

    private static void movePlayer(int playerRow, int playerCol, int willBeRow, int willBeCol, char[][] matrix) {
        if (Character.isDigit(matrix[willBeRow][willBeCol])) {
            int value = Character.getNumericValue(matrix[willBeRow][willBeCol]);
            money += value;
            matrix[playerRow][playerCol] = '-';
            matrix[willBeRow][willBeCol] = 'S';
        } else if (matrix[willBeRow][willBeCol] == 'P') {
            matrix[willBeRow][willBeCol] = '-';
            matrix[playerRow][playerCol] = '-';
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[row].length; col++) {
                    if (matrix[row][col] == 'P') {
                        matrix[row][col] = 'S';
                    }
                }
            }
        } else if (matrix[willBeRow][willBeCol] == '-') {
            matrix[playerRow][playerCol] = '-';
            matrix[willBeRow][willBeCol] = 'S';
        }
    }

    public static boolean isOutBounds(int row, int col, char[][] matrix) {
        return row >= matrix.length || row < 0 ||
                col >= matrix[row].length || col < 0;
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
}
