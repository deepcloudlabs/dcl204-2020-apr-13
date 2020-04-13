package com.example;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudyString {
    public static void main(String[] args) {
        String s = new String("Jack"); // Heap
        String p = "Jack"; // CP: Constant Pool (Cache)
        String q = "Jack"; // Object Caching --> Immutable
        s = s.intern(); // internalized
        System.out.println("p==q: " + (p.equals(q)));
        System.out.println("p==s: " + (p.equals(s)));
        System.out.println("2+2=" + (2 + 2));
    }
}
