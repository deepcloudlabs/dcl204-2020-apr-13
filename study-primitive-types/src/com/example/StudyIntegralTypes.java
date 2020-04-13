package com.example;

import java.math.BigInteger;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudyIntegralTypes {
    public static void main(String[] args) {
        byte b = 1; // 1-byte, [-128..127]
        b = 127;
        b++;
        System.out.println("b=" + b);
        b = -128;
        b--;
        System.out.println("b=" + b);
        short s = 2; // 2-byte
        int i = 3; // 4-byte [-2147483648..2147483647]
        i = Integer.MAX_VALUE;
        System.out.println("i=" + i);
        i++;
        System.out.println("i=" + i);
        long l = 4; // 8-byte, [-9223372036854775808..9223372036854775807]
        l = Long.MAX_VALUE;
        System.out.println("l=" + l);
        l++;
        System.out.println("l=" + l);
        // Immutable: String, int -> Integer, long -> Long
        BigInteger bi = BigInteger.valueOf(Long.MAX_VALUE);
        System.out.println(bi);
        bi = bi.add(BigInteger.ONE);
        System.out.println(bi);
        byte u = 127, v = 1, w = 0;
        w = (byte) (u + v); // JLS: Java Language Specification
        w += u + v; // implicit type casting
        w = (byte) (w + u + v);
        l = 2147483647L + 1;
        System.out.println("l=" + l);
        l = 12345 + 5432L;
        System.out.println("l=" + l);
        int one = 1 / 0;
        System.out.println("one=" + one);
    }
}
