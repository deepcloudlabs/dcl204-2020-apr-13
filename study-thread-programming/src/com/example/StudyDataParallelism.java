package com.example;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.*;

/*
       789  // Serial (1) Coding Time
       983            (3) Running Time
       783 *
       810
       807

       364  // ThreadPool + Future + Callable (1) Running Time
       376                                    (3) Coding Time
       370
       360 *
       367

       415   // Parallel Stream (1) Coding Time
       379 *                    (2) Running Time
       384
       381
       391
 */

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudyDataParallelism {
    private static final int LOGICAL_PROCESSORS =
            Runtime.getRuntime().availableProcessors();
    private static final int DATA_SIZE = 2_000_000_000;
    private static final int MIN_PARALLEL_STREAM_DATA_SIZE = 500_000_000;
    private static final int SIZE_PER_THREAD = DATA_SIZE / LOGICAL_PROCESSORS;
    private static final int[] data = new int[DATA_SIZE];
    private static final int LOOP = 5;
    private static ExecutorService executorService =
            Executors.newFixedThreadPool(LOGICAL_PROCESSORS);

    static {
        for (int i = 0; i < data.length; ++i)
            data[i] = i % 6;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        for (var i = 0; i < LOOP; ++i)
            sumArraySerial();
        System.out.println();
        for (var i = 0; i < LOOP; ++i)
            sumArrayParallel();
        executorService.shutdown();
        System.out.println();
        for (var i = 0; i < LOOP; ++i)
            sumArrayStreamParallel();
    }

    public static void sumArrayParallel() throws ExecutionException, InterruptedException {
        var futures = new ArrayList<Future<Long>>();
        var t1 = Instant.now();
        for (int i = 0, j = 0; i < LOGICAL_PROCESSORS; ++i, j += SIZE_PER_THREAD) {
            var future = executorService.submit(new ArraySumTask(data, j, SIZE_PER_THREAD));
            futures.add(future);
        }
        var sum = 0L;
        for (var future : futures) {
            sum += future.get();
        }
        var t2 = Instant.now();
        Duration between = Duration.between(t1, t2);
        System.out.println(String.format("%16d %8d", sum, between.toMillis()));
    }

    public static void sumArraySerial() {
        var t1 = Instant.now();
        var sum = 0L;
        for (int i = 0; i < data.length; sum += data[i], ++i) ;
        var t2 = Instant.now();
        Duration between = Duration.between(t1, t2);
        System.out.println(String.format("%16d %8d", sum, between.toMillis()));
    }

    public static void sumArrayStreamParallel() {
        var t1 = Instant.now();
        var stream = Arrays.stream(data);
        if (data.length > MIN_PARALLEL_STREAM_DATA_SIZE)
            stream = stream.parallel();
        var sum = stream.mapToLong(Long::valueOf).sum();
        var t2 = Instant.now();
        Duration between = Duration.between(t1, t2);
        System.out.println(String.format("%16d %8d", sum, between.toMillis()));
    }
}

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
class ArraySumTask implements Callable<Long> {
    private final int[] array;
    private final int start;
    private final int size;

    public ArraySumTask(int[] array, int start, int size) {
        this.array = array;
        this.start = start;
        this.size = size;
    }

    @Override
    public Long call() throws Exception {
        var sum = 0L;
        for (int i = start, j = 0; j < size; ++i, ++j)
            sum += array[i];
        return sum;
    }
}