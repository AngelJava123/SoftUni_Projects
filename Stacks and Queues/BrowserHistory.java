package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> browser = new ArrayDeque<>();

        String current = "";

        String input = scanner.nextLine();
        while (!input.equals("Home")) {

            if (input.equals("back")) {
                if (browser.isEmpty()) {
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                }
                String prev = browser.pop();
                current = prev;

            } else {
                if (!current.equals("")) {
                    browser.push(current);
                }
                current = input;
            }
            System.out.println(current);

            input = scanner.nextLine();
        }
    }
}
