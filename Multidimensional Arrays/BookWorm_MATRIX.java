package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BookWorm_MATRIX {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String word = reader.readLine();
        StringBuilder builder = new StringBuilder(word);
        int n = Integer.parseInt(reader.readLine());

        char[][] matrix = new char[n][n];

        for (int row = 0; row < n; row++) {
            char[] rows = reader.readLine().toCharArray();
            matrix[row] = rows;
        }
        int playerRow = 0;
        int playerCol = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == 'P') {
                    playerRow = row;
                    playerCol = col;
                    break;
                }
            }
        }
        String command = reader.readLine();
        while (!command.equals("end")) {

            if (command.equals("up")) {
                if (isInBounds(playerRow - 1, playerCol, matrix)) {
                    builder.deleteCharAt(builder.length() - 1);
                    command = reader.readLine();
                    continue;
                }
                if (Character.isLetter(matrix[playerRow - 1][playerCol])) {
                    char letter = matrix[playerRow - 1][playerCol];
                    builder.append(letter);
                }
                matrix[playerRow - 1][playerCol] = 'P';
                matrix[playerRow][playerCol] = '-';
                playerRow--;
            }
            if (command.equals("down")) {
                if (isInBounds(playerRow + 1, playerCol, matrix)) {
                    builder.deleteCharAt(builder.length() - 1);
                    command = reader.readLine();
                    continue;
                }
                if (Character.isLetter(matrix[playerRow + 1][playerCol])) {
                    char letter = matrix[playerRow + 1][playerCol];
                    builder.append(letter);
                }
                matrix[playerRow + 1][playerCol] = 'P';
                matrix[playerRow][playerCol] = '-';
                playerRow++;
            }
            if (command.equals("left")) {
                if (isInBounds(playerRow, playerCol - 1, matrix)) {
                    builder.deleteCharAt(builder.length() - 1);
                    command = reader.readLine();
                    continue;
                }
                if (Character.isLetter(matrix[playerRow][playerCol - 1])) {
                    char letter = matrix[playerRow][playerCol - 1];
                    builder.append(letter);
                }
                matrix[playerRow][playerCol - 1] = 'P';
                matrix[playerRow][playerCol] = '-';
                playerCol--;
            }
            if (command.equals("right")) {
                if (isInBounds(playerRow, playerCol + 1, matrix)) {
                    builder.deleteCharAt(builder.length() - 1);
                    command = reader.readLine();
                    continue;
                }
                if (Character.isLetter(matrix[playerRow][playerCol + 1])) {
                    char letter = matrix[playerRow][playerCol + 1];
                    builder.append(letter);
                }
                matrix[playerRow][playerCol + 1] = 'P';
                matrix[playerRow][playerCol] = '-';
                playerCol++;
            }
            command = reader.readLine();
        }
        System.out.println(builder);
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    // isOutBounds:
    public static boolean isInBounds(int row, int col, char[][] matrix) {
        return row >= matrix.length || row < 0 ||
                col >= matrix[row].length || col < 0;
    }
    /*
     isInBounds:
      public static boolean isInBounds(int row, int col, char[][] matrix) {
            return row < matrix.length && row >= 0 &&
                    col < matrix[row].length && col >= 0;
        }
    */
}
