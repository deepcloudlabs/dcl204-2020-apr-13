package com.example.service.impl;

import com.example.service.Calculator;

public class SimpleCalculator implements Calculator {
    @Override
    public double add(double x, double y) {
        return x + y;
    }

    @Override
    public double sub(double x, double y) {
        return x - y;
    }

    @Override
    public double mul(double x, double y) {
        return x * y;
    }

    @Override
    public double div(double x, double y) {
        return x / y;
    }
}
