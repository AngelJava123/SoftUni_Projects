package com.company;

import java.util.Scanner;

public class Hospital_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int period = Integer.parseInt(scanner.nextLine()); // На първия ред – периода, за който трябва да направите изчисления.

        int doctors = 7;
        int untreatedPatients = 0;
        int treatedPatients = 0;

        for (int i = 1; i <= period ; i++) {
            int patients = Integer.parseInt(scanner.nextLine()); //  На следващите редове(равни на броят на дните) – броя пациенти, които пристигат за преглед за текущия ден.

            if(i % 3 == 0 && untreatedPatients > treatedPatients){
                doctors += 1;
            }
            if(patients > doctors){
                untreatedPatients += patients - doctors;
                treatedPatients += doctors;
            }else {
                treatedPatients += patients;
            }

        }
        System.out.println("Treated patients: " + treatedPatients + ".");
        System.out.println("Untreated patients: "+untreatedPatients + ".");
    }
}
