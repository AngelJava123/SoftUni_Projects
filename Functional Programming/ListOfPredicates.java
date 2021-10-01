package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class ListOfPredicates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        List<Integer> numbersForDivision = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        //приема лист с числа и число -> връща true/false
        //true -> числото се дели на всички числа
        //false -> числото не се дели на всички числа
        BiFunction<List<Integer>, Integer, Boolean> isDivisible = ((list, number) -> {
            for (int numberInList : list) {
                if (number % numberInList != 0) {
                    return false;
                }
            }
            return true;
        });

        //Всички числа от 1 до n
        for (int number = 1; number <= n ; number++) {
            //проверка дали се дели на всички дадени числа
            if (isDivisible.apply(numbersForDivision, number)) {
                System.out.print(number + " ");
            }

        }
    }
}
