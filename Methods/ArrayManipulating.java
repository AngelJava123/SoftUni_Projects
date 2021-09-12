package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulating {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).
                mapToInt(Integer::parseInt).toArray();

        String input = scanner.nextLine();

        while (!input.equals("end")) {

            String [] commands = input.split(" ");
            String typeCommand = commands[0];

            switch (typeCommand) {
                case "exchange":
                    int exchangeIndex = Integer.parseInt(commands[1]);
                    if (isValidIndex(exchangeIndex, numbers.length)) {
                        numbers = exchange(numbers, exchangeIndex);
                    } else  {
                        System.out.println("Invalid index");
                    }
                    break;
                case "max":
                    String evenOrOdd = commands[1];
                    if(evenOrOdd.equals("even")) {
                        printIndexMaxEvenNumber(numbers);
                    } else if (evenOrOdd.equals("odd")) {
                        printIndexMaxOddNumber(numbers);
                    }
                    break;
                case "min":
                    String minEvenOrrOdd = commands[1];
                    if (minEvenOrrOdd.equals("even")) {
                        printIndexMinEvenNumber(numbers);
                    } else if (minEvenOrrOdd.equals("odd")) {
                        printIndexMinOddNumber(numbers);
                    }
                    break;
                case "first":
                    int count =Integer.parseInt(commands[1]);
                    if (!isValidCount(count, numbers.length)) {
                        System.out.println("Invalid count");
                        input = scanner.nextLine();
                        continue;
                    }
                    String firstEvenOrOdd = commands[2];
                    if (firstEvenOrOdd.equals("even")) {
                        printFirstEven(numbers, count);
                    } else if (firstEvenOrOdd.equals("odd")) {
                        printFirstOdd(numbers, count);
                    }
                    break;
                case "last":
                    int countLast =Integer.parseInt(commands[1]);
                    if (!isValidCount(countLast, numbers.length)) {
                        System.out.println("Invalid count");
                        input = scanner.nextLine();
                        continue;
                    }
                    String lastEvenOrrOdd = commands[2];
                    if (lastEvenOrrOdd.equals("even")) {
                        printLastEven(numbers, countLast);
                    } else if (lastEvenOrrOdd.equals("odd")) {
                        printLastOdd(numbers, countLast);
                    }
            }
            input = scanner.nextLine();
        }
        System.out.print("[");
        for (int i = 0; i <= numbers.length-1 ; i++) {
            if (i == numbers.length-1) {
                System.out.print(numbers[i]);
            } else {
                System.out.print(numbers[i] + ", ");
            }
        }
        System.out.print("]");
    }

    private static boolean isValidCount(int count, int length) {
        return count <= length;
    }

    private static void printLastOdd(int[] numbers, int countLast) {
        String lastOdd = "";
        for (int i = numbers.length-1; i >= 0 ; i--) {
            int currentElement = numbers[i];
            if (currentElement % 2 == 1) {
                lastOdd += currentElement;
                countLast--;
            }
            if (currentElement == 0) {
                break;
            }
        }
        System.out.println("[");
        for (int i = lastOdd.length()-1; i >= 0 ; i++) {
            if (i == 0) {
                System.out.println(lastOdd.charAt(i));
            } else {
                System.out.println(lastOdd.charAt(i) + ", ");
            }

        }
        System.out.println("]");
    }

    private static void printLastEven(int[] numbers, int countLast) {
        String lastEven = "";
        for (int i = numbers.length-1; i >= 0 ; i--) {
            int currentElement = numbers[i];
            if (currentElement % 2 == 0) {
                lastEven += currentElement;
                countLast--;
            }
            if (currentElement == 0) {
                break;
            }
        }
        System.out.println("[");
        for (int i = lastEven.length()-1; i >= 0 ; i++) {
            if (i == 0) {
                System.out.println(lastEven.charAt(i));
            } else {
                System.out.println(lastEven.charAt(i) + ", ");
            }

        }
        System.out.println("]");


    }

    private static void printFirstOdd(int[] numbers, int count) {
        StringBuilder output = new StringBuilder();
        output.append("[");
        for (int i = 0; i < numbers.length-1; i++) {
            int currentNumber = numbers[i];
            if (currentNumber % 2 == 1) {
                output.append(currentNumber).append(", ");
                count--;
            }
            if (count == 0) {
                break;
            }
            output.append(", ");
        }
        output.append("]");

        System.out.println(output.toString());
    }

    private static void printFirstEven(int[] numbers, int count) {
        StringBuilder output = new StringBuilder();
        output.append("[");
        for (int i = 0; i < numbers.length-1; i++) {
            int currentNumber = numbers[i];
            if (currentNumber % 2 == 0) {
                output.append(currentNumber).append(", ");
                count--;
            }
            if (count == 0) {
                break;
            }
            output.append(", ");
        }
        output.append("]");

        System.out.println(output.toString());
    }

    private static void printIndexMinOddNumber(int[] numbers) {
        int minOdd = Integer.MAX_VALUE;
        int indexMinOdd = -1;

        for (int i = 0; i <= numbers.length- 1 ; i++) {
            int currentElement = numbers[i];
            if (currentElement % 2 == 0 && currentElement <= minOdd) {
                minOdd = currentElement;
                indexMinOdd = i;
            }
        }
        if (indexMinOdd == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(indexMinOdd);
        }
    }

    private static void printIndexMinEvenNumber(int[] numbers) {
        int minEven = Integer.MAX_VALUE;
        int indexMinEven = -1;

        for (int i = 0; i <= numbers.length- 1 ; i++) {
            int currentElement = numbers[i];
            if (currentElement % 2 == 0 && currentElement <= minEven) {
                minEven = currentElement;
                indexMinEven = i;
            }
        }
        if (indexMinEven == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(indexMinEven);
        }
    }

    private static void printIndexMaxOddNumber(int[] numbers) {
        int maxOdd = Integer.MIN_VALUE;
        int indexMaxOdd = -1;
        for (int index = 0; index <= numbers.length - 1 ; index++) {
            int currentNumber = numbers[index];
            if (currentNumber % 2 == 0 && currentNumber >= maxOdd) {
                maxOdd = currentNumber;
                indexMaxOdd = index;
            }
        }
        if(indexMaxOdd == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(indexMaxOdd);
        }
    }

    private static void printIndexMaxEvenNumber(int[] numbers) {
        int maxEven = Integer.MIN_VALUE;
        int indexMaxEven = -1;
        for (int index = 0; index <= numbers.length - 1 ; index++) {
            int currentNumber = numbers[index];
            if (currentNumber % 2 == 0 && currentNumber >= maxEven) {
                maxEven = currentNumber;
                indexMaxEven = index;
            }
        }
        if(indexMaxEven == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(indexMaxEven);
        }
    }

    private static int[] exchange(int[] numbers, int exchangeIndex) {

        int [] numbersToExchangeIndex = new int [exchangeIndex + 1];
        int [] numbersAfterExchangeIndex = new int [numbers.length - exchangeIndex - 1];

        for (int index = 0; index < exchangeIndex; index++) {
            int currentElement = numbers[index];
            numbersToExchangeIndex[index] = currentElement;
        }

        for (int index = exchangeIndex + 1; index < numbers.length - 1 ; index++) {
            int currentElement = numbers[index];
            numbersAfterExchangeIndex[index - exchangeIndex - 1] = currentElement;
        }

        int [] exchangedArray = new int [numbers.length];
        for (int index = 0; index <= numbersAfterExchangeIndex.length - 1; index++) {
            exchangedArray[index] = numbersAfterExchangeIndex[index];
        }
        for (int index = numbersAfterExchangeIndex.length; index <= exchangedArray.length - 1  ; index++) {
            exchangedArray[index] = numbersToExchangeIndex [index - numbersAfterExchangeIndex.length];
        }
        return exchangedArray;
    }

    private static boolean isValidIndex( int index, int length) {
        return index >= 0 && index <= length - 1;
    }
}
