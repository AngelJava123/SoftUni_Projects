package com.company;

import java.util.Scanner;

public class MetricConverter_04 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);

        //•	Първи ред: число за преобразуване - реално число

        double TransformNumber = Double.parseDouble(scanner.nextLine());

        //•	Втори ред: входна мерна единица - текст

        String InMetric = scanner.nextLine();

        //•	Трети ред: изходна мерна единица (за резултата) - текст

        String OutMetric = scanner.nextLine();

        if (InMetric.equals("mm")) {
            TransformNumber = TransformNumber / 1000;
        } else if (InMetric.equals("cm")) {
            TransformNumber = TransformNumber / 100;
        }

        if (OutMetric.equals("mm")) {
            TransformNumber = TransformNumber * 1000;
        } else if (OutMetric.equals("cm")) {
            TransformNumber = TransformNumber * 100;
        }

        System.out.printf("%.3f",TransformNumber);
    }
}
