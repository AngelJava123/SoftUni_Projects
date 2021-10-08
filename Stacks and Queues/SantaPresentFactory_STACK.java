package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class SantaPresentFactory_STACK {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] material = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int[] magic = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> materials = new ArrayDeque<>();
        ArrayDeque<Integer> magicValues = new ArrayDeque<>();

        for (int i = 0; i < material.length; i++) {
            materials.push(material[i]);
        }
        for (int i = 0; i < magic.length; i++) {
            magicValues.offer(magic[i]);
        }
        int doll = 0;
        int train = 0;
        int bear = 0;
        int bicycle = 0;

        boolean isZero = false;
        while (!materials.isEmpty() && !magicValues.isEmpty()) {

            int materialNumber = materials.peek();
            int magicNumber = magicValues.peek();

            if (materialNumber == 0) {
                materials.pop();
                isZero = true;
            }
            if (magicNumber == 0) {
                magicValues.poll();
                isZero = true;
            }
            if (isZero) {
                isZero = false;
                continue;
            }
            int sumValue = magicNumber * materialNumber;

            if (sumValue < 0) {
                int sum = magicNumber + materialNumber;
                materials.pop();
                magicValues.poll();
                materials.push(sum);
                continue;
            }
            if (sumValue != 150 && sumValue != 250 && sumValue != 300 && sumValue != 400) {
                magicValues.poll();
                materials.pop();
                int increasedNumber = materialNumber + 15;
                materials.push(increasedNumber);
                continue;
            }
            if (sumValue == 150) {
                materials.pop();
                magicValues.poll();
                doll++;
            }
            if (sumValue == 250) {
                materials.pop();
                magicValues.poll();
                train++;
            }
            if (sumValue == 300) {
                materials.pop();
                magicValues.poll();
                bear++;
            }
            if (sumValue == 400) {
                materials.pop();
                magicValues.poll();
                bicycle++;
            }
        }
        if (doll > 0 && train > 0 || bear > 0 && bicycle > 0) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }
        if (!materials.isEmpty()) {
            System.out.println("Materials left: " + materials.toString().
                    replaceAll("\\[", "").replaceAll("]", ""));
        }
        if (!magicValues.isEmpty()) {
            System.out.println("Magic left: " + magicValues.toString().
                    replaceAll("\\[", "").replaceAll("]", ""));
        }

        Map<String, Integer> result = new TreeMap<>();

        if (doll > 0) {
            result.put("Doll", doll);
        }
        if (train > 0) {
            result.put("Wooden train", train);
        }
        if (bear > 0) {
            result.put("Teddy bear", bear);
        }
        if (bicycle > 0) {
            result.put("Bicycle", bicycle);
        }
        result.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
