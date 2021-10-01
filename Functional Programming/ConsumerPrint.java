package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Function <приема, връща -> apply
        // Consumer <приема> -> void -> accept
        // Supplier <връща> -> get
        // Predicate <приема> -> false / true -> test
        // BiFunction <приема1, приема2, връща> -> apply

        String input = reader.readLine(); //"Peter George Alex"
        String[] names = input.split("\\s+"); //["Peter", "George", "Alex"]

        //начин 1:
        /* for (String name: names) {
               system.out.println(name);
            }*/

        //начин 2:
        // name -> печатане
        /* Consumer<String> printName = name -> System.out.println(name);
        for (String name : names) {
             printName.accept(name);
         */

        //начин 3
        //масив в имена -> печата
        Consumer<String> printName = System.out::println;
        Consumer<String[]> printNames = array -> {
            for (String name : array) {
                printName.accept(name);
            }
        };
        printNames.accept(names);
    }
}
