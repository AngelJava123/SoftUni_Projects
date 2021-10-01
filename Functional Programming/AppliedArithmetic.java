package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

public class AppliedArithmetic {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine(); //"1 2 3 4 5" -> split -> ["1", "2", "3", "4", "5"]
        int[] numbers = Arrays.stream(input.split("\\s+")).
                mapToInt(Integer::parseInt).toArray();

        //add -> adds 1: приема масив -> връща масив
        Function<int[], int[]> add = array -> Arrays.stream(array).map(number -> number += 1).toArray();

        //multiply -> multiply by 2: прием масив -> връща масив
        Function<int[], int[]> multiply = array -> Arrays.stream(array).map(number -> number *= 2).toArray();

        //subtract -> subtracts 1: приема масив -> връща масив
        Function<int[], int[]> subtract = array -> Arrays.stream(array).map(number -> number -= 1).toArray();

        //print -> print all elements: приема масив -> печата елементите
        Consumer<int[]> print = array -> Arrays.stream(array).forEach(number ->
                System.out.print(number + " "));

        String command = reader.readLine();
        while (!command.equals("end")) {
            //add, multiply, subtract, print

            switch (command) {
                case "add":
                    numbers = add.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiply.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtract.apply(numbers);
                    break;
                case "print":
                    print.accept(numbers);
                    System.out.println();
                    break;
            }
            command = reader.readLine();
        }
    }
}
