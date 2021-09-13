package com.company;

import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> companiesEmployeesIDs = new LinkedHashMap<>();

        String command = scanner.nextLine();

        while (!command.equals("End")) {

            String[] commandData = command.split(" -> ");

            String company = commandData[0];
            String iD = commandData[1];

            if (!companiesEmployeesIDs.containsKey(company)) {
                companiesEmployeesIDs.put(company, new ArrayList<>());
                companiesEmployeesIDs.get(company).add(iD);
            } else if (companiesEmployeesIDs.containsKey(company) && !companiesEmployeesIDs.get(company).contains(iD)) {
                companiesEmployeesIDs.get(company).add(iD);
                }
            command = scanner.nextLine();
        }
        companiesEmployeesIDs.entrySet().stream().
                sorted((e1, e2) -> CharSequence.compare(e1.getKey(), e2.getKey()))
                .forEach(entry -> {
                    System.out.println(entry.getKey());
                    List<String> companiesId = entry.getValue();
                    companiesId.forEach(iD -> System.out.println("-- " + iD));
         });
    }
}
