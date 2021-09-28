package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LegendaryFarming {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> keyMaterials = new TreeMap<>();
        Map<String, Integer> junkMaterials = new TreeMap<>();

        boolean isFound = false;

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split("\\s+");

                for (int i = 0; i < tokens.length; i++) {
                    int quantity = Integer.parseInt(tokens[i]);
                    String material = tokens[i + 1].toLowerCase();

                    if (material.equals("shards") || material.equals("fragments") || material.equals("motes")) {
                        if (!keyMaterials.containsKey(material)) {
                            keyMaterials.put(material, quantity);
                        } else {
                            keyMaterials.put(material, keyMaterials.get(material) + quantity);
                        }
                        if (keyMaterials.get(material) >= 250 && material.equals("shards")) {
                            keyMaterials.put(material, keyMaterials.get(material) - 250);
                            System.out.println("Shadowmourne obtained!");
                            isFound = true;
                            break;
                        } else if (keyMaterials.get(material) >= 250 && material.equals("fragments")) {
                            keyMaterials.put(material, keyMaterials.get(material) - 250);
                            System.out.println("Valanyr obtained!");
                            isFound = true;
                            break;
                        } else if (keyMaterials.get(material) >= 250 && material.equals("motes")) {
                            keyMaterials.put(material, keyMaterials.get(material) - 250);
                            System.out.println("Dragonwrath obtained!");
                            isFound = true;
                            break;
                        }
                    } else {
                        if (!junkMaterials.containsKey(material)) {
                            junkMaterials.put(material, quantity);
                        } else {
                            junkMaterials.put(material, junkMaterials.get(material) + quantity);
                        }
                    }
                    i++;
                }
                if (isFound) {
                    if (!keyMaterials.containsKey("fragments")) {
                        keyMaterials.put("fragments", 0);
                    }
                    if (!keyMaterials.containsKey("shards")) {
                        keyMaterials.put("shards", 0);
                    }
                    if (!keyMaterials.containsKey("motes")) {
                        keyMaterials.put("motes", 0);
                    }
                    break;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();

        //Use Comparator.reverseOrder() for reverse ordering
        keyMaterials.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

        reverseSortedMap.forEach((k, v) -> System.out.println(k + ": " + v));
        junkMaterials.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
