package com.company;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        String lcp = "";
        String runningPrefix = "";
        if (strs.length == 0) {
            return "";
        }
        if (strs[0].length() == 0) {
            return "";
        }
        for (int j = 0; j < strs[0].length(); j++) {
            runningPrefix = strs[0].substring(0, j + 1);
            for (int i = 1; i < strs.length; i++) {
                if(strs[i].length() < j + 1) {
                    runningPrefix = "";
                    break;
                }
                if (!strs[i].substring(0, j + 1).equals(runningPrefix)) {
                    runningPrefix = "";
                    break;
                }
            }
            if (runningPrefix.length() <= lcp.length()) {
                break;
            } else {
                lcp = runningPrefix;
            }
        }

        return lcp;
    }
}
