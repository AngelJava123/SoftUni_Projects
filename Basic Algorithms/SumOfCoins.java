package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SumOfCoins {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] elements = reader.readLine().substring(7).split(", ");
        int[] coins = new int[elements.length];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(elements[i]);
        }

        int targetSum = Integer.parseInt(reader.readLine().substring(5));


        Map<Integer, Integer> usedCoins = chooseCoins(coins, targetSum);

        for (Map.Entry<Integer, Integer> usedCoin : usedCoins.entrySet()) {
            System.out.println(usedCoin.getKey() + " -> " + usedCoin.getValue());
        }
    }

    public static Map<Integer, Integer> chooseCoins(int[] coins, int targetSum) {
        Map<Integer, Integer> result = new LinkedHashMap<>();

        Set<Integer> coin = new TreeSet<>((f, s) -> Integer.compare(s, f));

        Arrays.stream(coins).forEach(coin::add);

        for (Integer coin1 : coin) {
            int coinsToTake = targetSum / coin1;

            if (coinsToTake != 0) {
                result.put(coin1, coinsToTake);
                targetSum = targetSum % coin1;
            }
            if (targetSum == 0) {
                break;
            }
        }
        return result;
    }
}
