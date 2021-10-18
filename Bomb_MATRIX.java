package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bomb_MATRIX {
    static int sapperRow = 0;
    static int sapperCol = 0;
    static int willBeRow = 0;
    static int willBeCol = 0;
    static int deactivatedBombs = 0;
    static int allBombs = 0;
    static boolean gameEnds = false;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        String[] commands = reader.readLine().split(",");

        char[][] matrix = new char[n][n];

        for (int row = 0; row < n; row++) {
            matrix[row] = reader.readLine().replaceAll(" ", "").toCharArray();
        }
        findSapperAndBombs(n, matrix);

        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];

            if (command.equals("up")) {
                if (isOutBounds(sapperRow - 1, sapperCol, matrix)) {

                } else {
                    moveSapper(sapperRow, sapperCol, willBeRow - 1, willBeCol, matrix);
                    sapperRow--;
                    willBeRow--;
                    if (gameEnds) {
                        break;
                    }
                }
            }
            if (command.equals("down")) {
                if (isOutBounds(sapperRow + 1, sapperCol, matrix)) {

                } else {
                    moveSapper(sapperRow, sapperCol, willBeRow + 1, willBeCol, matrix);
                    sapperRow++;
                    willBeRow++;
                    if (gameEnds) {
                        break;
                    }
                }
            }
            if (command.equals("left")) {
                if (isOutBounds(sapperRow, sapperCol - 1, matrix)) {

                } else {
                    moveSapper(sapperRow, sapperCol, willBeRow, willBeCol - 1, matrix);
                    sapperCol--;
                    willBeCol--;
                    if (gameEnds) {
                        break;
                    }
                }
            }
            if (command.equals("right")) {
                if (isOutBounds(sapperRow, sapperCol + 1, matrix)) {

                } else {
                    moveSapper(sapperRow, sapperCol, willBeRow, willBeCol + 1, matrix);
                    sapperCol++;
                    willBeCol++;
                    if (gameEnds) {
                        break;
                    }
                }
            }
        }
        if (allBombs == 0) {
            System.out.println("Congratulations! You found all bombs!");
        } else if (gameEnds) {
            System.out.println("END! " + allBombs + " bombs left on the field");
        } else {
            System.out.println(allBombs + " bombs left on the field. Sapper position: " +
                    "(" + sapperRow + "," + sapperCol + ")");
        }
    }

    private static void moveSapper(int sapperRow, int sapperCol, int willBeRow, int willBeCol, char[][] matrix) {
        if (matrix[willBeRow][willBeCol] == 'B') {
            matrix[willBeRow][willBeCol] = '+';
            System.out.println("You found a bomb!");
            deactivatedBombs++;
            allBombs--;
        } else if (matrix[willBeRow][willBeCol] == 'e') {
            gameEnds = true;
        }
    }

    private static void findSapperAndBombs(int n, char[][] matrix) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == 's') {
                    sapperRow = row;
                    sapperCol = col;
                    willBeRow = row;
                    willBeCol = col;
                } else if (matrix[row][col] == 'B') {
                    allBombs++;
                }
            }
        }
    }

    public static boolean isOutBounds(int row, int col, char[][] matrix) {
        return row >= matrix.length || row < 0 ||
                col >= matrix[row].length || col < 0;
    }
}
