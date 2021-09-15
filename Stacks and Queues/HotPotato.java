package com.company;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        ArrayDeque<String> names = new ArrayDeque<>(List.of(input));

        int n = Integer.parseInt(scanner.nextLine());

        int i = 1;
        while (names.size() > 1) {
           String person = names.poll();

            if (i == n) {
                System.out.println("Removed " + person);
                i = 0;
            } else {
                names.offer(person);
            }
            i += 1;
        }
        System.out.println("Last is " + names.pop());
    }
}
