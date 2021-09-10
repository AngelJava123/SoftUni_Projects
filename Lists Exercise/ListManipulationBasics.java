package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> numbers = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("end")) {

            String[] tokens = command.split(" ");

            switch (tokens[0]) {
                case "Add":
                    String numberToAdd = (tokens[1]);
                    numbers.add(numberToAdd);
                    break;
                case "Remove":
                    String numbersToRemove = (tokens[1]);
                    numbers.remove(numbersToRemove);
                    break;
                case "RemoveAt":
                    int indexToRemove = Integer.parseInt(tokens[1]);
                    numbers.remove(indexToRemove);
                    break;
                case "Insert":
                    String numbersToInsert = (tokens[1]);
                    int indexToInsert = Integer.parseInt(tokens[2]);
                    numbers.add(indexToInsert,numbersToInsert);
                    break;
            }

            command = scanner.nextLine();
        }
        System.out.println(numbers.toString().
                replaceAll("[\\[\\],]",""));
    }
}
