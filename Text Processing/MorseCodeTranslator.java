package com.company;

import java.util.Scanner;

public class MorseCodeTranslator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //.. | -- .- -.. . | -.-- --- ..- | .-- .-. .. - . | .- | .-.. --- -. --. | -.-. --- -.. .

        String[] morseText = scanner.nextLine().split("\\s+");

        String A = ".-"; String B = "-..."; String C = "-.-."; String D = "-.."; String E = "."; String F = "..-.";
        String G = "--."; String H = "...."; String I = ".."; String J = ".---"; String K = "-.-"; String L = ".-..";
        String M = "--"; String N = "-."; String O = "---"; String P = ".--."; String Q = "--.-"; String R = ".-.";
        String S = "..."; String T = "-"; String U = "..-"; String V = "...-"; String W = ".--"; String X = "-..-";
        String Y = "-.--"; String Z = "--..";

        StringBuilder finalMorseCode = new StringBuilder();

        for (String word:morseText) {
            if (word.equals(" ")) {
                finalMorseCode.append("");
            } else if (word.equals("|")) {
                finalMorseCode.append(" ");
            } else if (word.equals(A)) {
                finalMorseCode.append("A");
            } else if (word.equals(B)) {
                finalMorseCode.append("B");
            } else if (word.equals(C)) {
                finalMorseCode.append("C");
            } else if (word.equals(D)) {
                finalMorseCode.append("D");
            } else if (word.equals(E)) {
                finalMorseCode.append("E");
            } else if (word.equals(F)) {
                finalMorseCode.append("F");
            } else if (word.equals(G)) {
                finalMorseCode.append("G");
            } else if (word.equals(H)) {
                finalMorseCode.append("H");
            } else if (word.equals(I)) {
                finalMorseCode.append("I");
            } else if (word.equals(J)) {
                finalMorseCode.append("J");
            } else if (word.equals(K)) {
                finalMorseCode.append("K");
            } else if (word.equals(L)) {
                finalMorseCode.append("L");
            } else if (word.equals(M)) {
                finalMorseCode.append("M");
            } else if (word.equals(N)) {
                finalMorseCode.append("N");
            } else if (word.equals(O)) {
                finalMorseCode.append("O");
            } else if (word.equals(P)) {
                finalMorseCode.append("P");
            } else if (word.equals(Q)) {
                finalMorseCode.append("Q");
            } else if (word.equals(R)) {
                finalMorseCode.append("R");
            } else if (word.equals(S)) {
                finalMorseCode.append("S");
            } else if (word.equals(T)) {
                finalMorseCode.append("T");
            } else if (word.equals(U)) {
                finalMorseCode.append("U");
            } else if (word.equals(V)) {
                finalMorseCode.append("V");
            } else if (word.equals(W)) {
                finalMorseCode.append("W");
            } else if (word.equals(X)) {
                finalMorseCode.append("X");
            } else if (word.equals(Y)) {
                finalMorseCode.append("Y");
            } else if (word.equals(Z)) {
                finalMorseCode.append("Z");
            }
        }
        System.out.println(finalMorseCode);
    }
}
