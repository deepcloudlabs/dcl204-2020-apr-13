package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// Benchmarking -> MicroBenchmarking ???
public class StudyList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(8);
        list.add(23);
        list.add(42);
        list.add(8);
        list.add(16);
        list.add(8);
        list.add(0,15);
        System.out.println(list);
        System.out.println(list.contains(42));
        System.out.println(list.size()); // --> 8
        System.out.println(list.get(0)); // --> 4
        System.out.println(list.get(3)); // --> 42
        Collections.sort(list,(x,y)->y-x);
        System.out.println(list);
    }
}
