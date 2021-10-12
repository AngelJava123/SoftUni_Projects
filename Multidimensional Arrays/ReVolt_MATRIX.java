package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReVolt_MATRIX {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());

        char[][] matrix = new char[n][n];

        for (int row = 0; row < n; row++) {
            char[] symbols = reader.readLine().toCharArray();

            matrix[row] = symbols;
        }

        int playerRow = 0;
        int playerCol = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == 'f') {
                    playerRow = row;
                    playerCol = col;
                }
            }
        }
        boolean hasWon = false;

        while (m-- > 0) {
            String command = reader.readLine();

            if (command.equals("up")) {
                if (isOutBounds(playerRow - 1, playerCol, matrix)) {
                    if (matrix[n - 1][playerCol] == 'T') {
                    } else if (matrix[n - 1][playerCol] == 'B') {
                        matrix[playerRow][playerCol] = '-';
                        playerRow = n - 2;
                        matrix[playerRow][playerCol] = 'f';
                    } else if (matrix[n - 1][playerCol] == 'F') {
                        matrix[playerRow][playerCol] = '-';
                        matrix[n - 1][playerCol] = 'f';
                        hasWon = true;
                        break;
                    } else if (matrix[n - 1][playerCol] == '-') {
                        matrix[playerRow][playerCol] = '-';
                        matrix[n - 1][playerCol] = 'f';
                        playerRow = n - 1;
                    }
                } else {
                    if (matrix[playerRow - 1][playerCol] == 'T') {
                    } else if (matrix[playerRow - 1][playerCol] == 'B') {
                        matrix[playerRow][playerCol] = '-';
                        matrix[playerRow - 1][playerCol] = 'f';
                        playerRow--;
                        if (isOutBounds(playerRow - 1, playerCol, matrix)) {
                            playerRow = n - 1;
                        } else {
                            playerRow--;
                        }
                        matrix[playerRow][playerCol] = 'f';
                    } else if (matrix[playerRow - 1][playerCol] == 'F') {
                        matrix[playerRow][playerCol] = '-';
                        matrix[playerRow - 1][playerCol] = 'f';
                        hasWon = true;
                        break;
                    } else if (matrix[playerRow - 1][playerCol] == '-') {
                        matrix[playerRow][playerCol] = '-';
                        matrix[playerRow - 1][playerCol] = 'f';
                        playerRow--;
                    }
                }
            }
            if (command.equals("down")) {
                if (isOutBounds(playerRow + 1, playerCol, matrix)) {
                    if (matrix[0][playerCol] == 'T') {
                    } else if (matrix[0][playerCol] == 'B') {
                        matrix[playerRow][playerCol] = '-';
                        playerRow = 1;
                        matrix[playerRow][playerCol] = 'f';
                    } else if (matrix[0][playerCol] == 'F') {
                        matrix[playerRow][playerCol] = '-';
                        matrix[0][playerCol] = 'f';
                        hasWon = true;
                        break;
                    } else if (matrix[0][playerCol] == '-') {
                        matrix[playerRow][playerCol] = '-';
                        matrix[0][playerCol] = 'f';
                        playerRow = 0;
                    }
                } else {
                    if (matrix[playerRow + 1][playerCol] == 'T') {
                    } else if (matrix[playerRow + 1][playerCol] == 'B') {
                        matrix[playerRow][playerCol] = '-';
                        playerRow++;
                        if (isOutBounds(playerRow + 1, playerCol, matrix)) {
                            playerRow = 0;
                            matrix[playerRow][playerCol] = 'f';
                        } else {
                            matrix[playerRow + 1][playerCol] = 'f';
                            playerRow++;
                        }
                    } else if (matrix[playerRow + 1][playerCol] == 'F') {
                        matrix[playerRow][playerCol] = '-';
                        matrix[playerRow + 1][playerCol] = 'f';
                        hasWon = true;
                        break;
                    } else if (matrix[playerRow + 1][playerCol] == '-') {
                        matrix[playerRow][playerCol] = '-';
                        matrix[playerRow + 1][playerCol] = 'f';
                        playerRow++;
                    }
                }
            }
            if (command.equals("left")) {
                if (isOutBounds(playerRow, playerCol - 1, matrix)) {
                    if (matrix[playerRow][n - 1] == 'T') {
                    } else if (matrix[playerRow][n - 1] == 'B') {
                        matrix[playerRow][playerCol] = '-';
                        playerCol = n - 2;
                        matrix[playerRow][playerCol] = 'f';
                    } else if (matrix[playerRow][n - 1] == 'F') {
                        matrix[playerRow][playerCol] = '-';
                        matrix[playerRow][n - 1] = 'f';
                        hasWon = true;
                        break;
                    } else if (matrix[playerRow][n - 1] == '-') {
                        matrix[playerRow][playerCol] = '-';
                        matrix[playerRow][n - 1] = 'f';
                        playerRow = n - 1;
                    }
                } else {
                    if (matrix[playerRow][playerCol - 1] == 'T') {
                    } else if (matrix[playerRow][playerCol - 1] == 'B') {
                        matrix[playerRow][playerCol] = '-';
                        playerCol--;
                        if (isOutBounds(playerRow, playerCol - 1, matrix)) {
                            if (matrix[playerRow][n - 1] == 'F') {
                                matrix[playerRow][n - 1] = 'f';
                                hasWon = true;
                                break;
                            }
                            playerCol = n - 1;
                        } else {
                            playerCol--;
                        }
                        matrix[playerRow][playerCol] = 'f';
                    } else if (matrix[playerRow][playerCol - 1] == 'F') {
                        matrix[playerRow][playerCol] = '-';
                        matrix[playerRow][playerCol - 1] = 'f';
                        hasWon = true;
                        break;
                    } else if (matrix[playerRow][playerCol - 1] == '-') {
                        matrix[playerRow][playerCol] = '-';
                        matrix[playerRow][playerCol - 1] = 'f';
                        playerCol--;
                    }
                }
            }
            if (command.equals("right")) {
                if (isOutBounds(playerRow, playerCol + 1, matrix)) {
                    if (matrix[playerRow][0] == 'T') {
                    } else if (matrix[playerRow][0] == 'B') {
                        matrix[playerRow][0] = '-';
                        playerCol = 2;
                        matrix[playerRow][playerCol] = 'f';
                    } else if (matrix[playerRow][0] == 'F') {
                        matrix[playerRow][playerCol] = '-';
                        matrix[playerRow][0] = 'f';
                        hasWon = true;
                        break;
                    } else if (matrix[playerRow][0] == '-') {
                        matrix[playerRow][playerCol] = '-';
                        matrix[playerRow][0] = 'f';
                        playerCol = 0;
                    }
                } else {
                    if (matrix[playerRow][playerCol + 1] == 'T') {
                    } else if (matrix[playerRow][playerCol + 1] == 'B') {
                        matrix[playerRow][playerCol] = '-';
                        playerCol++;
                        if (isOutBounds(playerRow, playerCol + 1, matrix)) {
                            playerCol = 0;
                        } else {
                            playerCol++;
                        }
                        matrix[playerRow][playerCol] = 'f';
                    } else if (matrix[playerRow][playerCol + 1] == 'F') {
                        matrix[playerRow][playerCol] = '-';
                        matrix[playerRow][playerCol + 1] = 'f';
                        hasWon = true;
                        break;
                    } else if (matrix[playerRow][playerCol + 1] == '-') {
                        matrix[playerRow][playerCol] = '-';
                        matrix[playerRow][playerCol + 1] = 'f';
                        playerCol++;
                    }
                }
            }
        }
        if (hasWon) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    public static boolean isOutBounds(int row, int col, char[][] matrix) {
        return row >= matrix.length || row < 0 ||
                col >= matrix[row].length || col < 0;
    }
}
