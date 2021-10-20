package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecursiveFactorial {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        int sum = sumN(n);
        System.out.println(sum);
    }

    private static int sumN(int n) {
        if (n == 0) {
            return 1;
        }
        return n * sumN(n - 1);
    }
}
