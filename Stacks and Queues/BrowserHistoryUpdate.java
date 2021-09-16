package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpdate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> browser = new ArrayDeque<>();
        ArrayDeque<String> forward = new ArrayDeque<>();

        String input = scanner.nextLine();
        while (!input.equals("Home")) {

            if (input.equals("back")) {
                if (browser.size() < 2) {
                    System.out.println("no previous URLs");
                } else {
                    String currentURL = browser.pop();
                    forward.push(currentURL);
                    System.out.println(browser.peek());
                }
            } else if (input.equals("forward")) {
                if (forward.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    String currentForward = forward.pop();
                    System.out.println(currentForward);
                    browser.push(currentForward);
                }
            } else {
                browser.push(input);
                System.out.println(input);
                forward.clear();
            }
            input = scanner.nextLine();
        }
    }
}
