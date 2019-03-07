package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class wordBreak2 {
    static ArrayList<String> res = new ArrayList<>();

    public static List<String> wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        Map<String, ArrayList<String>> memo = new HashMap<>();
        dfs(s, wordDict, 0, sb, memo);
        return res;
    }

    private static void dfs(String s, List<String> wordDict, int startIndex, StringBuilder sb, Map<String, ArrayList<String>> memo) {
        if (startIndex == s.length()) {
            res.add(sb.toString().trim());
        }
        if (memo.containsKey(s.substring(startIndex)) && memo.get(s.substring(startIndex)).size() == 0) {
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            String cur = s.substring(startIndex, i + 1);
            if (!wordDict.contains(cur)) {
                continue;
            }
            sb.append(cur + " ");
            dfs(s, wordDict, i + 1, sb, memo);
            sb = sb.delete(sb.length() - cur.length() - 1, sb.length()); // remove the last word including the space at the end;
        }
        memo.put(s.substring(startIndex), res);
    }
    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        wordBreak(s, wordDict);
        System.out.println(res);
    }
}

