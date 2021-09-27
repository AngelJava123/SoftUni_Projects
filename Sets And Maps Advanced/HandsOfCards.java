package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Peter: 2C, 4H, 9H, AS, QS

        Map<String, Set<String>> cards = new LinkedHashMap<>();

        String input = reader.readLine();
        while (!input.equals("JOKER")) {

            String[] inputData = input.split(": ");

            String name = inputData[0];
            String[] dataCards = inputData[1].split(", ");

            if (!cards.containsKey(name)) {
                cards.put(name, new HashSet<>());
            }
            for (String card : dataCards) {
                cards.get(name).add(card);
            }
            input = reader.readLine();
        }

        for (Map.Entry<String, Set<String>> card : cards.entrySet()) {
            int sum = 0;
            for (String individualCard : card.getValue()) {
                char firstSymbol = individualCard.charAt(0);
                char secondSymbol = individualCard.charAt(1);

                if (Character.isDigit(firstSymbol)) {
                    if (individualCard.length() == 3) {
                        char thirdSymbol = individualCard.charAt(2);
                        if (thirdSymbol == 'S') {
                            sum += 10 * 4;
                        } else if (thirdSymbol == 'H') {
                            sum += 10 * 3;
                        } else if (thirdSymbol == 'D') {
                            sum += 10 * 2;
                        } else if (thirdSymbol == 'C') {
                            sum += 10 * 1;
                        }
                    } else {
                        int number = Integer.parseInt(String.valueOf(firstSymbol));
                        if (secondSymbol == 'S') {
                            sum += number * 4;
                        } else if (secondSymbol == 'H') {
                            sum += number * 3;
                        } else if (secondSymbol == 'D') {
                            sum += number * 2;
                        } else if (secondSymbol == 'C') {
                            sum += number * 1;
                        }
                    }
                } else {
                    if (firstSymbol == 'J') {
                        if (secondSymbol == 'S') {
                            sum += 11 * 4;
                        } else if (secondSymbol == 'H') {
                            sum += 11 * 3;
                        } else if (secondSymbol == 'D') {
                            sum += 11 * 2;
                        } else if (secondSymbol == 'C') {
                            sum += 11 * 1;
                        }
                    } else if (firstSymbol == 'Q') {
                        if (secondSymbol == 'S') {
                            sum += 12 * 4;
                        } else if (secondSymbol == 'H') {
                            sum += 12 * 3;
                        } else if (secondSymbol == 'D') {
                            sum += 12 * 2;
                        } else if (secondSymbol == 'C') {
                            sum += 12 * 1;
                        }
                    } else if (firstSymbol == 'K') {
                        if (secondSymbol == 'S') {
                            sum += 13 * 4;
                        } else if (secondSymbol == 'H') {
                            sum += 13 * 3;
                        } else if (secondSymbol == 'D') {
                            sum += 13 * 2;
                        } else if (secondSymbol == 'C') {
                            sum += 13 * 1;
                        }
                    } else if (firstSymbol == 'A') {
                        if (secondSymbol == 'S') {
                            sum += 14 * 4;
                        } else if (secondSymbol == 'H') {
                            sum += 14 * 3;
                        } else if (secondSymbol == 'D') {
                            sum += 14 * 2;
                        } else if (secondSymbol == 'C') {
                            sum += 14 * 1;
                        }
                    }
                }
            }
            System.out.println(card.getKey() + ": " + sum);
        }
    }
}
