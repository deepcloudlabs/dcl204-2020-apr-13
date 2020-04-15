package com.example.lottery.service;

import com.example.random.service.RandomNumberService;

import java.util.List;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public interface LotteryService {
    List<Integer> draw();

    List<List<Integer>> draw(int column);

    void setRandomNumberService(RandomNumberService rns);
}
