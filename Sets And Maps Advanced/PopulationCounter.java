package com.company;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class PopulationCounter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Sofia|Bulgaria|1

        Map<String, LinkedHashMap<String, Long>> population = new LinkedHashMap<>();

        String input = reader.readLine();
        while (!input.equals("report")) {

            String[] inputData = input.split("\\|");

            String city = inputData[0];
            String country = inputData[1];
            long populationCount = Integer.parseInt(inputData[2]);

            if (!population.containsKey(country)) {
                population.put(country, new LinkedHashMap<>());
                population.get(country).put(city, populationCount);
            } else {
                if (!population.get(country).containsKey(city)) {
                    population.get(country).put(city, populationCount);
                }
            }
            input = reader.readLine();
        }
        System.out.println();
        // Countries should be ordered by their total population in descending order and
        // within each country, the cities should be ordered by the same criterion. If
        // two countries/cities have the same population, keep them in the order in which they were entered.

        // Пускаме стрийм на основния мап и сортираме като взимаме на всяка държава(ключ на основния мап)
        // стойността, която е Мап от Стринг и
        // Лонг, след това взимаме стойноста лонг от вътрешния мап, пускаме стрийм, редуцираме и намираме сумата.
        // сравняваме сумите 2 с 1 за десендинг ордър за всяка държава.
        // За всяка държава отпечатваме държавата и сумата.
        // За всяка държава взимаме стойността и пускаме стрийм, сортираме по градове(ключове на вътрешния мап)
        // в десендинг ордър като отново сравняваме град 2 с 1 за десендинг ордър за всеки град.
        // за всеки град принтираме името на града и популацията му.

        population.entrySet().stream()
                .sorted((country1, country2) -> country2.getValue().values().stream().reduce(0L, Long::sum)
                        .compareTo(country1.getValue().values().stream().reduce(0L, Long::sum)))
                .forEach(country -> {
                    System.out.printf("%s (total population: %d)%n", country.getKey(),
                            country.getValue().values().stream().reduce(0L, Long::sum));
                    country.getValue().entrySet().stream()
                            .sorted((city1, city2) -> city2.getValue().compareTo(city1.getValue()))
                            .forEach(city -> System.out.printf("=>%s: %d%n", city.getKey(), city.getValue()));
                });
    }
}
