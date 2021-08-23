package com.company;

import java.util.Scanner;

public class FuelTankTwo_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fuelType = scanner.nextLine(); // "Diesel", "Gasoline", "Gas"
        double litersFuel = Double.parseDouble(scanner.nextLine());
        String clubCard = scanner.nextLine(); // "Yes", "No"

        boolean chekCard = true;

        if (clubCard.equals("No"))
        {
            chekCard = false;
        }
        else if(clubCard.equals("Yes"))
        {
            chekCard = true;
        }

        double diesel = 2.33;
        double dieselDiscount = 0.12;
        double gasoline = 2.22;
        double gasolineDiscount = 0.18;
        double gas = 0.93;
        double gasDiscount = 0.08;

        if (chekCard)
        {
            diesel -= dieselDiscount;
            gasoline -= gasolineDiscount;
            gas -= gasDiscount;
        }

        double fuelPrice = 0.0;
        double discount20 = 0.08;
        double discount25 = 0.10;

        switch (fuelType)
        {
            case "Diesel":
                fuelPrice = diesel * litersFuel;
                break;
            case "Gasoline":
                fuelPrice = gasoline * litersFuel;
                break;
            case "Gas":
                fuelPrice = gas * litersFuel;
                break;
            default:
                System.out.println("Invalid fuel!");
                break;
        }

        if (litersFuel >= 20 && litersFuel <= 25)
        {
            fuelPrice = fuelPrice - (fuelPrice * discount20);
        }
        else if (litersFuel > 25)
        {
            fuelPrice = fuelPrice - (fuelPrice * discount25);
        }
        System.out.printf("%.2f lv.", fuelPrice);
    }
        }


