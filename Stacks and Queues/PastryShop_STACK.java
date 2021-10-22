package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class PastryShop_STACK {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] liquid = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int[] ingredient = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();

        for (int i = 0; i < liquid.length; i++) {
            liquids.offer(liquid[i]);
        }
        for (int i = 0; i < ingredient.length; i++) {
            ingredients.push(ingredient[i]);
        }
        int biscuit = 0;
        int cake = 0;
        int pastry = 0;
        int pie = 0;

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int liquidValue = liquids.peek();
            int ingredientValue = ingredients.peek();

            int sum = liquidValue + ingredientValue;

            if (sum == 25) {
                liquids.poll();
                ingredients.pop();
                biscuit++;
            } else if (sum == 50) {
                liquids.poll();
                ingredients.pop();
                cake++;
            } else if (sum == 75) {
                liquids.poll();
                ingredients.pop();
                pastry++;
            } else if (sum == 100) {
                liquids.poll();
                ingredients.pop();
                pie++;
            } else {
                liquids.poll();
                ingredients.pop();
                ingredients.push(ingredientValue + 3);
            }
        }
        if (biscuit >= 1 && cake >= 1 && pastry >= 1 && pie >= 1) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        if (liquids.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.print("Liquids left: " + liquids.toString().replaceAll("\\[", "").
                    replaceAll("]", ""));
            System.out.println();
        }
        if (ingredients.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.print("Ingredients left: " + ingredients.toString().replaceAll("\\[", "").
                    replaceAll("]", ""));
            System.out.println();
        }
        System.out.println("Biscuit: " + biscuit);
        System.out.println("Cake: " + cake);
        System.out.println("Pie: " + pie);
        System.out.println("Pastry: " + pastry);
    }
}
