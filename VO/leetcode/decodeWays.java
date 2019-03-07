package leetcode;

import java.util.HashMap;

public class decodeWays {
    public static int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<String, Integer> map = new HashMap<>();
        int res = 0;
        return dfs(s, 0, map);
    }

    private static int dfs(String s, int startIndex, HashMap<String, Integer> map) {
        if (startIndex == s.length()) {
            return 1;
        }
        if (map.containsKey(s.substring(startIndex))) {
            return map.get(s.substring(startIndex));
        }
        int totalWaysFromHere = 0;
        if (s.charAt(startIndex) == '0')  {
            return totalWaysFromHere;
        }
        totalWaysFromHere += dfs(s, startIndex + 1, map);
        if (startIndex + 2 <= s.length()) {
            String cur = s.substring(startIndex, startIndex + 2);
            if (Integer.valueOf(cur) <= 26 && Integer.valueOf(cur) > 0) {
                totalWaysFromHere += dfs(s, startIndex + 2, map);
            }
        }
        map.put(s.substring(startIndex), totalWaysFromHere);
        return totalWaysFromHere;
    }

    public static void main(String[] args) {
        String input = "2263";
        System.out.println(numDecodings(input));
    }
}
