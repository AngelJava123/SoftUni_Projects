package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> ip = new TreeMap<>();
        Map<String, TreeSet<String>> ipData = new TreeMap<>();

        int n = Integer.parseInt(reader.readLine());
        while (n-- > 0) {
            String[] input = reader.readLine().split("\\s+");

            String ipAddress = input[0];
            String user = input[1];
            int count = Integer.parseInt(input[2]);

            if (!ip.containsKey(user)) {
                ip.put(user, count);
                ipData.put(user, new TreeSet<>());
            } else {
                ip.put(user, ip.get(user) + count);
            }
            ipData.get(user).add(ipAddress);
        }
        List<String> result = new ArrayList<>();

        for (Map.Entry<String, Integer> key : ip.entrySet()) {
            result.add(key.getKey() + ": " + key.getValue());
        }
        int count = 0;
        for (Map.Entry<String, TreeSet<String>> data : ipData.entrySet()) {
            System.out.println(result.get(count++) + " " + data.getValue());
        }
    }
}
