//  O(n^2) ,  n subproblem, each of them needs O(n) time to solve
class Solution {
    HashMap<String, Boolean> map = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false;
        }
        return dfs(s, wordDict, 0);
    }
    private boolean dfs(String s, List<String> wordDict, int startIndex) {
        if (startIndex == s.length()) {
            return true;
        }
        if (map.containsKey(s.substring(startIndex))) {
            return map.get(s.substring(startIndex));
        }
        for (int i = startIndex; i < s.length(); i++) {
            String cur = s.substring(startIndex, i + 1);
            if (wordDict.contains(cur) && dfs(s, wordDict, i + 1)) {
                // map.put(s.substring(startIndex), true);
                return true;
            }
        }
        map.put(s.substring(startIndex), false);
        return false;
    }
}