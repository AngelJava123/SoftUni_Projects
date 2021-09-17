package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> stack = new ArrayDeque<>();

        StringBuilder currentText = new StringBuilder();

        for (int i = 0; i < n; i++) {

            String[] commands = scanner.nextLine().split("\\s+");

            String commandNumber = commands[0];

            if (commandNumber.equals("1")) {
                String textForAppend = commands[1];
                currentText.append(textForAppend);
                stack.push(currentText.toString());

            } else if (commandNumber.equals("2")) {
                int count = Integer.parseInt(commands[1]);
                int startIndex = currentText.length() - count;
                currentText.delete(startIndex, startIndex + count);
                stack.push(currentText.toString());

            } else if (commandNumber.equals("3")) {
                int index = Integer.parseInt(commands[1]);
                System.out.println(currentText.charAt(index - 1));

            } else if (commandNumber.equals("4")) {
                if(stack.size() > 1) {
                    stack.pop();
                    currentText = new StringBuilder(stack.peek());
                } else {
                    currentText = new StringBuilder();
                }
            }
        }
    }
}
