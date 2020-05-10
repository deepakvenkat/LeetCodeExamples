package com.company;
import static org.junit.Assert.*;

import com.company.LongestSubstring;
public class Main {

    public static void main(String[] args) {
	// write your code here
        int longestSubstringLength = LongestSubstring.lengthOfLongestSubstring("abba");
        assertEquals(2, longestSubstringLength);
    }
}
