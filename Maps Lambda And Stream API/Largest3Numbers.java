package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> sorted = Arrays.stream(scanner.nextLine()
                .split(" ")).map(Integer::parseInt).sorted(Comparator.reverseOrder()).
                collect(Collectors.toList());


        if (sorted.size() < 3) {
            for (int i = 0; i < sorted.size(); i++) {
                System.out.print(sorted.get(i) + " ");
            }
        } else {
            for (int i = 0; i < 3; i++) {
                System.out.print(sorted.get(i) + " ");
            }
        }
    }
}
