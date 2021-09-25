package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Set<String> carNumbers = new LinkedHashSet<>();

        String input = reader.readLine();
        while (!input.equals("END")) {

            String[] inputData = input.split(", ");

            String command = inputData[0];
            String carNumber = inputData[1];

            if (command.equals("IN")) {
                carNumbers.add(carNumber);
            } else if (command.equals("OUT")) {
                carNumbers.remove(carNumber);
            }
            input = reader.readLine();
        }
        if (carNumbers.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            carNumbers.forEach(System.out::println);
        }
    }
}
