// lintcode 386
public class Solution {
    /**
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] nums = new int[128]; 
        int left = 0, right = 0;
        int len = 0;
        int count = k;
        for ( ;right < s.length(); right++) {
            if (nums[s.charAt(right)]++ == 0) {
                count--;
            }
            while (count < 0) {  // this should not be count == 0, but count < 0!!!
                if (--nums[s.charAt(left++)] == 0) {
                    count++;
                }
            }
            len = Math.max(len, right - left + 1);
        }
        return len;
    }
}