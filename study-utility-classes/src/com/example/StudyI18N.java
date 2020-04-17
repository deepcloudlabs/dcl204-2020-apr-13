package com.example;

import java.text.MessageFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudyI18N {
    public static void main(String[] args) {
        Locale locale = new Locale("tr", "TR");
        ResourceBundle bundle = ResourceBundle.getBundle(
                "messages", locale);
        ZonedDateTime now = ZonedDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                .withLocale(locale);
        MessageFormat formatter = new MessageFormat(
                bundle.getString("report.title"), locale);
        System.out.println(formatter.format(
                new Object[]{dtf.format(now)})
        );
    }
}
