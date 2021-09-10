package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> sequence = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        int valueOfRemovedElements = 0;
        while (!sequence.isEmpty()) {
            int index = Integer.parseInt(scanner.nextLine());
            int indexToRemove = 0;
            if (index < 0) {
                indexToRemove = sequence.remove(0);
                valueOfRemovedElements += indexToRemove;
                sequence.add(0, sequence.get(sequence.size() - 1));
            } else if (index > sequence.size() - 1) {
                indexToRemove = sequence.remove(sequence.size() - 1);
                sequence.add(sequence.get(0));
                valueOfRemovedElements += indexToRemove;
            } else {
                indexToRemove = sequence.remove(index);
                valueOfRemovedElements += indexToRemove;
            }
            for (int i = 0; i < sequence.size(); i++) {
                if (sequence.get(i) <= indexToRemove) {
                    sequence.set(i, sequence.get(i) + indexToRemove);
                } else {
                    sequence.set(i, sequence.get(i) - indexToRemove);
                }
            }
        }
        System.out.println(valueOfRemovedElements);
    }
}
