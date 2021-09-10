package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).
                map(Integer::parseInt).collect(Collectors.toList());

        String commands = scanner.nextLine();
        while (!commands.equals("end")) {

            String[] commandsData = commands.split("\\s+");

            if (commandsData[0].equals("Contains")) {
                int number = Integer.parseInt(commandsData[1]);
                if (numbers.contains(number)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No such number");
                }
            } else if (commandsData[0].equals("Print")) {
                String oddOrEven = commandsData[1];

                if (oddOrEven.equals("even")) {
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) % 2 == 0) {
                            System.out.print(numbers.get(i) + " ");
                        }
                    }
                    System.out.println();
                } else if (oddOrEven.equals("odd")) {
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) % 2 != 0) {
                            System.out.print(numbers.get(i) + " ");
                        }
                    }
                    System.out.println();
                }
            } else if (commandsData[0].equals("Get")) {
                int sum = 0;
                for (int i = 0; i < numbers.size(); i++) {
                    sum += numbers.get(i);
                }
                System.out.println(sum);
            } else if (commandsData[0].equals("Filter")) {
                int number = Integer.parseInt(commandsData[2]);
                if (commandsData[1].equals("<")) {

                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) < number) {
                            System.out.print(numbers.get(i) + " ");
                        }
                    }
                    System.out.println();
                } else if (commandsData[1].equals(">")) {
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) > number) {
                            System.out.print(numbers.get(i) + " ");
                        }
                    }
                    System.out.println();
                } else if (commandsData[1].equals(">=")) {
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) >= number) {
                            System.out.print(numbers.get(i) + " ");
                        }
                    }
                    System.out.println();
                } else if (commandsData[1].equals("<=")) {
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) <= number) {
                            System.out.print(numbers.get(i) + " ");
                        }
                    }
                    System.out.println();
                }
            }
            commands = scanner.nextLine();
        }
    }
}
