package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Bombs_STACK {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] bombE = Arrays.stream(reader.readLine().split(", ")).
                mapToInt(Integer::parseInt).toArray();

        int[] bombC = Arrays.stream(reader.readLine().split(", ")).
                mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> bombEffects = new ArrayDeque<>();
        ArrayDeque<Integer> bombCasings = new ArrayDeque<>();

        for (int i = 0; i < bombE.length; i++) {
            bombEffects.offer(bombE[i]);
        }
        for (int i = 0; i < bombC.length; i++) {
            bombCasings.push(bombC[i]);
        }
        int datura = 0;
        int cherry = 0;
        int smoke = 0;
        boolean allBombs = false;

        while (!bombEffects.isEmpty() && !bombCasings.isEmpty()) {

            int bombEffect = bombEffects.peek();
            int bombCasing = bombCasings.peek();

            int sum = bombCasing + bombEffect;

            if (sum == 40) {
                bombEffects.poll();
                bombCasings.pop();
                datura++;
            } else if (sum == 60) {
                bombEffects.poll();
                bombCasings.pop();
                cherry++;
            } else if (sum == 120) {
                bombEffects.poll();
                bombCasings.pop();
                smoke++;
            } else {
                bombCasings.pop();
                bombCasings.push(bombCasing - 5);
            }
            if (datura >= 3 && cherry >= 3 && smoke >= 3) {
                allBombs = true;
                break;
            }
        }
        if (allBombs) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        if (bombEffects.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.println("Bomb Effects: " + bombEffects.toString().
                    replaceAll("\\[", "").replaceAll("]", ""));
        }
        if (bombCasings.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.println("Bomb Casings: " + bombCasings.toString().
                    replaceAll("\\[", "").replaceAll("]", ""));
        }
        System.out.println("Cherry Bombs: " + cherry);
        System.out.println("Datura Bombs: " + datura);
        System.out.println("Smoke Decoy Bombs: " + smoke);
    }
}
