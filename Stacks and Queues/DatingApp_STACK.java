package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class DatingApp_STACK {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] males = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int[] females = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> male = new ArrayDeque<>();
        ArrayDeque<Integer> female = new ArrayDeque<>();

        for (int i = 0; i < males.length; i++) {
            male.push(males[i]);
        }
        for (int i = 0; i < females.length; i++) {
            female.offer(females[i]);
        }

        int matches = 0;
        while (!male.isEmpty() && !female.isEmpty()) {

            int maleValue = male.peek();
            int femaleValue = female.peek();

            if (maleValue <= 0) {
                male.pop();
                continue;
            } else if (maleValue % 25 == 0) {
                male.pop();
                male.pop();
                continue;
            }

            if (femaleValue <= 0) {
                female.poll();
                continue;
            } else if (femaleValue % 25 == 0) {
                female.poll();
                female.poll();
                continue;
            }
            if (femaleValue == maleValue) {
                male.pop();
                female.poll();
                matches += 1;
            } else {
                female.poll();
                male.pop();
                male.push(maleValue - 2);
            }
        }
        //Matches: 3
        //Males left: 1
        //Females left: none

        System.out.println("Matches: " + matches);
        if (male.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            System.out.print("Males left: ");
            System.out.println(male.toString().replaceAll("\\[", "").
                    replaceAll("]", ""));
        }
        if (female.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            System.out.print("Females left: ");
            System.out.println(female.toString().replaceAll("\\[", "").
                    replaceAll("]", ""));
        }
    }
}
