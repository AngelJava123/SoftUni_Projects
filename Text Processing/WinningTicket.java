package com.company;

import java.util.Scanner;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tickets = scanner.nextLine().split(",\\s+");

        char winningSymbol1 = '@';
        char winningSymbol2 = '#';
        char winningSymbol3 = '$';
        char winningSymbol4 = '^';

        int countRight = 0;
        int countLeft = 0;

        StringBuilder winnerLeft = new StringBuilder();
        StringBuilder winnerRight = new StringBuilder();

        for (String ticket:tickets) {
            String trimmedTicket = ticket.trim();
            if (trimmedTicket.length() != 20) {
                System.out.println("invalid ticket");
                continue;
            } else {
                for (int i = 0; i < trimmedTicket.length()/2; i++) {
                    char current = trimmedTicket.charAt(i);
                    if (winningSymbol1 == current || winningSymbol2 == current
                            || winningSymbol3 == current || winningSymbol4 == current) {
                        winnerLeft.append(current);
                        countLeft++;
                    }
                }
                for (int i = trimmedTicket.length()-1; i >= trimmedTicket.length()/2; i--) {
                    char current = ticket.charAt(i);
                    if (winningSymbol1 == current || winningSymbol2 == current
                            || winningSymbol3 == current || winningSymbol4 == current) {
                        winnerRight.append(current);
                        countRight++;
                    }
                }
            }
            int finalCount = 0;
            if (countLeft >= 6  && countRight >= 6) {
                 if (winnerLeft.length() == winnerRight.length()) {
                     for (int i = 0; i < winnerLeft.length(); i++) {
                         char currentSymbolLeft = winnerLeft.charAt(i);
                         char currentSymbolRight = winnerRight.charAt(i);
                         if (currentSymbolLeft == currentSymbolRight) {
                             finalCount++;
                         }
                     }
                 }
             }
             if (finalCount >= 6 && finalCount <= 9) {
                  System.out.println("ticket " + "\"" + trimmedTicket + "\"" +" - " + finalCount + winnerLeft.charAt(0));
             } else if (finalCount == 10) {
                  System.out.println("ticket " + "\"" + trimmedTicket + "\"" + " - " + finalCount + winnerLeft.charAt(0) + " Jackpot!");
             } else {
                 System.out.println("ticket " + "\"" + trimmedTicket + "\"" + " - no match");
             }
            countLeft = 0;
            countRight = 0;
            winnerLeft.setLength(0);
            winnerRight.setLength(0);
        }
    }
}


