package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RecursiveArraySum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int sum = sumArr(arr, 0);
        System.out.println(sum);
    }

    private static int sumArr(int[] arr, int index) {
        if (index == arr.length) {
            return 0;
        }
        return arr[index] + sumArr(arr, index + 1);
    }
}
