package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SortingMapByValueListCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Map with value list -> sorting by count of list elements
        Map<String, List<String>> map = new HashMap<>();
        map.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().size() - a.getValue().size())
                .forEach(pair -> {
                    System.out.println(pair.getKey());
                    pair.getValue().forEach(el -> System.out.println(el));
                });
    }
}
