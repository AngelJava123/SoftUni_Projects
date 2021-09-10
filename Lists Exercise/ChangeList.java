package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers  = Arrays.stream(scanner.nextLine().split(" ")).
                map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("end")) {

            List<String> commands = Arrays.asList(command.split(" "));

            String commandType = commands.get(0);

            if (commandType.equals("Delete")) {
                int number = Integer.parseInt(commands.get(1));
                numbers.removeIf(element -> number == element);
            } else if (commandType.equals("Insert")) {
                int element = Integer.parseInt(commands.get(1));
                int index = Integer.parseInt(commands.get(2));
                numbers.add(index,element);
            }
            command = scanner.nextLine();
        }
        for (Integer element:numbers) {
            System.out.print(element + " ");
        }
    }
}
