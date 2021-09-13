package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SnowWhite {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, Integer>> dwarfs = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Once upon a time")) {

            String[] inputData = input.split(" <:> ");

            String dwarfName = inputData[0];
            String dwarfHatColor = inputData[1];
            int dwarfPhysics = Integer.parseInt(inputData[2]);

            LinkedHashMap<String, Integer> dwarfHatColorPhysics = new LinkedHashMap<>();

            if (!dwarfs.containsKey(dwarfHatColor)) {
                dwarfHatColorPhysics.put(dwarfName, dwarfPhysics);
                dwarfs.put(dwarfHatColor, dwarfHatColorPhysics);
            } else {
                if (!dwarfs.get(dwarfHatColor).containsKey(dwarfName)) {
                    dwarfs.get(dwarfHatColor).put(dwarfName, dwarfPhysics);
                } else {
                    dwarfs.get(dwarfHatColor).put(dwarfName, Math.max(dwarfPhysics, dwarfs.get(dwarfHatColor).get(dwarfName)));
                }
            }
            input = scanner.nextLine();
        }
        //You must order the dwarfs by physics in descending order
        // and then by total count of dwarfs with the same hat color in descending order.
        Map<String, Integer> print = new LinkedHashMap<>();
        //"Red Peter 1" -> 10000
        //"Blue Peter 2" -> 10000
        //"Blue George 2 -> 10000

        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : dwarfs.entrySet()) {
            for (Map.Entry<String, Integer> subEntry : entry.getValue().entrySet()) {
                print.put(entry.getKey() + " " + subEntry.getKey() + " " + entry.getValue().size(), subEntry.getValue());
            }
        }
        print.entrySet().stream().sorted((p2, p1) -> {
            int sort = Integer.compare(p1.getValue(), p2.getValue()); // Key -> "Blue Peter 2" , Value -> 10000
            if (sort == 0) {
                String[] sort1 = p1.getKey().split(" "); //["Red", "Peter", "1"]
                String[] sort2 = p2.getKey().split(" "); // ["Blue", "Peter", "2"]
                sort = sort1[2].compareTo(sort2[2]);   // indexes:   0        1      2 -> size! dwarfCount
            }
            return sort;
        }).forEach(pair -> {
            String[] printing = pair.getKey().split(" "); // ["Blue", "Peter", "2"]
            System.out.printf("(%s) %s <-> %d%n", printing[0], printing[1], pair.getValue());
                                               //    (Blue) Peter <-> 10000
                                               //    (Blue) George <-> 10000
                                               //    (Red) Peter <-> 10000
        });
    }
}