package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers =Arrays.stream(scanner.nextLine().split(" ")).
                map(Integer::parseInt).collect(Collectors.toList());

        removeNegativeNumbers(numbers);

        if (numbers.isEmpty()) {
            System.out.println("empty");
        } else {
            Collections.reverse(numbers);
            System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
        }
    }

    private static void removeNegativeNumbers(List<Integer> list) {

        for (int i = 0; i < list.size() ; i++) {
            int element  = list.get(i);
            if (element < 0) {
                list.remove(i);
                i--;
            }
        }
    }
}
