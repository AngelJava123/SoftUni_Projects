package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ParkingSystem {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] dimensions = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        boolean[][] matrix = new boolean[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i][0] = true;
        }

        String input = reader.readLine();
        while (!input.equals("stop")) {

            String[] inputData = input.split("\\s+");

            int startRow = Integer.parseInt(inputData[0]); // z
            int desiredRow = Integer.parseInt(inputData[1]); // x
            int desiredCol = Integer.parseInt(inputData[2]); // y

            boolean hasFoundFreePlace = false;
            int travelledDistance = 1;

            travelledDistance += Math.abs(desiredRow - startRow);

            if (!matrix[desiredRow][desiredCol]) {
                travelledDistance += desiredCol;
                matrix[desiredRow][desiredCol] = true;
                hasFoundFreePlace = true;
            } else {
                for (int i = 1; i < matrix[desiredRow].length; i++) {
                    if (desiredCol - i > 0 && !matrix[desiredRow][desiredCol - i]) {
                        matrix[desiredRow][desiredCol - i] = true;
                        hasFoundFreePlace = true;
                        travelledDistance += desiredCol - i;
                        break;
                    }
                    if (desiredCol + i < matrix[desiredRow].length
                            && !matrix[desiredRow][desiredCol + i]) {
                        matrix[desiredRow][desiredCol + i] = true;
                        hasFoundFreePlace = true;
                        travelledDistance += desiredCol + i;
                        break;
                    }
                }
            }
            if (hasFoundFreePlace) {
                System.out.println(travelledDistance);
            } else {
                System.out.printf("Row %d full%n", desiredRow);
            }
            input = reader.readLine();
        }
    }
}
