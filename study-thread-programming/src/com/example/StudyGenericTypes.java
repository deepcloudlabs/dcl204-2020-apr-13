package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudyGenericTypes {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        // List<int> nums = new ArrayList<>(); Java 1x
        int x = 42; // 4 Byte
        Integer y = 42; // 12 + 4 = 16B -> Memory Footprint x4

        x = x + 1;
        y = y + 1; // ==> y = Integer.valueOf(y.intValue() + 1);
    }
}
