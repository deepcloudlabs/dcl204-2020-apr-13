package com.example;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RandomNumber {
    // primitive types: byte, short, int, long, char, boolean, float, double, String
    // wrapper classes: Byte, Short, Integer, Long, Character, Boolean, Float, Double
    // Array, Annotation
    // convention
    int min() default 1;

    int max() default 50;

    int size() default 6;

    boolean sorted() default true;
}
