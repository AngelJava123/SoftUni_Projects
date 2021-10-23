package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MouseAndCheese {
    static int playerRow = 0;
    static int playerCol = 0;
    static int allCheeses = 0;
    static int eatenCheeses = 0;
    static boolean outOfTerritory = false;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        char[][] matrix = new char[n][n];

        for (int row = 0; row < n; row++) {
            matrix[row] = reader.readLine().toCharArray();
        }

        findMouse(n, matrix);
        findCheese(n, matrix);

        String command = reader.readLine();
        while (!command.equals("end")) {

            if (command.equals("up")) {
                if (isOutBounds(playerRow - 1, playerCol, matrix)) {
                    outOfTerritory = true;
                    matrix[playerRow][playerCol] = '-';
                    break;
                } else {
                    if (matrix[playerRow - 1][playerCol] == 'c') {
                        eatenCheeses++;
                        allCheeses--;
                        matrix[playerRow][playerCol] = '-';
                        matrix[playerRow - 1][playerCol] = 'M';
                    } else if (matrix[playerRow - 1][playerCol] == 'B') {
                        matrix[playerRow - 1][playerCol] = '-';
                        if (matrix[playerRow - 2][playerCol] == 'c') {
                            eatenCheeses++;
                            allCheeses--;
                            matrix[playerRow][playerCol] = '-';
                            matrix[playerRow - 2][playerCol] = 'M';
                        } else if (matrix[playerRow - 2][playerCol] == '-') {
                            matrix[playerRow][playerCol] = '-';
                            matrix[playerRow - 2][playerCol] = 'M';
                        }
                    } else if (matrix[playerRow - 1][playerCol] == '-') {
                        matrix[playerRow][playerCol] = '-';
                        matrix[playerRow - 1][playerCol] = 'M';
                    }
                }
            }
            if (command.equals("down")) {
                if (isOutBounds(playerRow + 1, playerCol, matrix)) {
                    outOfTerritory = true;
                    matrix[playerRow][playerCol] = '-';
                    break;
                } else {
                    if (matrix[playerRow + 1][playerCol] == 'c') {
                        eatenCheeses++;
                        allCheeses--;
                        matrix[playerRow][playerCol] = '-';
                        matrix[playerRow + 1][playerCol] = 'M';
                    } else if (matrix[playerRow + 1][playerCol] == 'B') {
                        matrix[playerRow + 1][playerCol] = '-';
                        if (matrix[playerRow + 2][playerCol] == 'c') {
                            eatenCheeses++;
                            allCheeses--;
                            matrix[playerRow][playerCol] = '-';
                            matrix[playerRow + 2][playerCol] = 'M';
                        } else if (matrix[playerRow + 2][playerCol] == '-') {
                            matrix[playerRow][playerCol] = '-';
                            matrix[playerRow + 2][playerCol] = 'M';
                        }
                    } else if ((matrix[playerRow + 1][playerCol] == '-')) {
                        matrix[playerRow][playerCol] = '-';
                        matrix[playerRow + 1][playerCol] = 'M';
                    }
                }
            }
            if (command.equals("left")) {
                if (isOutBounds(playerRow, playerCol - 1, matrix)) {
                    outOfTerritory = true;
                    matrix[playerRow][playerCol] = '-';
                    break;
                } else {
                    if (matrix[playerRow][playerCol - 1] == 'c') {
                        eatenCheeses++;
                        allCheeses--;
                        matrix[playerRow][playerCol] = '-';
                        matrix[playerRow][playerCol - 1] = 'M';
                    } else if (matrix[playerRow][playerCol - 1] == 'B') {
                        matrix[playerRow][playerCol - 1] = '-';
                        if (matrix[playerRow][playerCol - 2] == 'c') {
                            eatenCheeses++;
                            allCheeses--;
                            matrix[playerRow][playerCol] = '-';
                            matrix[playerRow][playerCol - 2] = 'M';
                        } else if (matrix[playerRow][playerCol - 2] == '-') {
                            matrix[playerRow][playerCol] = '-';
                            matrix[playerRow][playerCol - 2] = 'M';
                        }
                    } else if ((matrix[playerRow][playerCol - 1] == '-')) {
                        matrix[playerRow][playerCol] = '-';
                        matrix[playerRow][playerCol - 1] = 'M';
                    }
                }
            }
            if (command.equals("right")) {
                if (isOutBounds(playerRow, playerCol + 1, matrix)) {
                    outOfTerritory = true;
                    matrix[playerRow][playerCol] = '-';
                    break;
                } else {
                    if (matrix[playerRow][playerCol + 1] == 'c') {
                        eatenCheeses++;
                        allCheeses--;
                        matrix[playerRow][playerCol] = '-';
                        matrix[playerRow][playerCol + 1] = 'M';
                    } else if (matrix[playerRow][playerCol + 1] == 'B') {
                        matrix[playerRow][playerCol + 1] = '-';
                        if (matrix[playerRow][playerCol + 2] == 'c') {
                            eatenCheeses++;
                            allCheeses--;
                            matrix[playerRow][playerCol] = '-';
                            matrix[playerRow][playerCol + 2] = 'M';
                        } else if (matrix[playerRow][playerCol + 2] == '-') {
                            matrix[playerRow][playerCol] = '-';
                            matrix[playerRow][playerCol + 2] = 'M';
                        }
                    } else if ((matrix[playerRow][playerCol + 1] == '-')) {
                        matrix[playerRow][playerCol] = '-';
                        matrix[playerRow][playerCol + 1] = 'M';
                    }
                }
            }
            findMouse(n, matrix);
            command = reader.readLine();
        }
        if (outOfTerritory) {
            System.out.println("Where is the mouse?");
        }
        if (eatenCheeses < 5) {
            int needed = 5 - eatenCheeses;
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", needed);
        } else {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", eatenCheeses);
        }
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

    private static void findCheese(int n, char[][] matrix) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == 'c') {
                    allCheeses++;
                }
            }
        }
    }

    private static void findMouse(int n, char[][] matrix) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == 'M') {
                    playerRow = row;
                    playerCol = col;
                }
            }
        }
    }
    public static boolean isOutBounds(int row, int col, char[][] matrix) {
        return row >= matrix.length || row < 0 ||
                col >= matrix[row].length || col < 0;
    }
}
