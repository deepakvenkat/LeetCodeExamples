package com.company;

import java.util.*;

public class PhoneNumber {
    static Map<String, String> numberStringMap = new HashMap<String, String>();
    static {
        numberStringMap.put("2", "abc");
        numberStringMap.put("3", "def");
        numberStringMap.put("4", "ghi");
        numberStringMap.put("5", "jkl");
        numberStringMap.put("6", "mno");
        numberStringMap.put("7", "pqrs");
        numberStringMap.put("8", "tuv");
        numberStringMap.put("9", "wxyz");
    };

    public List<String> letterCombinations(String digits) {
        List <String> result = new ArrayList();
        if (digits == "") {
            return result;
        }
        String [] digitArray = digits.split("");
        for (String digit : digitArray) {
            if (numberStringMap.containsKey(digit)) {
                String [] chars = numberStringMap.get(digit).split("");
                List <String> tempResult = new ArrayList();
                if (result.isEmpty()) {
                    // this would be the first element
                    result = Arrays.asList(chars);
                } else {
                    result.forEach((r) -> {
                        for(String c: chars) {
                            tempResult.add(r + c);
                        }
                    });
                    result = tempResult;
                }
            } else {
                // what to do here?
            }
        }
        return result;
    }
}
