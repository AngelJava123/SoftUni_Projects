package com.company;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> keyMaterials = new TreeMap<>();
        Map<String, Integer> junkMaterials = new TreeMap<>();

        String keyMaterial1 = "shards";
        String keyMaterial2 = "fragments";
        String keyMaterial3 = "motes";

        boolean isFounded = false;

        while (!isFounded) {
            String[] materials = scanner.nextLine().toLowerCase().split("\\s+");

            for (int i = 0; i < materials.length; i++) {

                int grams = Integer.parseInt(materials[i]);
                String material = materials[i + 1];

                if (!keyMaterials.containsKey(keyMaterial1) && keyMaterial1.equals(material)) {
                    keyMaterials.put(material, grams);
                    if (keyMaterials.get(material) >= 250) {
                        keyMaterials.put(material, keyMaterials.get(material) - 250);
                        System.out.println("Shadowmourne obtained!");
                        isFounded = true;
                        break;
                    }
                } else if (keyMaterials.containsKey(keyMaterial1) && keyMaterial1.equals(material)) {
                    keyMaterials.put(material, keyMaterials.get(material) + grams);
                    if (keyMaterials.get(material) >= 250) {
                        keyMaterials.put(material, keyMaterials.get(material) - 250);
                        System.out.println("Shadowmourne obtained!");
                        isFounded = true;
                        break;
                    }
                } else if (!keyMaterials.containsKey(keyMaterial2) && keyMaterial2.equals(material)) {
                    keyMaterials.put(material, grams);
                    if (keyMaterials.get(material) >= 250) {
                        keyMaterials.put(material, keyMaterials.get(material) - 250);
                        System.out.println("Valanyr obtained!");
                        isFounded = true;
                        break;
                    }
                } else if (keyMaterials.containsKey(keyMaterial2) && keyMaterial2.equals(material)) {
                    keyMaterials.put(material, keyMaterials.get(material) + grams);
                    if (keyMaterials.get(material) >= 250) {
                        keyMaterials.put(material, keyMaterials.get(material) - 250);
                        System.out.println("Valanyr obtained!");
                        isFounded = true;
                        break;
                    }
                } else if (!keyMaterials.containsKey(keyMaterial3) && keyMaterial3.equals(material)) {
                    keyMaterials.put(material, grams);
                    if (keyMaterials.get(material) >= 250) {
                        keyMaterials.put(material, keyMaterials.get(material) - 250);
                        System.out.println("Dragonwrath obtained!");
                        isFounded = true;
                        break;
                    }
                } else if (keyMaterials.containsKey(keyMaterial3) && keyMaterial3.equals(material)) {
                    keyMaterials.put(material, keyMaterials.get(material) + grams);
                    if (keyMaterials.get(material) >= 250) {
                        keyMaterials.put(material, keyMaterials.get(material) - 250);
                        System.out.println("Dragonwrath obtained!");
                        isFounded = true;
                        break;
                    }
                } else {
                    if ((!keyMaterial1.equals(material)) && (!keyMaterial2.equals(material)) && (!keyMaterial3.equals(material))) {
                        if (!junkMaterials.containsKey(material)) {
                            junkMaterials.put(material, grams);
                        } else {
                            junkMaterials.put(material, junkMaterials.get(material) + grams);
                        }
                    }
                }
                i++;
            }
        }
        keyMaterials.putIfAbsent(keyMaterial1, 0);
        keyMaterials.putIfAbsent(keyMaterial2, 0);
        keyMaterials.putIfAbsent(keyMaterial3, 0);

        keyMaterials.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        for (var item : junkMaterials.entrySet()) {
            System.out.println(item.getKey() + ": " + item.getValue());
        }
    }
}
