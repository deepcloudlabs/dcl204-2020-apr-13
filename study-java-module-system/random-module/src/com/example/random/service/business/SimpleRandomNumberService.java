package com.example.random.service.business;

import com.example.random.service.RandomNumberService;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class SimpleRandomNumberService implements RandomNumberService {
    @Override
    public int generate(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }
}
