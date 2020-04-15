package com.example;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class StudyMap {
    public static void main(String[] args) {
        Map<String,Integer> areaCodes = new HashMap<>();
/*
        Map<String,Integer> areaCodes = new LinkedHashMap<>();
        Map<String,Integer> areaCodes = new TreeMap<>();
*/
        areaCodes.put("istanbul-anadolu", 216);
        areaCodes.put("istanbul-avrupa", 212);
        areaCodes.put("ankara", 312);
        System.out.println(areaCodes.get("ankara"));
        // Loop: Key
        for (String city : areaCodes.keySet()){
            System.out.println(city);
        }
        // Loop: Value
        for (int code : areaCodes.values()){
            System.out.println(code);
        }
        // Loop: Entry (Pair)
        for (Map.Entry<String,Integer> entry : areaCodes.entrySet()){
            System.out.println(String.format("%s: %d",entry.getKey(),entry.getValue()));
        }
        // Internal Loop (Java 8)
        areaCodes.forEach((k,v)->System.out.println(String.format("%s: %d",k,v)));
    }
}
