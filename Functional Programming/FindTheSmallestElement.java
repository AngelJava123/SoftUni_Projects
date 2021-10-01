package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        //начин 1
        //приемаме списък -> отпечатваме индексът на най-малкото число
        /* Consumer<List<Integer>> printIndexOfMinElement = List -> {
        int min = Collections.min(List);
        System.out.println(List.LastIndexOf(min)); };

        printIndexOfMinElement.accept(numbers);
         */

        //приемаме списък -> връщаме индексът на най-малкото число
        Function<List<Integer>, Integer> getIndexOfMinElement = list ->
                list.lastIndexOf(Collections.min(list));
        System.out.println(getIndexOfMinElement.apply(numbers));
    }
}
