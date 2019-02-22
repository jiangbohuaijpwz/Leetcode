// leetcode 819
import java.io.*;
import java.util.*;
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        if (paragraph == null || paragraph.length() == 0) {
            return null;
        }
        List<String> list = Arrays.asList(banned);
        String[] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split("\\s+");
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (!list.contains(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }  
        }
        String res = "";
        int max = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            if (value > max) {
                res = key;
                max = value;
            }
        }
        return res;
    }
}