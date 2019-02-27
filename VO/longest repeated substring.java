import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */
 

class Solution {
  public static void main(String[] args) {
    System.out.println(lrs("banana"));
    System.out.println(lrs("GEEKSFORGEEKS"));
    System.out.println(lrs("AAAAAAAAAA"));
    System.out.println(lrs("ABABABA"));
    System.out.println(lrs("ATCGATCGA"));
    System.out.println(lrs("ABCDEFG"));
  }
  
  public static String lrs(String str) {
    if (str == null || str.length() == 0) {
      return null;
    }
    int n = str.length();
    String[] suffix = new String[n];
    for (int i = 0; i < n; i++) {
      suffix[i] = str.substring(i, n);
    }
    Arrays.sort(suffix);
    String res = "";
    for (int i = 0; i < n - 1; i++) {
      String temp = lcs(suffix[i], suffix[i + 1]);
      if (temp.length() >= res.length()) {
        res = temp;
      }
    }
    return res;
  }
  
  public static String lcs(String a, String b) {
    int n = Math.min(a.length(), b.length());
    int i = 0;
    while (i < n) {
      if (a.charAt(i) == b.charAt(i)) {
        i++;
      } else {
        break;
      }
    }
    return a.substring(0, i);
  }
  
}