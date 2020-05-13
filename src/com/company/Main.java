package com.company;
import static org.junit.Assert.*;

import com.company.LongestSubstring;
import com.company.ReverseInteger;
public class Main {

    public static void main(String[] args) {
	    // write your code here
        int longestSubstringLength = LongestSubstring.lengthOfLongestSubstring("abba");
        assertEquals(2, longestSubstringLength);

        // reverse integer. if overflown from 2^31 - 1 return 0
        assertEquals(321, ReverseInteger.reverse(123));
        assertEquals(-321, ReverseInteger.reverse(-123));
        assertEquals(0, ReverseInteger.reverse(0));
        assertEquals(0, ReverseInteger.reverse(1534236469));
    }
}
