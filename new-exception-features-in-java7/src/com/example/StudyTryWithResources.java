package com.example;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudyTryWithResources {

    public static int fun() {
        throw new IllegalArgumentException("Have fun!");
    }

    public static int gun() {
        try {
            // Windows: echo %ERRORLEVEL%
            // Linux+Unix : echo $?
            // 0 : Ok
            // != 0 : Error
            System.exit(42);
        } finally {
            return 108; // returns 108
        }
    }

    public static void main(String[] args) {
        // System.err.println(gun());
        // try-catch-finally
        // try-with-resources (Java 7)
        try (
                PreciousResource res1 = new PreciousResource(1);
                PreciousResource res2 = new PreciousResource(2);
                PreciousResource res3 = new PreciousResource(3);
        ) {
            System.err.println(fun());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        /*
        finally {
            System.err.println("Finally we have arrived here!");
            try {
                res1.close();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            } finally {
                try {
                    res2.close();
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                } finally {
                    try {
                        res3.close();
                    } catch (IOException e) {
                        System.err.println(e.getMessage());
                    }
                }
            }
        }
        */
    }
}

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
class PreciousResource implements Closeable {
    private final int id;

    public PreciousResource(int id) {
        this.id = id;
    }

    @Override
    public void close() throws IOException {
        System.err.println("Closing the precious resource " + id + "...");
        throw new IOException("Cannot close the resource!!!");
    }
}
