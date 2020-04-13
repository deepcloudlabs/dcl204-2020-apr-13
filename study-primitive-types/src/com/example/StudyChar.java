package com.example;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudyChar {
    public static void main(String[] args) {
        char c = 'x'; // 2-byte, unsigned int
        System.out.println((char) (c + 1));
        c = '\u20BA';
        System.out.println(c);
    }
}
