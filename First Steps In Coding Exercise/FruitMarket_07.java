package com.company;

import java.util.Scanner;

public class FruitMarket_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        //1.	Цена на ягодите в лева – реално число

        double strawberryPrice = Double.parseDouble(scanner.nextLine());

        //2.	Количеството бананите в килограми – реално число

        double bananaWeight = Double.parseDouble(scanner.nextLine());

        //3.	Количеството портокалите в килограми – реално число

        double orangesWeight = Double.parseDouble(scanner.nextLine());

        //4.	Количеството малините в килограми – реално число

        double berries = Double.parseDouble(scanner.nextLine());

        //5.	Количеството ягодите в килограми – реално число
        double strawberryWeight = Double.parseDouble(scanner.nextLine());

        //Цена на малините за килограм
        double berriesPrice = strawberryPrice/2;

        //Цена на портокалите за килограм
        double orangesPrice = berriesPrice * 0.6;

        //Цена на бананите за килограм
        double bananaPrice = berriesPrice * 0.2;

        //Сума за малините
        double berriesSum = berries * berriesPrice;

        //Сума за портокалите
        double orangesSum = orangesWeight * orangesPrice;

        //Сума за бананите
        double bananaSum = bananaPrice * bananaWeight;

        //Сума за ягодите
        double strawberrySum = strawberryPrice * strawberryWeight;

        //Обща сума
        double AllSum = berriesSum + orangesSum + bananaSum + strawberrySum;

        //Да се отпечата на конзолата едно число: парите, които са необходими на Мария.
        //Резултатът да се форматира до втората цифра след десетичната запетая.

        System.out.printf("%.2f", AllSum);


    }
}
