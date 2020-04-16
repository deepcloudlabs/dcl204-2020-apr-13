package com.example;

import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class RandomNumberGenerator {
    public static void generate(Object o) throws IllegalAccessException {
         // Reflection API
        Class<?> clazz = o.getClass();
        for (Field field : clazz.getDeclaredFields()){
            if (field.isAnnotationPresent(RandomNumber.class)){
                // Read annotation
                RandomNumber rn = field.getAnnotation(RandomNumber.class);
                int min = rn.min();
                int max = rn.max();
                int size = rn.size();
                List<Integer> numbers = ThreadLocalRandom.current().ints(min, max)
                        .distinct()
                        .limit(size)
                        .sorted()
                        .boxed()
                        .collect(Collectors.toList());
                field.setAccessible(true);
                field.set(o,numbers);
                field.setAccessible(false);
            }
        }
    }
}
