package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TakeSkipRope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String encryptedMessage = scanner.nextLine();

        List<Integer> removedNumbers = new ArrayList<>();

        List<String> removedCharacters = new ArrayList<>();

        List<Integer> take = new ArrayList<>();

        List<Integer> skip = new ArrayList<>();

        for (int i = 0; i < encryptedMessage.length(); i++) {

            char chars = encryptedMessage.charAt(i);

            if (chars >= 48 && chars <= 57) {
                removedNumbers.add(Integer.parseInt(Character.toString(chars)));
            } else {
                removedCharacters.add(Character.toString(chars));
            }
        }
        for (int i = 0; i < removedNumbers.size(); i++) {
            int numb = removedNumbers.get(i);

            if (i % 2 == 0) {
                take.add(numb);
            } else {
                skip.add(numb);
            }
        }
        String output = "";
        int hop = 0;
        for (int i = 0; i < removedCharacters.size(); i++) {
            if (hop > take.size()-1) {
                output += removedCharacters.get(i);
                break;
            }
            int numCharsToTake = take.get(hop);
            for (int j = i; j < i + numCharsToTake; j++) {
                if (j < removedCharacters.size()) {
                    output += removedCharacters.get(j);
                }
            }
            i += numCharsToTake;
            int numCharsToSkip = skip.get(hop);
            i += numCharsToSkip-1;
            hop++;
        }
        System.out.println(output);
    }
}
