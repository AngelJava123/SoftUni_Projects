package com.company;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class LineNumbers {
    public static int countRow = 1;
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\tasheva\\Downloads\\Java Advanced Labs and Exercises" +
                "\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";

        String outputPath = "outputLine.txt";
        PrintWriter writer = new PrintWriter(outputPath);

        Files.readAllLines(Path.of(path))
                .forEach(line -> {
                    writer.println(countRow++ + ". " + line);
                });
        writer.close();
    }
}
