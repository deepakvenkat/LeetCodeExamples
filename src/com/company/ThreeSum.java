package com.company;

import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> twoSum(int[] nums, int sum, int skipIndex) {
        List<List<Integer>> result = new ArrayList<List<Integer>> ();
        Map<Integer, Boolean> twoSumMap = new HashMap<Integer, Boolean>();
        for (int i = 0; i < nums.length; i++) {
            if (i != skipIndex) {
                Integer currentNumber = nums[i];
                Integer target = sum - currentNumber;
                if (twoSumMap.containsKey(target)) {
                    List<Integer> tempList = new ArrayList();
                    tempList.add(currentNumber);
                    tempList.add(target);
                    tempList.add(nums[skipIndex]);
                    result.add(tempList);
                } else {
                    twoSumMap.put(currentNumber, true);
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSumGeneric(int[] nums, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>> ();
        Map <Integer, List<Integer>> threeSumMap = new HashMap<Integer, List<Integer>>();
        Set<List<Integer>> uniqueTriplets = new HashSet<List<Integer>>();
        for (int i = 0; i< nums.length; i++) {
            List<List<Integer>> twoSumResult = twoSum(nums, sum - nums[i], i);
            if(!twoSumResult.isEmpty()) {
                twoSumResult.forEach((res) -> {
                    Collections.sort(res);
                    uniqueTriplets.add(res) ;
                });
            }
        }
        result.addAll(uniqueTriplets);
        return result;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        return threeSumGeneric(nums, 0);
    }
}
