package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> numbers = new ArrayDeque<>();

        String[] numbs = scanner.nextLine().split(" ");

        for (String numb : numbs) {
            numbers.offer(numb);
        }
        while (!(numbers.size() == 1)) {
            int numb1 = Integer.parseInt(numbers.poll());
            String deli = numbers.poll();
            int numb2 = Integer.parseInt(numbers.poll());

            if (deli.equals("+")) {
                numbers.push(String.valueOf(numb1 + numb2));
            } else if (deli.equals("-")) {
                numbers.push(String.valueOf(numb1 - numb2));
            }
        }
        String value = numbers.pop();
        System.out.println(value);
    }
}
