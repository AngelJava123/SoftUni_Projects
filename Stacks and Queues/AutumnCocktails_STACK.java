package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class AutumnCocktails_STACK {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] ingredient = Arrays.stream(reader.readLine().split("\\s+")).
                mapToInt(Integer::parseInt).toArray();

        int[] fresh = Arrays.stream(reader.readLine().split("\\s+")).
                mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        ArrayDeque<Integer> freshness = new ArrayDeque<>();

        for (int i = 0; i < ingredient.length; i++) {
            ingredients.offer(ingredient[i]);
        }
        for (int i = 0; i < fresh.length; i++) {
            freshness.push(fresh[i]);
        }

        int pearSour = 0;
        int theHarvest = 0;
        int appleHinny = 0;
        int highFashion = 0;

        while (!ingredients.isEmpty() && !freshness.isEmpty()) {
            int ingredientValue = ingredients.peek();
            int freshnessValue = freshness.peek();

            if (ingredientValue == 0) {
                ingredients.poll();
                continue;
            }

            int sum = ingredientValue * freshnessValue;

            if (sum == 150) {
                ingredients.poll();
                freshness.pop();
                pearSour++;
            } else if (sum == 250) {
                ingredients.poll();
                freshness.pop();
                theHarvest++;
            } else if (sum == 300) {
                ingredients.poll();
                freshness.pop();
                appleHinny++;
            } else if (sum == 400) {
                ingredients.poll();
                freshness.pop();
                highFashion++;
            } else {
                ingredients.poll();
                freshness.pop();
                ingredients.addLast(ingredientValue + 5);
            }

        }
        if (pearSour >= 1 && theHarvest >= 1 && appleHinny >= 1 && highFashion >= 1) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        int sum;

        if (!ingredients.isEmpty()) {
            sum = ingredients.stream().mapToInt(e -> e).sum();
            System.out.println("Ingredients left: " + sum);
        }

        if (appleHinny != 0) {
            System.out.println(" # Apple Hinny --> " + appleHinny);
        }
        if (highFashion != 0) {
            System.out.println(" # High Fashion --> " + highFashion);
        }
        if (pearSour != 0) {
            System.out.println(" # Pear Sour --> " + pearSour);
        }
        if (theHarvest != 0) {
            System.out.println(" # The Harvest --> " + theHarvest);
        }
    }
}
