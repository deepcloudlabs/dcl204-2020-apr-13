package com.example;

import java.util.Locale;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudyString {
    public static void main(String[] args) {
        Locale locale = new Locale("tr", "TR"); // ISO
        String city = "izmir"; // immutable
        city = city.toUpperCase(locale);
        System.out.println(city);
    }
}
