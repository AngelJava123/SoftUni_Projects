package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bee_MATRIX {
    static int beeRow = 0;
    static int beeCol = 0;
    static int willBeRow = 0;
    static int willBeCol = 0;
    static int pollinatedFlowers = 0;
    static int needToPollinate = 0;
    static boolean outOfTheMatrix = false;
    static boolean isBonus = false;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        char[][] matrix = new char[n][n];

        for (int row = 0; row < n; row++) {
            matrix[row] = reader.readLine().toCharArray();
        }
        flowersNeeded(n, matrix);
        findBee(n, matrix);

        willBeRow = beeRow;
        willBeCol = beeCol;

        String command = reader.readLine();
        while (!command.equals("End")) {

            if (command.equals("up")) {
                if (isOutBounds(beeRow - 1, beeCol, matrix)) {
                    outOfTheMatrix = true;
                    matrix[beeRow][beeCol] = '.';
                    break;
                }
                moveBee(beeRow, beeCol, willBeRow - 1, willBeCol, matrix);
                beeRow--;
                willBeRow--;
                if (isBonus) {
                    moveBee(beeRow, beeCol, willBeRow - 1, willBeCol, matrix);
                    beeRow--;
                    willBeRow--;
                }
                isBonus = false;
            }
            if (command.equals("down")) {
                if (isOutBounds(beeRow + 1, beeCol, matrix)) {
                    outOfTheMatrix = true;
                    matrix[beeRow][beeCol] = '.';
                    break;
                }
                moveBee(beeRow, beeCol, willBeRow + 1, willBeCol, matrix);
                beeRow++;
                willBeRow++;
                if (isBonus) {
                    moveBee(beeRow, beeCol, willBeRow + 1, willBeCol, matrix);
                    beeRow++;
                    willBeRow++;
                }
                isBonus = false;
            }
            if (command.equals("left")) {
                if (isOutBounds(beeRow, beeCol - 1, matrix)) {
                    outOfTheMatrix = true;
                    matrix[beeRow][beeCol] = '.';
                    break;
                }
                moveBee(beeRow, beeCol, willBeRow, willBeCol - 1, matrix);
                beeCol--;
                willBeCol--;
                if (isBonus) {
                    moveBee(beeRow, beeCol, willBeRow, willBeCol - 1, matrix);
                    beeCol--;
                    willBeCol--;
                }
                isBonus = false;
            }
            if (command.equals("right")) {
                if (isOutBounds(beeRow, beeCol + 1, matrix)) {
                    outOfTheMatrix = true;
                    matrix[beeRow][beeCol] = '.';
                    break;
                }
                moveBee(beeRow, beeCol, willBeRow, willBeCol + 1, matrix);
                beeCol++;
                willBeCol++;
                if (isBonus) {
                    moveBee(beeRow, beeCol, willBeRow, willBeCol + 1, matrix);
                    beeCol++;
                    willBeCol++;
                }
                isBonus = false;
            }
            command = reader.readLine();
        }

        if (outOfTheMatrix) {
            System.out.println("The bee got lost!");
        }
        if (pollinatedFlowers < 5) {
            int needed = 5 - pollinatedFlowers;
            System.out.println("The bee couldn't pollinate the flowers, she needed " + needed + " flowers more");
        } else {
            System.out.println("Great job, the bee manage to pollinate " + pollinatedFlowers + " flowers!");
        }
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

    private static void moveBee(int beeRow, int beeCol, int willBeRow, int willBeCol, char[][] matrix) {
        if (matrix[willBeRow][willBeCol] == 'f') {
            pollinatedFlowers++;
            matrix[beeRow][beeCol] = '.';
            matrix[willBeRow][willBeCol] = 'B';
        } else if (matrix[willBeRow][willBeCol] == 'O') {
            matrix[beeRow][beeCol] = '.';
            matrix[willBeRow][willBeCol] = '.';
            isBonus = true;
        } else if (matrix[willBeRow][willBeCol] == '.') {
            matrix[willBeRow][willBeCol] = 'B';
            matrix[beeRow][beeCol] = '.';
        }
    }

    private static void findBee(int n, char[][] matrix) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == 'B') {
                    beeRow = row;
                    beeCol = col;
                }
            }
        }
    }

    public static boolean isOutBounds(int row, int col, char[][] matrix) {
        return row >= matrix.length || row < 0 ||
                col >= matrix[row].length || col < 0;
    }

    private static void flowersNeeded(int n, char[][] matrix) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == 'f') {
                    needToPollinate++;
                }
            }
        }
    }
}
