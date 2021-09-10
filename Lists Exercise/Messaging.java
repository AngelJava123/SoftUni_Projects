package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).
                map(Integer::parseInt).collect(Collectors.toList());

        String text = scanner.nextLine();
        List<String> splitText = new ArrayList<>(Arrays.asList(text.split("")));

        List<String> finalMessage = new ArrayList<>();
        int currentSum = 0;

        for (int i = 0; i < numbers.size(); i++) {
            int currentElement = numbers.get(i);

                while (currentElement > 0) {

                    int currentDivide = currentElement % 10;
                    currentSum += currentDivide;
                    currentElement =  currentElement / 10;
            }
                if (currentSum > splitText.size()) {
                    currentSum = currentSum - splitText.size();
                }
                finalMessage.add(splitText.get(currentSum));
                splitText.remove(currentSum);
                currentSum = 0;
        }
        for (String element:finalMessage) {
            System.out.print(element);
        }
    }
}



