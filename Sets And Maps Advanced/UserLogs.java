package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class UserLogs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<String, LinkedHashMap<String, Integer>> ip = new TreeMap<>();

        String input = reader.readLine();
        while (!input.equals("end")) {

            String idAddress = input.split("\\s+")[0];
            String name = input.split("\\s+")[2];

            String IP = idAddress.split("=")[1];
            String userName = name.split("=")[1];

            if (!ip.containsKey(userName)) {
                ip.put(userName, new LinkedHashMap<>());
                ip.get(userName).put(IP, 1);
            } else {
                if (!ip.get(userName).containsKey(IP)) {
                    ip.get(userName).put(IP, 1);
                } else {
                    ip.get(userName).put(IP, ip.get(userName).get(IP) + 1);
                }
            }

            input = reader.readLine();
        }
        ip.forEach((key, value) -> {
            AtomicInteger count = new AtomicInteger();
            System.out.println(key + ":");
            value.forEach((key1, value1) -> {

                String format =
                        (count.getAndIncrement() == value.size() - 1)
                                ? "%s => %d.%n"
                                : "%s => %d, ";

                System.out.printf(format, key1, value1);
            });
        });
    }
}
