package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SantaSecretHelper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());

        List<String> names = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("end")) {

            StringBuilder decryptedMessage = new StringBuilder();

            for (int i = 0; i < input.length(); i++) {
                char currentChar = input.charAt(i);
                char augmented = (char) (currentChar - key);
                decryptedMessage.append(augmented);
            }
            String decryptedRegex = "([^@\\-!:>.]*)@(?<name>[A-Za-z]+)([^@\\-!:>.]*)!(?<type>[NG])!([^@\\-!:>.]*)";
            Pattern decryptedRegexPattern = Pattern.compile(decryptedRegex);
            Matcher decryptedMatcher = decryptedRegexPattern.matcher(decryptedMessage);

            while (decryptedMatcher.find()) {
                String name = decryptedMatcher.group("name");
                String type = decryptedMatcher.group("type");

                if (type.equals("G")) {
                    names.add(name);
                }
            }
            input = scanner.nextLine();
        }
        for (String name:names) {
            System.out.println(name);
        }
    }
}
