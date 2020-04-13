package com.example;

import java.math.BigDecimal;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudyFloatingPointNumbers {
    public static void main(String[] args) {
        // CPU : FPU -> IEEE-754v5
        float pi = 3.141516171819F; // 4-byte
        double money = 2.0; // 8-byte
        money = money - 1.1;
        System.out.println(money > 0.89999999 && money < 0.90000001);
        System.out.println(String.format("%8.24f", money));
        float x = 1_000_000_000;
        x = x + 50;
        System.out.println(String.format("%16.24f", x));
        BigDecimal bd = BigDecimal.valueOf(2);
        bd = bd.subtract(BigDecimal.valueOf(1.1));
        System.out.println(bd);
        double one = 0. / 0.;
        one = one + 1;
        System.out.println(Double.isNaN(one));
    }
}
