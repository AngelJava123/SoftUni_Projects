package com.company;

import java.math.BigInteger;
import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger number1 = new BigInteger(scanner.nextLine());
        int number2 = Integer.parseInt(scanner.nextLine());

        BigInteger multipliedNumbers = number1.multiply(BigInteger.valueOf(number2));
        System.out.println(multipliedNumbers);
    }
}
