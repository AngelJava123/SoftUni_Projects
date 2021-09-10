package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).
                map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("End")) {

            List<String> inputData = Arrays.asList(input.split("\\s+"));

            if (inputData.get(0).equals("Add")) {

                int commandNumber = Integer.parseInt(inputData.get(1));
                numbers.add(commandNumber);

            } else if (inputData.get(0).equals("Insert")) {

                int numberToAdd = Integer.parseInt(inputData.get(1));
                int indexToAdd = Integer.parseInt(inputData.get(2));

                if (indexToAdd >= 0 && indexToAdd <= numbers.size() - 1) {
                    numbers.add(indexToAdd, numberToAdd);
                } else {
                    System.out.println("Invalid index");
                }
            } else if (inputData.get(0).equals("Remove")) {
                int numberToRemove = Integer.parseInt(inputData.get(1));
                if (numberToRemove >= 0 && numberToRemove <= numbers.size() - 1) {
                    numbers.remove(numberToRemove);
                } else {
                    System.out.println("Invalid index");
                }
            } else if (inputData.get(0).equals("Shift")) {
                int count = Integer.parseInt(inputData.get(2));
                if (inputData.get(1).equals("left")) {

                    for (int i = 0; i < count; i++) {
                        int firstNumber = numbers.get(0);
                        numbers.add(firstNumber);
                        numbers.remove(0);
                    }
                } else if (inputData.get(1).equals("right")) {
                    for (int i = 0; i < count; i++) {
                        int lastNumber = numbers.get(numbers.size()-1);
                        numbers.add(0,lastNumber);
                        numbers.remove(numbers.size()-1);
                    }
                }
            }
            input = scanner.nextLine();
        }
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + " ");
        }
    }
}
