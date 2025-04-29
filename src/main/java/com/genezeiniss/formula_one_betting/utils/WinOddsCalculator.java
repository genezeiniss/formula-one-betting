package com.genezeiniss.formula_one_betting.utils;

import java.util.Random;

public class WinOddsCalculator {

    private static final Random random = new Random();

    public static int calculate() {
        return 2 + random.nextInt(3);
    }
}
