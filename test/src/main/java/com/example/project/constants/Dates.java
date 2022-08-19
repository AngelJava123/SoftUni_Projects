package com.example.final_project.constants;

import java.time.LocalDate;

public class Dates {

    public static final LocalDate CURRENT = LocalDate.now();

    public static final String ONE_MONTH = CURRENT + " - " + CURRENT.plusMonths(1);

    public static final String TREE_MONTHS = CURRENT + " - " + CURRENT.plusMonths(3);

    public static final String SIX_MONTHS = CURRENT + " - " + CURRENT.plusMonths(6);

    public static final String ONE_YEAR = CURRENT + " - " + CURRENT.plusMonths(12);
}
