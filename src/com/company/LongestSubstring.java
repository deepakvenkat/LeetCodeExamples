package com.company;

import java.util.HashMap;

class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> alreadySeen = new HashMap();
        char [] sAsChar = s.toCharArray();
        String result = "";
        String window = "";
        int windowBeginIndex = 0;
        for (int i = 0; i < sAsChar.length; i++) {
            char c = sAsChar[i];
            window = window.concat(Character.toString(c));
            if(alreadySeen.containsKey(c)) {
                int lastSeenPosition = alreadySeen.get(c);
                if (lastSeenPosition >= windowBeginIndex) {
                    int windowNewPosition = (lastSeenPosition + 1) - windowBeginIndex;
                    window = window.substring(windowNewPosition);
                    windowBeginIndex = lastSeenPosition + 1;
                }
            }
            alreadySeen.put(c, i);
            if (window.length() > result.length()) {
                result = window;
            }
        }
        return result.length();

    }
}