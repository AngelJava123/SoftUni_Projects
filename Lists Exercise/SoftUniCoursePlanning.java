package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> schedule = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String commands = scanner.nextLine();
        while (!commands.equals("course start")) {

            List<String> commandType = Arrays.asList(commands.split(":"));

            String commandName = commandType.get(0);

            if (commandName.equals("Add")) {
                if (!schedule.contains(commandType.get(1))) {
                    schedule.add(commandType.get(1));
                }
            } else if (commandName.equals("Insert")) {
                if (!schedule.contains(commandType.get(1))) {
                    schedule.add(Integer.parseInt(commandType.get(2)), commandType.get(1));
                }
            } else if (commandName.equals("Remove")) {
               if (schedule.contains(commandType.get(1))) {
                   schedule.remove(commandType.get(1));
               }
            } else if (commandName.equals("Swap")) {
                String lessonTitle1 = commandType.get(1);
                String lessonTitle2 = commandType.get(2);

                String exercise1 = lessonTitle1 + "-Exercise";
                String exercise2 = lessonTitle2 + "-Exercise";

                if (schedule.contains(lessonTitle1)
                        && schedule.contains(lessonTitle2)) {
                    int lessonTitleIndex = schedule.indexOf(lessonTitle1);
                    int lessonTitleIndex2 = schedule.indexOf(lessonTitle2);
                    schedule.set(lessonTitleIndex, lessonTitle2);
                    schedule.set(lessonTitleIndex2, lessonTitle1);

                    if (schedule.get(lessonTitleIndex + 1).equals(exercise1)) {
                        schedule.remove(lessonTitleIndex + 1);
                        schedule.add(lessonTitleIndex2 + 1, exercise1);
                    }
                    if (lessonTitleIndex2 != schedule.size()-1 && schedule.get(lessonTitleIndex2 +1).equals(exercise2)) {
                        schedule.remove(lessonTitleIndex2 + 1);
                        schedule.add(lessonTitleIndex + 1, exercise2);
                    }
                }
            } else if (commandName.equals("Exercise")) {
                String exercise = commandType.get(1) + "-Exercise";

                int indexLesson = schedule.indexOf(commandType.get(1));
                if (schedule.contains(commandType.get(1))) {
                    if (indexLesson == schedule.size()-1) {
                        schedule.add(indexLesson + 1, exercise);
                    } else if (!schedule.get(indexLesson + 1).equals(exercise)) {
                        schedule.add(indexLesson + 1, exercise);
                    }
                } else {
                    schedule.add(commandType.get(1));
                    schedule.add(exercise);
                }
            }
            commands= scanner.nextLine();
        }
        printList(schedule);
    }

    private static void printList(List<String> elements) {
        int count = 1;
        for (String element: elements) {
            System.out.println(count + "." + element);
            count++;
        }
    }
}
