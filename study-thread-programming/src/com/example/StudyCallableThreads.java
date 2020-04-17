package com.example;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudyCallableThreads {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        var task = new LotteryCallableTask();
        var future = new FutureTask<List<Integer>>(task);
        new Thread(future).start();
        System.out.println(future.get());
        System.out.println("Done!");
    }
}

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
class LotteryCallableTask implements Callable<List<Integer>> {

    @Override
    public List<Integer> call() {
        return ThreadLocalRandom.current().ints(1, 50)
                .distinct()
                .limit(6)
                .sorted()
                .boxed()
                .collect(Collectors.toList());
    }
}