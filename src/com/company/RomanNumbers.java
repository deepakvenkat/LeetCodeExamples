package com.company;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Map;

public class RomanNumbers {
    static Map<Character, Integer> symbolValue = new HashMap();
    static {
        symbolValue.put('I', 1);
        symbolValue.put('V', 5);
        symbolValue.put('X', 10);
        symbolValue.put('L', 50);
        symbolValue.put('C', 100);
        symbolValue.put('D', 500);
        symbolValue.put('M', 1000);
    }

    static Map previousValue = new HashMap();
    static {
        previousValue.put('V', 'I');
        previousValue.put('X', 'I');
        previousValue.put('L', 'X');
        previousValue.put('C', 'X');
        previousValue.put('D', 'C');
        previousValue.put('M', 'C');

    }
    static Map <Integer, String> valueSymbolMap = new LinkedHashMap();
    static {
        valueSymbolMap.put(1000, "M");
        valueSymbolMap.put(900, "CM");
        valueSymbolMap.put(500, "D");
        valueSymbolMap.put(400, "CD");
        valueSymbolMap.put(100, "C");
        valueSymbolMap.put(90, "XC");
        valueSymbolMap.put(50, "L");
        valueSymbolMap.put(40, "XL");
        valueSymbolMap.put(10, "X");
        valueSymbolMap.put(9, "IX");
        valueSymbolMap.put(5, "V");
        valueSymbolMap.put(4, "IV");
        valueSymbolMap.put(1, "I");
    }

    public static int romanToInt(String s) {
        int sLength = s.length();
        Character[] sChars = s.chars().mapToObj(c -> (char)c).toArray(Character[]::new);

        int result = 0;
        for (int i = 0; i < sLength; i++) {
            Character currentChar = sChars[i];
            int currentVal = symbolValue.get(currentChar);
            if (i + 1 == sLength) {
                result += currentVal;
                break;
            }
            Character nextChar = sChars[i + 1];
            int nextVal = symbolValue.get(nextChar);
            if (previousValue.containsKey(nextChar) && previousValue.get(nextChar) == currentChar) {
                nextVal -= currentVal;
                result += nextVal;
                i += 1;
            } else {
                result += currentVal;
            }
        }

        return result;
    }

    public static String intToRoman(int num) {
        Set<Integer> keys = valueSymbolMap.keySet();
        Integer [] keysI = keys.toArray(new Integer[keys.size()]);
        String result = "";
        int i = 0;
        while (num > 0) {
            while (i < keysI.length) {
                if (num - keysI[i] >= 0) {
                    result = result.concat(valueSymbolMap.get(keysI[i]));
                    num -= keysI[i];
                } else {
                    i+= 1;
                }
            }
        }
        return result;
    }
}
