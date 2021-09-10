package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).
                map(Integer::parseInt).collect(Collectors.toList());

        double totalLeftSum = 0;
        double totalRightSum = 0;

        for (int i = 0; i < numbers.size() / 2; i++) {

            if (numbers.get(i) == 0) {
                totalLeftSum *= 0.8;
            } else {
                totalLeftSum += numbers.get(i);
            }
        }
        for (int i = numbers.size()-1; i > numbers.size()/2; i--) {

            if (numbers.get(i) == 0) {
                totalRightSum *= 0.8;
            } else {
                totalRightSum += numbers.get(i);
            }
        }
        if (totalLeftSum < totalRightSum) {
            System.out.printf("The winner is left with total time: %.1f", totalLeftSum);
        } else {
            System.out.printf("The winner is right with total time: %.1f", totalRightSum);
        }
    }
}
