package com.example;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudyNewFeaturesInterfaces89 {
    public static void main(String[] args) {
        // Java SE 8
        // 1. static method => Utility methods in Functional Programming
        // 2. default method => Collection API => Stream API
        // Java SE 9
        // 1. private static
        // 2. private method
    }
}

class A implements X {
}

interface X {
    public static int square(int x) {
        return x * x;
    }

    public default int fun() {
        return 42;
    }

    ;
}

interface U {
    default void gun() {
    }
}

interface V {
    default void gun() {
    }
}

// diamond problem!!!
class Z implements U, V {
    @Override
    public void gun() {

    }
}