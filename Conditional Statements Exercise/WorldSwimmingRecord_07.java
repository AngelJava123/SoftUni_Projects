package com.company;

import java.util.Scanner;

public class WorldSwimmingRecord_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1.	Рекордът в секунди – реално число

        double recordInSeconds = Double.parseDouble(scanner.nextLine());

        //2.	Разстоянието в метри – реално число

        double distanceInMetres = Double.parseDouble(scanner.nextLine());

        //3.	Времето в секунди, за което плува разстояние от 1 м. - реално число

        double secondsForOneMeter = Double.parseDouble(scanner.nextLine());

        //Иван трябва да преплува

        double needToSwim = distanceInMetres * secondsForOneMeter;

        //На всеки 15 м. към времето му се добавят 12.5 сек.:

        double addSeconds2 = Math.floor(distanceInMetres / 15);
        double addSeconds = addSeconds2 * 12.5;

        double totalTime = needToSwim + addSeconds;

        //•	Ако Иван е подобрил Световния рекорд (времето му е по-малко от рекорда) отпечатваме:

        if (totalTime < recordInSeconds) {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", totalTime);
        } else { // (totalTime >
            System.out.printf("No, he failed! He was %.2f seconds slower.", Math.abs(recordInSeconds - totalTime));
        }




    }
}
