package com.example;

import java.time.ZoneId;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudyZone {
    public static void main(String[] args) {
        ZoneId.getAvailableZoneIds()
                .stream()
                .filter(zone -> zone.contains("Asia"))
                .forEach(System.out::println);
    }
}
