package com.company;

import java.util.Scanner;

public class TimePlusMinutes_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hour = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());

        int totalMin = hour * 60 + minutes + 15;

        hour = totalMin / 60;
        minutes = totalMin % 60;

        if (hour > 23) {
            hour = 0;
        }

        //с %02d си спестяваме if проверката
        // Какво прави %02d? -> ако числото е едноцифрено(т.е. минутите) долепя 0 преди нашето число;
        //ако числото е двуцифрено, не прави нищо, а просто го принтира

        // %d:%02d -> %d - за часовете, : (по условие), %02d - минутите, като обяснихме защо е така
        System.out.printf("%d:%02d", hour, minutes);

    }
}