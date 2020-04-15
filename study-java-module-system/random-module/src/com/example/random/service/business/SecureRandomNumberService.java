package com.example.random.service.business;

import com.example.random.service.RandomNumberService;

import java.security.SecureRandom;
import java.util.Random;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class SecureRandomNumberService implements RandomNumberService {
    private Random rand = new SecureRandom();

    @Override
    public int generate(int min, int max) {
        return rand.nextInt(max - min) + min;
    }
}
