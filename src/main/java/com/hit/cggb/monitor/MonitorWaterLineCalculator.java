package com.hit.cggb.monitor;

/**
 * @author Charies Gavin
 *         https:github.com/guobinhit
 * @date 10/25/19,6:18 PM
 * @description water line calculator
 */
public class MonitorWaterLineCalculator {

    // Water line of 0 < percentXx < 1
    private double percentXx;

    // Total calls
    private long count;

    private final double[] SCALE = new double[2400];

    private long[] countContainer = new long[2400];

    /**
     * Construction method
     *
     * @param waterLine 0 < percentXx < 100
     */
    public MonitorWaterLineCalculator(int waterLine) {
        if (waterLine < 0 || waterLine > 100) {
            throw new IllegalArgumentException("waterLine must be less than 100 and more than 0");
        } else {
            percentXx = (100.0 - waterLine) / 100;
        }

        // Initialize the SCALE array, 1 ~ 1000, step is 1
        for (int i = 0; i < 1000; i++) {
            SCALE[i] = i + 1;
        }
        // Initialize the SCALE array, 1001 ~ 10000, step is 10
        for (int i = 1000, j = 10; i < 1900; i++, j += 10) {
            SCALE[i] = 1000 + j;
        }
        // Initialize the SCALE array, 10001 ~ 60000, step is 100
        for (int i = 1900, j = 100; i < 2400; i++, j += 100) {
            SCALE[i] = 10000 + j;
        }
    }

    /**
     * If you want to cumulative value, call this method
     *
     * @param value value to be accumulated
     */
    public synchronized void calculate(double value) {
        // Cumulative calls
        count++;
        // Find index
        int index = positionInValueArray(value);
        countContainer[index]++;
    }

    /**
     * If you want to get result, call this method
     *
     * @return the percent value of waterline
     */
    public synchronized double getResult() {
        // Prevent the exception with count 0. Note that the order is natural [1, count]
        long percentXxPos = adjust((long) (count * percentXx), count);

        double percentXxValue = Double.MAX_VALUE;

        // Start to traverse each element, and calculate from the beginning to the end
        int scanned = 0;
        int length = countContainer.length;
        for (int index = 0; index <= length - 1; index++) {
            // There is no current value and it will not be an alternative in any case
            if (0.0 == countContainer[index]) {
                continue;
            }
            // Current value
            scanned += countContainer[index];
            // Judge waterline
            if (scanned >= percentXxPos) {
                percentXxValue = SCALE[index];
                break;
            }
        }
        return percentXxValue;
    }

    private int positionByTwoDivision(double[] array, int begin, int end, double value) {
        int mid = (begin + end) >> 1;
        double midValue = array[mid];
        double halfMidValue = midValue / 2;

        // Judge whether the mid can be hit
        if (value > halfMidValue && value <= midValue) {
            return mid;
        }

        // Can't hit, it depends on the size
        if (value <= halfMidValue) {
            // Boundary conditions with no way to go
            if (mid - 1 < 0) {
                return 0;
            }
            return positionByTwoDivision(array, begin, mid - 1, value);
        } else {
            return positionByTwoDivision(array, mid + 1, end, value);
        }
    }

    private int positionInValueArray(double val) {
        int length = SCALE.length;

        if (val >= SCALE[length - 1]) {
            return length - 1;
        } else if (val <= SCALE[0]) {
            return 0;
        }

        // Use dichotomy to calculate
        return positionByTwoDivision(SCALE, 0, length - 1, val);
    }

    // Make sure it is within the range of [1, Max], natural order
    private long adjust(long input, long max) {
        if (input <= 1) {
            return 1;
        } else if (input >= max) {
            return max;
        } else {
            return input;
        }
    }
}
