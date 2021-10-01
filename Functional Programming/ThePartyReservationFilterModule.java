package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> guests = Arrays.stream(reader.readLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayList::new));

        String line = reader.readLine();

        HashMap<String, Predicate> predicates = new HashMap<>();

        while (!line.equals("Print")){

            String[] tokens = line.substring(line.indexOf(";") + 1).split("([ ;]+)");
            int index = 2;
            if(tokens.length == 2){
                index = 1;
            }
            String name = tokens[0] + tokens[index];

            if(line.contains("Add")){
                Predicate<String> predicate = null;
                switch (tokens[0]){
                    case "Starts":
                        predicate = s -> s.startsWith(tokens[2]);
                        predicates.putIfAbsent(name, predicate);
                        break;
                    case "Ends":
                        predicate = s -> s.endsWith(tokens[2]);
                        predicates.putIfAbsent(name, predicate);
                        break;
                    case "Length":
                        predicate = s -> s.length() == Integer.parseInt(tokens[2]);
                        predicates.putIfAbsent(name, predicate);
                        break;
                    case "Contains":
                        predicate = s -> s.contains(tokens[1]);
                        predicates.putIfAbsent(name, predicate);
                        break;
                }
            }else{
                predicates.remove(name);
            }
            line = reader.readLine();
        }

        for (String guest : guests) {
            boolean isGoing = true;

            for (String entry : predicates.keySet()) {
                if(predicates.get(entry).test(guest)){
                    isGoing = false;
                    break;
                }
            }

            if(isGoing){
                System.out.print(guest + " ");
            }
        }
    }
}
