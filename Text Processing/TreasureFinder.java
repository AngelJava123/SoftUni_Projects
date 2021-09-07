package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TreasureFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] keySequence = Arrays.stream(scanner.nextLine().
                split("\\s+")).mapToInt(Integer::parseInt).toArray();

        String text = scanner.nextLine();
        while (!text.equals("find")) {

            StringBuilder hiddenMessage = new StringBuilder(text);
            List<Character> decryptedMessage = new ArrayList<>();

            int keyIndex = 0;

            for (int i = 0; i < hiddenMessage.length(); i++) {
                char currentSymbol = hiddenMessage.charAt(i);

                char decrypted = (char) (currentSymbol - keySequence[keyIndex]);
                decryptedMessage.add(decrypted);
                keyIndex++;
                if (keyIndex == keySequence.length) {
                    keyIndex = 0;
                }
            }
            char typeStartIndex = (char) decryptedMessage.indexOf('&');
            char coordinatesStartIndex = (char) decryptedMessage.indexOf('<');

            StringBuilder type = new StringBuilder();
            StringBuilder coordinates = new StringBuilder();

            for (int i = typeStartIndex; i < decryptedMessage.size(); i++) {
                char currentSymbol = decryptedMessage.get(i + 1);

                if (currentSymbol == '&') {
                    break;
                } else {
                    type.append(currentSymbol);
                }
            }
            for (int i = coordinatesStartIndex; i < decryptedMessage.size(); i++) {
                char currentSymbol = decryptedMessage.get(i + 1);

                if (currentSymbol == '>') {
                    break;
                } else {
                    coordinates.append(currentSymbol);
                }
            }
            System.out.printf("Found %s at %s%n", type, coordinates);
            text = scanner.nextLine();
        }
    }
}
