package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Snake_MATRIX {
    static int snakeRow = 0;
    static int snakeCol = 0;
    static int foodEaten = 0;
    static int willBeRow = 0;
    static int willBeCol = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        char[][] matrix = new char[n][n];

        for (int row = 0; row < n; row++) {
            matrix[row] = reader.readLine().toCharArray();
        }

        findSnake(n, matrix);
        boolean outOfTerritory = false;
        while (foodEaten < 10) {
            String command = reader.readLine();

            if (command.equals("up")) {
                if (isOutBounds(snakeRow - 1, snakeCol, matrix)) {
                    matrix[snakeRow][snakeCol] = '.';
                    outOfTerritory = true;
                    break;
                } else {
                    willBeRow = snakeRow - 1;
                    willBeCol = snakeCol;
                    moveSnake(snakeRow, snakeCol, willBeRow, willBeCol, matrix);
                    findSnake(n, matrix);
                }
            }
            if (command.equals("down")) {
                if (isOutBounds(snakeRow + 1, snakeCol, matrix)) {
                    matrix[snakeRow][snakeCol] = '.';
                    outOfTerritory = true;
                    break;
                } else {
                    willBeRow = snakeRow + 1;
                    willBeCol = snakeCol;
                    moveSnake(snakeRow, snakeCol, willBeRow, willBeCol, matrix);
                    findSnake(n, matrix);
                }
            }
            if (command.equals("left")) {
                if (isOutBounds(snakeRow, snakeCol - 1, matrix)) {
                    matrix[snakeRow][snakeCol] = '.';
                    outOfTerritory = true;
                    break;
                } else {
                    willBeRow = snakeRow;
                    willBeCol = snakeCol - 1;
                    moveSnake(snakeRow, snakeCol, willBeRow, willBeCol, matrix);
                    findSnake(n, matrix);
                }
            }
            if (command.equals("right")) {
                if (isOutBounds(snakeRow, snakeCol + 1, matrix)) {
                    matrix[snakeRow][snakeCol] = '.';
                    outOfTerritory = true;
                    break;
                } else {
                    willBeRow = snakeRow;
                    willBeCol = snakeCol + 1;
                    moveSnake(snakeRow, snakeCol, willBeRow, willBeCol, matrix);
                    findSnake(n, matrix);
                }
            }
        }
        if (outOfTerritory) {
            System.out.println("Game over!");
        } else {
            System.out.println("You won! You fed the snake.");
        }
        System.out.println("Food eaten: " + foodEaten);

        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void findSnake(int n, char[][] matrix) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == 'S') {
                    snakeRow = row;
                    snakeCol = col;
                    break;
                }
            }
        }
    }

    private static void moveSnake(int snakeRow, int snakeCol, int willBeRow, int willBeCol, char[][] matrix) {
        if (matrix[willBeRow][willBeCol] == '*') {
            matrix[snakeRow][snakeCol] = '.';
            matrix[willBeRow][willBeCol] = 'S';
            foodEaten++;
        } else if (matrix[willBeRow][willBeCol] == 'B') {
            matrix[snakeRow][snakeCol] = '.';
            matrix[willBeRow][willBeCol] = '.';
            boolean found = false;
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[row].length; col++) {
                    if (matrix[row][col] == 'B') {
                        matrix[row][col] = 'S';
                        found = true;
                    }
                }
                if (found) {
                    break;
                }
            }
        } else if (matrix[willBeRow][willBeCol] == '-') {
            matrix[snakeRow][snakeCol] = '.';
            matrix[willBeRow][willBeCol] = 'S';
        }
    }

    public static boolean isOutBounds(int row, int col, char[][] matrix) {
        return row >= matrix.length || row < 0 ||
                col >= matrix[row].length || col < 0;
    }
}
