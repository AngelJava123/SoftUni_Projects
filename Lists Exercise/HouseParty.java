package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstInput = Integer.parseInt(scanner.nextLine());

        List<String> list = new ArrayList<>();

        for (int command = 0; command < firstInput; command++) {

            List<String> commands = Arrays.asList(scanner.nextLine().split(" "));

            String name = commands.get(0);

            if (commands.get(2).equals("going!")) {
                if (list.contains(name)) {
                    System.out.printf("%s is already in the list!%n", name);
                } else {
                    list.add(name);
                }
            }
            if (commands.get(2).equals("not")) {
                if (list.contains(name)) {
                    list.remove(name);
                } else {
                    System.out.printf("%s is not in the list!%n", name);
                }
            }
        }
        for (String s : list) {
            System.out.println(s);
        }
    }
}
