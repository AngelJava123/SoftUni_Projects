package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Students1> students = new ArrayList<>();

        while (!input.equals("end")) {

            String[] tokens = input.split("\\s+");

            String firstName = tokens[0];
            String lastName = tokens[1];
            int age = Integer.parseInt(tokens[2]);
            String hometown = tokens[3];
            if (!isAlreadyExist(firstName,lastName, age, hometown, students)) {
                Students1 student = new Students1(firstName, lastName, age, hometown);
                students.add(student);
            }


            input = scanner.nextLine();
        }
        String hometown = scanner.nextLine();
        for (Students1 student :students) {
            if (student.getHometown().equals(hometown)) {
                System.out.println(student);
            }
        }
    }

    private static boolean isAlreadyExist(String firstName, String lastName, int age, String hometown, List<Students1> students) {
        for (Students1 student : students) {
            boolean isFirstNameEqual = student.getFirstName().equals(firstName);
            boolean isLastNameEqual = student.getLastName().equals(lastName);
            if (isFirstNameEqual && isLastNameEqual) {
                student.setAge(age);
                student.setHometown(hometown);
                return true;
            }
        }
        return false;
    }
    public static class Students1 {
        private String firstName;
        private String lastName;
        private int age;
        private String hometown;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getHometown() {
            return hometown;
        }

        public void setHometown(String hometown) {
            this.hometown = hometown;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public Students1(String firstName, String lastName, int age, String hometown) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.hometown = hometown;
        }

        @Override
        public String toString() {
            return this.firstName + " " + this.lastName + " " + "is" + " " + this.age + " " + "years old";
        }
    }
}
