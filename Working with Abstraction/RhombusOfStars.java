package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RhombusOfStars {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        StringBuilder rhombusTop = constructTop(n);
        StringBuilder rhombusBottom = constructBottom(n);
        printRow(rhombusTop, rhombusBottom);

    }

    public static void printRow(StringBuilder rhombusTop, StringBuilder rhombusBottom) {
        deleteLastLine(rhombusTop);
        System.out.println(rhombusTop);
        deleteLastLine(rhombusBottom);
        System.out.println(rhombusBottom);
    }

    public static void deleteLastLine(StringBuilder sb) {
        int last = sb.lastIndexOf("\n");
        if (last >= 0) {
            sb.delete(last, sb.length());
        }
    }

    public static StringBuilder constructBottom(int n) {
        StringBuilder rhombus = new StringBuilder();

        for (int r = n; r >= 1; r--) {
            rhombusStars(n, rhombus, r);
        }
        return rhombus;
    }

    public static void rhombusStars(int n, StringBuilder rhombus, int r) {

        for (int c = 0; c < n - r; c++) {
            rhombus.append(" ");
        }

        for (int i = 0; i < r; i++) {
            rhombus.append("* ");
        }

        rhombus.append(System.lineSeparator());

    }

    public static StringBuilder constructTop(int n) {
        StringBuilder rhombus = new StringBuilder();

        for (int r = 1; r < n; r++) {
            rhombusStars(n, rhombus, r);
        }
        return rhombus;
    }
}
