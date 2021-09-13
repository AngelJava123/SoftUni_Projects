package com.company;

import java.util.*;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Double> productPrice = new LinkedHashMap<>();
        Map<String, Integer> productQuantity = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("buy")) {

            String[] inputData = input.split("\\s+");

            String productType = inputData[0];
            double price = Double.parseDouble(inputData[1]);
            int quantity = Integer.parseInt(inputData[2]);

            productPrice.put(productType, price);

            if (!productQuantity.containsKey(productType)) {
                productQuantity.put(productType, quantity);
            } else {
                productQuantity.put(productType, productQuantity.get(productType) + quantity);
            }
            input = scanner.nextLine();
        }
        for (var entry:productPrice.entrySet()) {
            double finalSum = entry.getValue() * productQuantity.get(entry.getKey());
            System.out.printf("%s -> %.2f%n",entry.getKey(), finalSum );

        }
    }
}
