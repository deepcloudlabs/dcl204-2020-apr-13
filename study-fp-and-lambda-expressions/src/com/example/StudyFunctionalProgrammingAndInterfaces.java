package com.example;

import java.util.List;
import java.util.function.Predicate;
import java.util.function.ToLongFunction;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudyFunctionalProgrammingAndInterfaces {

    public static void main(String[] args) {
        // Class -> Employee
        var jack = new Employee("1", "Jack Bauer",
                100_000, "TR1", 1956); // Java 10
        var i = 42; // int -> primitive
        // Variables -> Value

        // Java 8: Function Programming
        // You can assign a function to a variable!
        // SAM: Single Abstract Method -> Functional Interface
        // anonymous class
        Predicate<Integer> isEvenFun = new Predicate<>() {

            @Override
            public boolean test(Integer x) {
                if (x % 2 == 0) return true;
                return false;
            }
        };
        Predicate<Integer> isEven =
                // (1) Lambda Expression
                (Integer x) -> {
                    if (x % 2 == 0) return true;
                    return false;
                };
        Predicate<Integer> isEven2 =
                (x) -> {
                    if (x % 2 == 0) return true;
                    return false;
                };
        Predicate<Integer> isEven3 =
                x -> {
                    if (x % 2 == 0) return true;
                    return false;
                };
        Predicate<Integer> isEven4 =
                x -> {
                    return (x % 2 == 0);
                };
        Predicate<Integer> isEven5 = x -> x % 2 == 0;
        // (2) Method Reference
        Predicate<Integer> isEven6 = Numbers::even;

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        ToLongFunction<Integer> square = x -> x * x;
        var sum = numbers.stream().filter(Numbers::even)
                .mapToLong(square)
                .sum();
        System.out.println("sum=" + sum);
    }
}

// Java 8 : interface have static methods
interface Numbers {
    static boolean even(Integer i) {
        return i % 2 == 0;
    }
}

// Java 14: record -> preview
record Employee(String identity,
                String fullName,
                double salary,
                String iban,
                int birthYear) {
}