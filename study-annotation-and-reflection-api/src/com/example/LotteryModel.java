package com.example;

import java.util.ArrayList;
import java.util.List;

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
