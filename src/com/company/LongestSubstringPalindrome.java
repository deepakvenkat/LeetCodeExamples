package com.company;

class LongestSubstringPalindrome {
    public static boolean isPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < (n/2); i++ ) {
            if(s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }
    public static Boolean populateTable(Boolean [][] table, String s, int startIndex, int endIndex) {
        int sLength = s.length();
        if (startIndex == endIndex) {
            table[startIndex][endIndex] = true;
        }
        if (startIndex + 1 == endIndex) {
            table[startIndex][endIndex] = (s.charAt(startIndex) == s.charAt(endIndex));
        }
        if(table[startIndex][endIndex] == null) {
            table[startIndex][endIndex] = populateTable(table, s, startIndex + 1, endIndex - 1) && (s.charAt(startIndex) == s.charAt(endIndex));
        }
        return table[startIndex][endIndex];
    }

    public static String longestPalindrome(String s) {
        int sLength = s.length();
        Boolean [][] table = new Boolean[sLength][sLength];
        for (int i = 0; i < sLength; i++) {
            for (int j = sLength - 1; j >= i; j--) {
                LongestSubstringPalindrome.populateTable(table, s, i, j);
            }
        }
        String result = "";
        for (int i = 0; i < sLength; i++) {
            for (int j = sLength - 1; j >= i; j--) {
                if (table[i][j] == true) {
                    String subS = s.substring(i, j + 1);
                    if (subS.length() > result.length()) {
                        result = subS;
                    }
                }
            }
        }
        return result;
    }
}