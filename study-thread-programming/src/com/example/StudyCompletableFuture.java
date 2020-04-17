package com.example;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudyCompletableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<List<Integer>> lotteryNumbers =
                CompletableFuture.supplyAsync(
                        () -> ThreadLocalRandom.current().ints(1, 50)
                                .distinct()
                                .limit(6)
                                .sorted()
                                .boxed()
                                .collect(Collectors.toList()));
        System.out.println(lotteryNumbers.get());
        System.out.println("Done.");
    }

    // synchronous method
    public static int fun() {
        return 42;
    }

    // asynchronous method
    public static CompletableFuture<Integer> gun() {
        return CompletableFuture.supplyAsync(() -> 42);
    }

}
