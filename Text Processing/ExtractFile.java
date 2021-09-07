package com.company;

import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] pathLine = scanner.nextLine().split("\\\\");

        String lastWord = pathLine[pathLine.length-1];

        String[] splitLastWord = lastWord.split("\\.");

        String fileName = splitLastWord[0];
        String fileExtension = splitLastWord[1];

        System.out.println("File name: " + fileName);
        System.out.println("File extension: " + fileExtension);
    }
}
