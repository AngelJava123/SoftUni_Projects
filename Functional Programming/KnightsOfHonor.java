package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine(); // "Peter George Alex"
        String[] names = input.split("\\s+"); //["Peter", "George", "Alex"]

        //name -> отпечатвам Sir + name
        Consumer<String> printName = name -> System.out.println("Sir " + name);
        Arrays.stream(names).forEach(printName);

        /* for (String name : names) {
        printName.accept(name);
         */
    }
}
