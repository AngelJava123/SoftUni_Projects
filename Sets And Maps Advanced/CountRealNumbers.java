package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class CountRealNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<Double, Integer> numbers = new LinkedHashMap<>();

        double[] number = Arrays.stream(reader.readLine().split("\\s+")).
                mapToDouble(Double::parseDouble).toArray();

        for (double numb : number) {
            if (!numbers.containsKey(numb)) {
                numbers.put(numb, 1);
            } else {
                numbers.put(numb, numbers.get(numb) + 1);
            }
        }
        numbers.forEach((aDouble, integer) -> System.out.println(String.format("%.1f -> %d", aDouble, integer)));
    }
}
