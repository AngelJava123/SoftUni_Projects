package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LootBox_STACK {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] first = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int[] second = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> firstBox = new ArrayDeque<>();
        ArrayDeque<Integer> secondBox = new ArrayDeque<>();

        Arrays.stream(first).forEach(firstBox::offer);
        Arrays.stream(second).forEach(secondBox::push);

        List<Integer> claimedItems = new ArrayList<>();

        while (!firstBox.isEmpty() && !secondBox.isEmpty()) {

            int firstNumber = firstBox.peek();
            int secondNumber = secondBox.peek();

            int sum = firstNumber + secondNumber;

            if (sum % 2 == 0) {
                claimedItems.add(sum);
                firstBox.poll();
                secondBox.pop();
            } else {
                int item = secondBox.removeFirst();
                firstBox.offerLast(item);
            }
        }
        if (firstBox.isEmpty()) {
            System.out.println("First lootbox is empty");
        }
        if (secondBox.isEmpty()) {
            System.out.println("Second lootbox is empty");
        }
        int count = claimedItems.stream().mapToInt(i -> i).sum();

        if (count >= 100) {
            System.out.printf("Your loot was epic! Value: %d", count);
        } else {
            System.out.printf("Your loot was poor... Value: %d", count);
        }
    }
}
