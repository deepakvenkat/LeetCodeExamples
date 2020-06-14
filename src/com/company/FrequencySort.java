package com.company;

import java.util.*;

public class FrequencySort {
    public String frequencySort(String s) {
        if (s.length() == 0) {
            return s;
        }
        String [] sArray = s.split("");
        Map <String, String> charRepeatedString = new HashMap<String, String> ();
        HashMap <Integer, List<String>> charsByCount = new HashMap <Integer, List<String>> ();
        for (String c : sArray) {
            String temp = c;
            if (charRepeatedString.containsKey(c)) {
                temp = temp.concat(charRepeatedString.get(c));
                charRepeatedString.put(c, temp);

            } else {
                charRepeatedString.put(c, temp);
            }
            Integer count = temp.length();
            List<String> countChars = new ArrayList<String> ();
            if (charsByCount.containsKey(count)) {
                countChars = charsByCount.get(count);
            }
            countChars.add(c);
            charsByCount.put(count, countChars);
        }
        String result = "";
        Set<Integer> keys = charsByCount.keySet();
        Integer [] counts = keys.toArray(new Integer[keys.size()]);
        Arrays.sort(counts, Collections.reverseOrder());

        for (Integer co : counts) {
            List<String> charList = charsByCount.get(co);
            for (String ch : charList)  {
                if (charRepeatedString.containsKey(ch)) {
                    result = result.concat(charRepeatedString.get(ch));
                    charRepeatedString.remove(ch);
                }
            }
        }
        return result;
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> countMap = new HashMap<String, Integer> ();
        for (String word: words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }
        List<String> uniqueWords = new ArrayList(countMap.keySet());
        List<String> result = new ArrayList<String> ();
        uniqueWords.sort((w1, w2) -> {
            if (countMap.get(w1) == countMap.get(w2)) {
                return w1.compareTo(w2);
            } else {
                return countMap.get(w2) - countMap.get(w1);
            }
        });
        return uniqueWords.subList(0, k);
    }
}
