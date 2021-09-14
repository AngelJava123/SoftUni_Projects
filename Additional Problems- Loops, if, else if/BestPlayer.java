package com.company;

import java.util.Scanner;

public class BestPlayer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String bestPlayer = "";
        int maxPoints = Integer.MIN_VALUE;
        boolean hatTrick = false;
        String command = scanner.nextLine();

        while (true) {
            String names = command;
            int goals = Integer.parseInt(scanner.nextLine());

            if (command.equals("End")) {
                break;
            }

            if (goals > maxPoints) {
                    maxPoints += goals;
                }
                if (goals >= 10) {
                    break;
                }
                if (goals >= 3) {
                    hatTrick = true;
                }

            bestPlayer = names;
                command = scanner.nextLine();
            }
            System.out.printf("%s is the best player!", bestPlayer);
            if (hatTrick) {
                System.out.printf("He has scored %d goals and made a hat-trick !!!", maxPoints);
            } else {
                System.out.printf("He has scored %d goals.", maxPoints);
            }
    }
}

