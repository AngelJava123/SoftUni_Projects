package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Cooking_STACK {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] liquid = Arrays.stream(reader.readLine().split("\\s+")).
                mapToInt(Integer::parseInt).toArray();

        int[] ingredient = Arrays.stream(reader.readLine().split("\\s+")).
                mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();

        for (int i = 0; i < liquid.length; i++) {
            liquids.offer(liquid[i]);
        }
        for (int i = 0; i < ingredient.length; i++) {
            ingredients.push(ingredient[i]);
        }
        int bread = 0;
        int cake = 0;
        int pastry = 0;
        int fruitPie = 0;

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {

            int liquidValue = liquids.peek();
            int ingredientValue = ingredients.peek();

            int sum = ingredientValue + liquidValue;

            switch (sum) {
                case 25:
                    bread++;
                    liquids.poll();
                    ingredients.pop();
                    break;
                case 50:
                    cake++;
                    liquids.poll();
                    ingredients.pop();
                    break;
                case 75:
                    pastry++;
                    liquids.poll();
                    ingredients.pop();
                    break;
                case 100:
                    fruitPie++;
                    liquids.poll();
                    ingredients.pop();
                    break;
                default:
                    liquids.poll();
                    ingredients.pop();
                    ingredients.push(ingredientValue + 3);
                    break;
            }
        }
        if (bread >= 1 && pastry >= 1 && cake >= 1 && fruitPie >= 1) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
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
        System.out.println("Bread: " + bread);
        System.out.println("Cake: " + cake);
        System.out.println("Fruit Pie: " + fruitPie);
        System.out.println("Pastry: " + pastry);
    }
}
