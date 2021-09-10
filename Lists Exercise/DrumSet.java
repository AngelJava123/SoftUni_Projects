package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DrumSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double savings = Double.parseDouble(scanner.nextLine());

        List<Integer> drumSet = Arrays.stream(scanner.nextLine().split("\\s+")).
                map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> initialDrumSet = new ArrayList<>(drumSet);

        String command = scanner.nextLine();
        while (!command.equals("Hit it again, Gabsy!")) {

            int power = Integer.parseInt(command);

            for (int set = 0; set < drumSet.size(); set++) {
                if (drumSet.get(set) - power > 0) {
                    int decreasedPower = drumSet.get(set) - power;
                    drumSet.set(set, decreasedPower);
                } else {
                    int increasedPower = initialDrumSet.get(set);
                    double saving = increasedPower * 3;

                    if (savings >= saving) {
                        drumSet.set(set, increasedPower);
                        savings = savings - increasedPower * 3;
                    } else {
                        drumSet.remove(drumSet.get(set));
                    }
                }
            }
            command = scanner.nextLine();
        }
        for (Integer drumSetFinal : drumSet) {
            System.out.print(drumSetFinal + " ");
        }
        System.out.println();
        System.out.printf("Gabsy has %.2flv.", savings);
    }
}
