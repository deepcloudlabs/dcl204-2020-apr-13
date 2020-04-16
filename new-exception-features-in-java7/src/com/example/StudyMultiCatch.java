package com.example;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudyMultiCatch {
    public static void fun() throws E1 {
    }

    public static void gun() throws E2 {
    }

    public static void sun() throws E3, E4 {
    }

    public static void main(String[] args) {
        try {
            fun();
            gun();
            sun();
        } catch (E1 | E2 | E3 | E4 e) { // multi-catch
            System.err.println(e.getMessage());
        }
    }
}

class E1 extends Exception {
}

class E2 extends Exception {
}

class E3 extends Exception {
}

class E4 extends Exception {
}

