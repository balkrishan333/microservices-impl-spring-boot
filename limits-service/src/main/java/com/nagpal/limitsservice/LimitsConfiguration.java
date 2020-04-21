package com.nagpal.limitsservice;

public class LimitsConfiguration {

    int minimum;
    int maximum;

    protected LimitsConfiguration(){}

    public LimitsConfiguration(int min, int max) {
        this.minimum = min;
        this.maximum = max;
    }

    public int getMaximum() {
        return maximum;
    }

    public int getMinimum() {
        return minimum;
    }
}
