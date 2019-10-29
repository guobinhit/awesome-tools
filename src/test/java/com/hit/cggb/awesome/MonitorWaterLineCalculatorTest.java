package com.hit.cggb.awesome;

import com.hit.cggb.awesome.monitor.MonitorWaterLineCalculator;

/**
 * @author Charies Gavin
 *         https:github.com/guobinhit
 * @date 10/29/19,6:57 PM
 * @description water line calculator test class
 */
public class MonitorWaterLineCalculatorTest {
    public static void main(String[] args) {
        MonitorWaterLineCalculator calculator = new MonitorWaterLineCalculator(95);

        for (int i = 0; i < 100000; i++) {
            double temp = randGen(10, 1000);
            System.out.println(temp);
            calculator.calculate(temp);
        }

        System.out.println(calculator.getResult());
    }

    private static double randGen(int upper, int lower) {
        return Math.floor(Math.random() * (upper - lower)) + lower;
    }
}
