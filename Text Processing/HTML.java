package com.company;

import java.util.Scanner;

public class HTML {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String title = scanner.nextLine();
        String content = scanner.nextLine();

        System.out.println("<h1>");
        System.out.printf("    %s%n", title);
        System.out.println("</h1>");
        System.out.println("<article>");
        System.out.printf("    %s%n", content);
        System.out.println("</article>");

        String command = scanner.nextLine();

        while (!command.equals("end of comments")) {

            System.out.println("<div>");
            System.out.printf("    %s%n",command);
            System.out.println("</div>");

            command = scanner.nextLine();
        }
    }
}
