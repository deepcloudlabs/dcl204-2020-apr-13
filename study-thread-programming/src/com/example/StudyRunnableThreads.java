package com.example;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudyRunnableThreads {
    public static void main(String[] args) throws InterruptedException {
        LotteryTask task1 = new LotteryTask();
        Thread t1 = new Thread(task1);
        t1.start();
        //  synchronization: main thread waits for t1's completion
        t1.join(); // blocking
        System.out.println(task1.getNumbers());
        System.out.println("Done.");
    }
}

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
class LotteryTask implements Runnable {
    private List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public void run() {
        numbers = ThreadLocalRandom.current().ints(1, 50)
                .distinct()
                .limit(6)
                .sorted()
                .boxed()
                .collect(Collectors.toList());
    }
}