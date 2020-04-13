package com.example;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudyArrays {

    public static void main(String[] args) {
        int x = 42; // scalar
        int numbers[] = {4, 42, 16, 23, 8, 15}; // 1 // array
        numbers = new int[]{4, 42, 16, 23, 8, 15}; // 2
        // 3
        numbers = new int[6];
        numbers[0] = 4;
        numbers[1] = 42;
        numbers[2] = 16;
        numbers[3] = 23;
        numbers[4] = 8;
        numbers[5] = 15;
        // External Loop #1
        int sum = 0;
        for (int i = 0; i < numbers.length; ++i) {
            sum += numbers[i];
        }
        System.out.println("sum=" + sum);
        // External Loop #2 (SE 5)
        sum = 0;
        for (int num : numbers) // safe, ro, sequential
            sum += num;
        System.out.println("sum=" + sum);
        // Internal Loop #3 (SE 8), Stream API : FP + FilterMapReduce
        sum = Arrays.stream(numbers).map(num -> num * num).parallel().sum();

        //arrays are static!!!
        // prefer collections over arrays
        A a = new A();// Stack, reference?
        // Fluent API: Date/Time API, Stream API
        ThreadLocalRandom.current().ints(1, 50)
                .parallel()
                .distinct()
                .limit(6)
                .sorted() // lazy
                .sequential() // lazy
                .forEach(System.out::println); // terminal

    }
}

class A {
}
