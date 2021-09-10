package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class MixedUpLists {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers1 = Arrays.stream(scanner.nextLine().split("\\s+")).
                map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> numbers2 = Arrays.stream(scanner.nextLine().split("\\s+")).
                map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> numbersAfterMixing = new ArrayList<>();

        List<Integer> finalResult = new ArrayList<>();

        int number1 = 0;
        int number2 = 0;

        int smallerSize = Math.min(numbers1.size(), numbers2.size());
        int biggerSize = Math.max(numbers1.size(), numbers2.size());

        Collections.reverse(numbers2);

        if (numbers1.size() == biggerSize) {
            number1 += numbers1.get(numbers1.size()-1);
            number2 += numbers1.get(numbers1.size()-2);
        } else {
            number1 += numbers2.get(numbers2.size()-1);
            number2 += numbers2.get(numbers2.size()-2);
        }

        for (int i = 0; i < smallerSize; i++) {
            numbersAfterMixing.add(numbers1.get(i));
            numbersAfterMixing.add(numbers2.get(i));
        }
        int smallerNumber = Math.min(number1,number2);
        int biggerNumber = Math.max(number1,number2);

        for (int i = 0; i < numbersAfterMixing.size(); i++) {
            if (numbersAfterMixing.get(i) > smallerNumber && numbersAfterMixing.get(i) < biggerNumber) {
                finalResult.add(numbersAfterMixing.get(i));
            }
        }
        Collections.sort(finalResult);
        System.out.println(finalResult.toString().replace("[", "").
                replace("]", "").
                replace(",", ""));
               // trim().
               // replaceAll(" \\s+", " "));
    }
}

