package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class OSPlanning_STACK {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] task = Arrays.stream(reader.readLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int[] thread = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int value = Integer.parseInt(reader.readLine());

        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        ArrayDeque<Integer> threads = new ArrayDeque<>();

        for (int i = 0; i < task.length; i++) {
            tasks.push(task[i]);
        }
        for (int i = 0; i < thread.length; i++) {
            threads.offer(thread[i]);
        }

        while (true) {

            int taskValue = tasks.peek();
            int threadValue = threads.peek();

            if (taskValue == value) {
                System.out.println("Thread with value " + threadValue + " killed task " + taskValue);
                break;
            }

            if (threadValue >= taskValue) {
                tasks.pop();
                threads.poll();
            }
            if (threadValue < taskValue) {
                threads.poll();
            }
        }
        threads.forEach(integer -> System.out.print(integer + " "));
    }
}
