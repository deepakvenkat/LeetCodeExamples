package com.company;
import java.util.*;
public class Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map <String, List<String>> anagramMap = new HashMap<String, List<String>>();

        for (String s : strs) {
            char [] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedS = String.copyValueOf(chars);
            List <String> valueList = new ArrayList<String> ();
            if(anagramMap.containsKey(sortedS)) {
                valueList = anagramMap.get(sortedS);
            }
            valueList.add(s);
            anagramMap.put(sortedS, valueList);
        }
        List<List<String>> result = new ArrayList<List<String>>(anagramMap.values());
        return result;

    }
}
