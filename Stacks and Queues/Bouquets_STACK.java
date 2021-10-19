package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Bouquets_STACK {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] flower1 = Arrays.stream(reader.readLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int[] flower2 = Arrays.stream(reader.readLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> tulips = new ArrayDeque<>();
        ArrayDeque<Integer> daffodils = new ArrayDeque<>();

        for (int i = 0; i < flower1.length; i++) {
            tulips.push(flower1[i]);
        }
        for (int i = 0; i < flower2.length; i++) {
            daffodils.offer(flower2[i]);
        }

        int bouquets = 0;
        int removedFlowers = 0;

        while (!tulips.isEmpty() && !daffodils.isEmpty()) {
            int tulipValue = tulips.peek();
            int daffodilValue = daffodils.peek();

            int sum = tulipValue + daffodilValue;

            if (sum == 15) {
                bouquets++;
                tulips.pop();
                daffodils.poll();
            }
            if (sum < 15) {
                removedFlowers += sum;
                tulips.pop();
                daffodils.poll();
            }
            if (sum > 15) {
                while (sum > 15) {
                    tulipValue -= 2;
                    sum = tulipValue + daffodilValue;
                }
                if (sum == 15) {
                    bouquets++;
                } else {
                    removedFlowers += sum;
                }
                tulips.pop();
                daffodils.poll();
            }
        }
        if (removedFlowers >= 15) {
            int total = removedFlowers / 15;
            bouquets += total;
        }
        if (bouquets >= 5) {
            System.out.println("You made it! You go to the competition with " + bouquets + " bouquets!");
        } else {
            int numberOfBouquets = 5 - bouquets;
            System.out.println("You failed... You need more " + numberOfBouquets + " bouquets.");
        }
    }
}
