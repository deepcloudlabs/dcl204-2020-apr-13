package com.example.random.service.business;

import com.example.random.service.RandomNumberService;

import java.util.concurrent.ThreadLocalRandom;

public class SimpleRandomNumberService implements RandomNumberService {
    @Override
    public int generate(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }
}
