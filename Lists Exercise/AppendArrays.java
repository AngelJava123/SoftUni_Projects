package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> array = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());

        Collections.reverse(array);

        System.out.println(array.toString().replace("[", "").
                                            replace("]", "").
                                            replace(",", "").
                                            trim().
                                            replaceAll(" \\s+", " "));
    }
}
