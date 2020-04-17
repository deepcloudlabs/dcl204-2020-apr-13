package com.example;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudyDateTimeFormatter {
    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now();
        Locale tr = new Locale("tr");
        DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                .withLocale(Locale.SIMPLIFIED_CHINESE);
        System.out.println(dtf.format(now));
    }
}
