package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        //name -> true/false
        //true: length <= n
        //false: length > n
        Predicate<String> validLength = name -> name.length() <= n;
        String[] names = reader.readLine().split("\\s+");//"Sara Sam George
        // Mark John".split -> ["Sara", "Sam", ...]

        Arrays.stream(names).filter(validLength).forEach(System.out::println);
        //filter -> true: остава; false: маха
        // оставя в списъка елементите, които отговяраят на дадено условие
    }
}
