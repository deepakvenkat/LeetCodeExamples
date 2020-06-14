package com.company;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int [] right = new int[nums.length];
        int [] left = new int[nums.length];
        int [] result = new int[nums.length];
        right[0] = 1;
        left[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            right[i] = right[i - 1] * nums[i - 1];
        }
        for (int i = nums.length - 2; i > -1 ; i--) {
            left[i] = left[i+1] * nums[i+1];
        }
        for (int i = 0; i < nums.length; i++) {
            result[i] = right[i] * left[i];
        }
        return result;
    }
}
