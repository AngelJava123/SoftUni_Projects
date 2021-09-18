package com.company;

import java.util.Objects;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        String [][] firstMatrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] arr = scanner.nextLine().split("\\s+");

            firstMatrix[row] = arr;
        }
        String [][] secondMatrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] arr = scanner.nextLine().split("\\s+");

            secondMatrix[row] = arr;
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (!Objects.equals(firstMatrix[row][col], secondMatrix[row][col])) {
                    firstMatrix[row][col] = "*";
                }
            }
        }
        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {
                System.out.print(firstMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
