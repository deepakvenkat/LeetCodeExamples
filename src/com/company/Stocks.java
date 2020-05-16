package com.company;

public class Stocks {
    public int maxSingleProfit(int[] prices) {
        int minValue = Integer.MAX_VALUE;
        int maxDiff = 0;
        for (int i = 0; i < prices.length; i++) {
            if (minValue > prices[i]) {
                minValue = prices[i];
            }
            if (maxDiff < (prices[i] - minValue)) {
                maxDiff = prices[i] - minValue;
            }
        }
        return maxDiff;
    }
}
