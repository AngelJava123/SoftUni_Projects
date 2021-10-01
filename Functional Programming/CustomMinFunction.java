package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class CustomMinFunction {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine(); //"1 4 3 2 1 7 13".split(" ") ->
        // ["1", "4", ....]

        List<Integer> numbers = Arrays.stream(input.split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toList());

        //начин 1
        //лист -> върнем мин число
        /*Function<List<Integer>, Integer> getMinNumber = List ->
        Collections.min(List);
        System.out.println(getMinNumber.apply(numbers));
         */

        //начин 2
        //лист -> отпечатваме мин число
        Consumer<List<Integer>> printMinNumbers = List ->
                System.out.println(Collections.min(List));
        printMinNumbers.accept(numbers);

        //начин 3
        // System.out.println(Collections.min(numbers))
    }
}
