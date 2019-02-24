public class Solution {
    /**
     * @param stringIn: The original string.
     * @param K: The length of substrings.
     * @return: return the count of substring of length K and exactly K distinct characters.
     */
    public int KSubstring(String stringIn, int K) {
        if (stringIn == null || stringIn.length() == 0) {
            return -1;
        }
        int j = 0;
        int n = stringIn.length();
        HashSet<String> set = new HashSet<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(stringIn.charAt(i))) {
                j = Math.max(j, map.get(stringIn.charAt(i)) + 1);
            }
            map.put(stringIn.charAt(i), i);
            if (i - j + 1 >= K) {
                set.add(stringIn.substring(j, i + 1));
            }
        }
        return set.size();
    }
} 
