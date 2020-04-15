package com.example;

import java.util.*;

public class StudySet {
    public static void main(String[] args) {
        //Set<Integer> set = new HashSet<>(); // Order: chaotic
        //Set<Integer> set = new LinkedHashSet<>(); // Order: insertion
        Set<Integer> set = new TreeSet<>((x,y)->y-x); // Order: sorted (Red-Black Tree)
        // Alt + Shift + Insert : switch to Column Selection Mode
        set.add(4);
        set.add(8);
        set.add(23);
        set.add(42);
        set.add(15);
        set.add(8);
        set.add(16);
        set.add(8);
        System.out.println(set);
        System.out.println(set.contains(42));
        // HashSet -> O(1)
        // TreeSet -> O(l2n)
        System.out.println(set.size()); // --> 6
    }
}
