package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class VoinaNumberGame {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Set<Integer> firstPlayerDeck = new LinkedHashSet<>();
        Set<Integer> secondPlayerDeck = new LinkedHashSet<>();

        int[] numbers1 = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int[] numbers2 = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        for (int number : numbers1) {
            firstPlayerDeck.add(number);
        }
        for (int number : numbers2) {
            secondPlayerDeck.add(number);
        }

        int n = 50;
        while (n-- > 0) {
            int first = firstPlayerDeck.iterator().next();
            int second = secondPlayerDeck.iterator().next();

            firstPlayerDeck.remove(first);
            secondPlayerDeck.remove(second);

            if (first > second) {
                firstPlayerDeck.add(first);
                firstPlayerDeck.add(second);
            } else if (first < second) {
                secondPlayerDeck.add(first);
                secondPlayerDeck.add(second);
            }
            if (firstPlayerDeck.isEmpty() || secondPlayerDeck.isEmpty()) {
                break;
            }
        }
        if (firstPlayerDeck.size() < secondPlayerDeck.size()) {
            System.out.println("Second player win!");
        } else if (secondPlayerDeck.size() < firstPlayerDeck.size()) {
            System.out.println("First player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
