package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] first = Arrays.stream(scanner.nextLine().split("\\s+")).
                mapToInt(Integer::parseInt).toArray();

        int firstRows = first[0];
        int firstCols = first[1];

        int[][] firstMatrix = new int[firstRows][firstCols];

        for (int row = 0; row < firstRows; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            firstMatrix[row] = arr;
        }

        int[] second = Arrays.stream(scanner.nextLine().split("\\s+")).
                mapToInt(Integer::parseInt).toArray();

        int secondRows = second[0];
        int secondCols = second[1];

        int[][] secondMatrix = new int[secondRows][secondCols];

        for (int row = 0; row < secondRows; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            secondMatrix[row] = arr;
        }

        boolean areEqual = getEqualMatrices(firstMatrix, secondMatrix);

        if (areEqual) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    private static boolean getEqualMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }
        for (int row = 0; row < firstMatrix.length; row++) { // броя на масивите (редовете)
            if (firstMatrix[row].length != secondMatrix[row].length) {
                return false;
            }
            for (int col = 0; col < firstMatrix[row].length; col++) { // броя на елементите (колоните) във всеки масив
                if (firstMatrix[row][col] != secondMatrix[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }
}
