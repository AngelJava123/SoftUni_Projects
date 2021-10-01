package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String inout = reader.readLine();//"1 2 3 4 5" -> split -> ["1", "2", "3", "4", "5"]

        List<Integer> numbers = Arrays.stream(inout.split("\\s+")).
                mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

        int n = Integer.parseInt(reader.readLine());

        //обръщаме списъка
        Collections.reverse(numbers);

        //премахваме всички числа, които се делят на n
        //приема число -> true / false
        Predicate<Integer> checkDivision = number -> number % n == 0;
        numbers.removeIf(checkDivision);

        numbers.forEach(number -> System.out.print(number + " "));

    }
}
