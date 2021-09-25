package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<String, Double>> products = new TreeMap<>();

        String input = reader.readLine();
        while (!input.equals("Revision")) {

            String[] inputData = input.split(", ");

            String shop = inputData[0];
            String product = inputData[1];
            double price = Double.parseDouble(inputData[2]);

            if (!products.containsKey(shop)) {
                products.put(shop, new LinkedHashMap<>());
            }
            products.get(shop).put(product, price);

            input = reader.readLine();
        }
        products.forEach((key, value) -> {
            System.out.println(key + "->");
            value.forEach((key1, value1) -> {
                System.out.printf("Product: %s, Price: %.1f%n", key1, value1);
            });
        });
        /* for (Map.Entry<String, Map<String, Double>> product :products.entrySet()) {
              System.out.println(product.getKey() + "->");
                  for (Map.Entry<String, Double> price: product.getValue().entrySet()) {
                     System.out.printf("Product: %s, Price: %.1f%n", price.getKey(), price.getValue());
              }
           }
         */
    }
}
