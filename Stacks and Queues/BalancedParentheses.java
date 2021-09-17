package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Character> parentheses = new ArrayDeque<>();

        // {[()]}

        String input = scanner.nextLine();

        boolean areEquals = false;

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (currentChar == '{') {
                parentheses.push('{');
            } else if (currentChar == '[') {
                parentheses.push('[');
            } else if (currentChar == '(') {
                parentheses.push('(');
            } else if (currentChar == '}') {
                if (!parentheses.isEmpty()) {
                    char prev = parentheses.pop();
                    if (prev == '{') {
                        areEquals = true;
                    } else {
                        areEquals = false;
                        break;
                    }
                } else {
                    areEquals = false;
                    break;
                }
            } else if (currentChar == ']') {
                if (!parentheses.isEmpty()) {
                    char prev = parentheses.pop();
                    if (prev == '[') {
                        areEquals = true;
                    } else {
                        areEquals = false;
                        break;
                    }
                } else {
                    areEquals = false;
                    break;
                }
            } else if (currentChar == ')') {
                if (!parentheses.isEmpty()) {
                    char prev = parentheses.pop();
                    if (prev == '(') {
                        areEquals = true;
                    } else {
                        areEquals = false;
                        break;
                    }
                } else {
                    areEquals = false;
                    break;
                }
            }
        }
        if (areEquals) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
