package com.example;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudyThreadPools {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Thread Pool -> ExecutorService
        // var executorService = Executors.newCachedThreadPool();
        var executorService = Executors.newFixedThreadPool(32);
        var task = new LotteryCallableTask();
        var future = new FutureTask<List<Integer>>(task);
        executorService.submit(future);
        System.out.println(future.get());
        System.out.println("Done!");
        executorService.shutdown();
    }
}
