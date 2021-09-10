package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> listOfWagons = Arrays.stream(scanner.nextLine().split("\\s+")).
                map(Integer::parseInt).collect(Collectors.toList());  // the number of passengers that
                                                                                 // are currently in each wagon

        int maxCapacity = Integer.parseInt(scanner.nextLine());  // the max capacity of each wagon

        String input = scanner.nextLine();
        while (!input.equals("end")) {

            List<String> inputData = Arrays.asList(input.split(" "));

            String commandType = inputData.get(0);

            if (commandType.equals("Add")) {
                int numberOfPassengers = Integer.parseInt(inputData.get(1));
                listOfWagons.add(numberOfPassengers);
            } else {
                int passengers = Integer.parseInt(inputData.get(0));
                for (int i = 0; i < listOfWagons.size(); i++) {
                    if (passengers + listOfWagons.get(i) <= maxCapacity) {
                        listOfWagons.set(i, passengers + listOfWagons.get(i));
                        break;
                    }
                }
            }
            input = scanner.nextLine();
        }
        for (Integer listOfWagon : listOfWagons) {
            System.out.print(listOfWagon + " ");
        }
    }
}
