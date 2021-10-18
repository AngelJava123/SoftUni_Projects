package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class MagicBox_STACK {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] first = Arrays.stream(reader.readLine().split("\\s+")).
                mapToInt(Integer::parseInt).toArray();

        int[] second = Arrays.stream(reader.readLine().split("\\s+")).
                mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> firstMagic = new ArrayDeque<>();
        ArrayDeque<Integer> secondMagic = new ArrayDeque<>();

        for (int i = 0; i < first.length; i++) {
            firstMagic.offer(first[i]);
        }
        for (int i = 0; i < second.length; i++) {
            secondMagic.push(second[i]);
        }

        int claimedItems = 0;

        while (!firstMagic.isEmpty() && !secondMagic.isEmpty()) {
            int firstValue = firstMagic.peek();
            int secondValue = secondMagic.peek();

            int sum = firstValue + secondValue;

            if (sum % 2 == 0) {
                firstMagic.poll();
                secondMagic.pop();
                claimedItems += sum;
            } else {
                secondMagic.pop();
                firstMagic.addLast(secondValue);
            }
        }
        if (firstMagic.isEmpty()) {
            System.out.println("First magic box is empty.");
        }
        if (secondMagic.isEmpty()) {
            System.out.println("Second magic box is empty.");
        }

        if (claimedItems >= 90) {
            System.out.println("Wow, your prey was epic! Value: " + claimedItems);
        } else {
            System.out.println("Poor prey... Value: " + claimedItems);
        }
    }
}
