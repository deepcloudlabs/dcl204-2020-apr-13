package com.example;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class DynamicString {
    public static void main(String[] args) {
        //StringBuilder: it is NOT ThreadSafe
        //StringBuffer: it is ThreadSafe
        StringBuffer s = new StringBuffer(204888890); // mutable
        long start = System.currentTimeMillis();
        for (int i = 0; i < 27_000_000; ++i)
            s.append(i); // creates a new String each time
        long stop = System.currentTimeMillis();
        System.out.println(
                String.format(
                        "length: %d, duration: %d ms",
                        s.length(), (stop - start))
        );
    }
}
