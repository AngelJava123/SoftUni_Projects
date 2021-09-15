package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> canceled = new ArrayDeque<>();

        String command = scanner.nextLine();
        while (!command.equals("print")) {

            if (command.equals("cancel")) {
                if (canceled.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    String first = canceled.poll();
                    System.out.println("Canceled " + first);
                }
            } else {
                canceled.offer(command);
            }
            command = scanner.nextLine();
        }
        for (String s : canceled) {
            System.out.println(s);
        }
    }
}
