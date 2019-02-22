// leetcode 5
import java.io.*;
import java.util.*;
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int n = s.length();
        String res = s.substring(0, 1);
        boolean[][] isPalindrome = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
            if (isPalindrome[i][i + 1]) {
                res = s.substring(i, i + 2);  // 注意这里要改变res，否则cbbd不会过；
            }
        }
        for (int len = 3; len <= n; len++) {
            for (int start = 0; start + len <= n; start++) {
                isPalindrome[start][start + len - 1] = ((s.charAt(start) == s.charAt(start + len - 1)) &&                     isPalindrome[start + 1][start + len - 2]);
                if (isPalindrome[start][start + len - 1]) {
                    res = s.substring(start, start + len);
                }
            }
        }
        return res;
    }
}