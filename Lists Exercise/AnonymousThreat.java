package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("3:1")) {

            List<String> commands = Arrays.asList(command.split(" "));

            if (commands.get(0).equals("merge")) {
                int startIndex = Integer.parseInt(commands.get(1));
                int endNumber = Integer.parseInt(commands.get(2));
                if (startIndex < 0) {
                    startIndex = 0;
                }
                if (endNumber > input.size()-1) {
                    endNumber = input.size()-1;
                }

                if ((startIndex >= 0 && startIndex <= input.size()-1)
                        && (endNumber >= 0 && endNumber <= input.size()-1)) {
                    StringBuilder mergedString = new StringBuilder();
                    for (int i = startIndex; i <= endNumber; i++) {
                        mergedString.append(input.get(i));
                    }
                    for (int i = startIndex; i <= endNumber; i++) {
                        input.remove(startIndex);
                    }
                    input.add(startIndex, mergedString.toString());
                }
            } else if (commands.get(0).equals("divide")) {
                int index = Integer.parseInt(commands.get(1));
                int partitions = Integer.parseInt(commands.get(2));
                String elementForDivide = input.get(index);

                input.remove(index);

                int partSize = elementForDivide.length() / partitions;
                int begin = 0;

                for (int part = 1; part < partitions ; part++) {
                    input.add(index, elementForDivide.substring(begin, begin + partSize));
                    index++;
                    begin += partSize;
                }

                input.add(index, elementForDivide.substring(begin));
            }

            command = scanner.nextLine();
        }
        System.out.println(String.join(" ", input));
    }
}
