package com.company;

import java.util.*;

public class WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, List<String>> words = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();

            words. putIfAbsent(word, new ArrayList<>());
            words.get(word).add(synonym);
        }
        final StringBuilder stringBuilder = new StringBuilder();

        for (Map.Entry<String, List<String>> entry: words.entrySet()) {
            String word = entry.getKey();
            List<String> synonym = entry.getValue();
            stringBuilder.append(String.format("%s - %s%n", word, synonym).
                                     replaceAll("\\[", "").
                                     replaceAll("\\]", ""));
        }
        System.out.println(stringBuilder);
    }
}
