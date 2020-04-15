package com.example.banking;

import java.util.stream.IntStream;

// 1. static field
// 2. static method
// Design: Utility class -> Objects, Files, Paths, Executors, Collectors, Collections
//                          Math
//         Stateless
//         i) final class ii) private constructor iii) static method
public class StudyStatic {
    public static void main(String[] args) {
        System.out.println(U.getCounter());
        IntStream.range(0, 10_000).forEach( i -> new U(i));
        System.out.println(U.getCounter());
    }
}

class U {
    private int i ;
    private static int counter = 0;

    // static method can only access to static attributes
    public static int getCounter() {
        return counter ;
    }

    // non-static method ==> non-static field + static field
    public U(int i) {
        this.i = i;
        counter++;
    }

    public int fun(){
        return i + counter ;
    }
}