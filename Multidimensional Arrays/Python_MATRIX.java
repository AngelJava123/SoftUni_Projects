package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Python_MATRIX {
    static int snakeRow = 0;
    static int snakeCol = 0;
    static int willBeRow = 0;
    static int willBeCol = 0;
    static int eatenFood = 0;
    static int allFood = 0;
    static int length = 1;
    static boolean killedByAnEnemy = false;
    static boolean allFoodEaten = false;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        String[] commands = reader.readLine().split(",\\s+");

        char[][] matrix = new char[n][n];

        for (int i = 0; i < n; i++) {
            matrix[i] = reader.readLine().replaceAll(" ", "").toCharArray();
        }

        findSnakeAndFood(n, matrix);

        for (String command : commands) {

            if (command.equals("up")) {
                if (isOutBounds(snakeRow - 1, snakeCol, matrix)) {
                    snakeRow = n - 1;
                    willBeRow = n - 1;
                    if (matrix[snakeRow][snakeCol] == 'f') {
                        length++;
                        allFood--;
                        eatenFood++;
                    } else if (matrix[snakeRow][snakeCol] == 'e') {
                        killedByAnEnemy = true;
                        break;
                    }
                } else {
                    moveSnake(willBeRow - 1, willBeCol, matrix);
                    if (killedByAnEnemy) {
                        break;
                    } else {
                        willBeRow--;
                        snakeRow--;
                    }
                }
            }
            if (command.equals("down")) {
                if (isOutBounds(snakeRow + 1, snakeCol, matrix)) {
                    snakeRow = 0;
                    willBeRow = 0;
                    if (matrix[snakeRow][snakeCol] == 'f') {
                        length++;
                        allFood--;
                        eatenFood++;
                    } else if (matrix[snakeRow][snakeCol] == 'e') {
                        killedByAnEnemy = true;
                        break;
                    }
                } else {
                    moveSnake(willBeRow + 1, willBeCol, matrix);
                    if (killedByAnEnemy) {
                        break;
                    } else {
                        willBeRow++;
                        snakeRow++;
                    }
                }
            }
            if (command.equals("left")) {
                if (isOutBounds(snakeRow, snakeCol - 1, matrix)) {
                    snakeCol = n - 1;
                    willBeCol = n - 1;
                    if (matrix[snakeRow][snakeCol] == 'f') {
                        length++;
                        allFood--;
                        eatenFood++;
                    } else if (matrix[snakeRow][snakeCol] == 'e') {
                        killedByAnEnemy = true;
                        break;
                    }
                } else {
                    moveSnake(willBeRow, willBeCol - 1, matrix);
                    if (killedByAnEnemy) {
                        break;
                    } else {
                        willBeCol--;
                        snakeCol--;
                    }
                }
            }
            if (command.equals("right")) {
                if (isOutBounds(snakeRow, snakeCol + 1, matrix)) {
                    snakeCol = 0;
                    willBeCol = 0;
                    if (matrix[snakeRow][snakeCol] == 'f') {
                        length++;
                        allFood--;
                        eatenFood++;
                    } else if (matrix[snakeRow][snakeCol] == 'e') {
                        killedByAnEnemy = true;
                        break;
                    }
                } else {
                    moveSnake(willBeRow, willBeCol + 1, matrix);
                    if (killedByAnEnemy) {
                        break;
                    } else {
                        willBeCol++;
                        snakeCol++;
                    }
                }
            }
            if (allFood == 0) {
                allFoodEaten = true;
                break;
            }
        }
        if (killedByAnEnemy) {
            System.out.println("You lose! Killed by an enemy!");
            return;
        }
        if (allFoodEaten) {
            System.out.println("You win! Final python length is " + length);
        } else {
            System.out.println("You lose! There is still " + allFood + " food to be eaten.");
        }
    }

    private static void moveSnake(int willBeRow, int willBeCol, char[][] matrix) {
        if (matrix[willBeRow][willBeCol] == 'f') {
            allFood--;
            eatenFood++;
            length++;
        } else if (matrix[willBeRow][willBeCol] == 'e') {
            killedByAnEnemy = true;
        }
    }

    private static void findSnakeAndFood(int n, char[][] matrix) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == 's') {
                    snakeRow = row;
                    snakeCol = col;
                    willBeRow = row;
                    willBeCol = col;
                } else if (matrix[row][col] == 'f') {
                    allFood++;
                }
            }
        }
    }

    public static boolean isOutBounds(int row, int col, char[][] matrix) {
        return row >= matrix.length || row < 0 ||
                col >= matrix[row].length || col < 0;
    }
}
