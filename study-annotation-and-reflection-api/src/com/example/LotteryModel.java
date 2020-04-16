package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
// Client
public class LotteryModel {
    @RandomNumber(size=8) // convention over configuration
    private List<Integer> numbers;

    public LotteryModel() {
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
