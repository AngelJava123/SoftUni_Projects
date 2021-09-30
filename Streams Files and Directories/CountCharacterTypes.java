package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        // read data
        Path path = Path.of("C:\\Users\\tasheva\\Downloads\\Java Advanced Labs and Exercises" +
                "\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");

        List<String> lines = new ArrayList<>();

        lines = Files.readAllLines(path);

        //2. преброим гласни, съгласни, пункт. знаци

        Map<String, Integer> symbols = new HashMap<>();
        // гласни -> брой
        symbols.put("vowels", 0);
        // съгласни -> брой
        symbols.put("consonants", 0);
        // пункт. знаци -> брой
        symbols.put("punctuations", 0);

        for (String line : lines) {
            for (char symbol:line.toCharArray()) {
                if (symbol == ' ') {
                    continue;
                } else if (isVowel(symbol)) {
                    symbols.put("vowels", symbols.get("vowels") + 1);
                } else if (isPunctuational(symbol)) {
                    symbols.put("punctuations", symbols.get("punctuations") + 1);
                } else {
                    symbols.put("consonants", symbols.get("consonants") + 1);
                }
            }
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter("output_task_4.txt"));

        writer.write("Vowels: " + symbols.get("vowels"));
        writer.newLine();
        writer.write("Consonants: " + symbols.get("consonants"));
        writer.newLine();
        writer.write("Punctuation: " + symbols.get("punctuations"));

        writer.close();

    }

    private static boolean isPunctuational(char symbol) {

        // ! , . ?
        return symbol == '!' || symbol == ',' || symbol == '.' || symbol == '?';
    }

    private static boolean isVowel(char symbol) {
        //true -> гласна
        // false -> съгласна
        return symbol == 'a' || symbol == 'e' || symbol == 'i' || symbol == 'o'
                || symbol == 'u';
    }
}
