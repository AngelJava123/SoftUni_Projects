package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String regex = ">>(?<furnitureName>[A-Za-z]+)<<(?<price>[0-9]+.?[0-9]*)!(?<quantity>[0-9]+)\\b";
        Pattern pattern = Pattern.compile(regex);
        double totalMoney = 0;

        List<String> boughtFurniture = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("Purchase")) {

            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
            String furnitureName = matcher.group("furnitureName");
            double price = Double.parseDouble(matcher.group("price"));
            int quantity = Integer.parseInt(matcher.group("quantity"));
            double total = price * quantity;

            boughtFurniture.add(furnitureName);
            totalMoney += total;
        }
            input = scanner.nextLine();
        }
        System.out.println("Bought furniture:");
        for (String furniture:boughtFurniture) {
            System.out.printf("%s%n",furniture);
        }
        System.out.printf("Total money spend: %.2f", totalMoney);
    }
}
