package com.example;

import java.time.LocalDate;
import java.time.Month;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudyLocalDate {
    public static void main(String[] args) {
        // throws DateTimeException -> RuntimeException -> Bug!!!
        LocalDate date = LocalDate.of(1973, Month.JULY, 11);
        LocalDate date2 = LocalDate.of(2020, Month.FEBRUARY, 28);
        System.out.println(date2);
        date2 = date2.plusDays(1);
        System.out.println(date2);
    }
}
