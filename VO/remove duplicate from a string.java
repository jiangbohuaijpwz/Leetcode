package leetcode;

import java.util.HashSet;

public class removeDupFromAString {
    public static void main(String[] args) {
        String s = "geeksforgeeks";
        System.out.println(unique(s));
    }
//    public static String unique(String s) {
//        if (s == null) {
//            return null;
//        }
//        String res = "";
//        HashSet<Character> set = new HashSet<>();
//        for (Character ch : s.toCharArray()) {
//            if (set.add(ch)) {
//                res += ch;
//            }
//        }
//        return res;
//    }

//    method 2 : very good version from geeksforgeeks;
    public static String unique(String s) {
        String res = "";
        for (char ch : s.toCharArray()) {
            if (res.indexOf(ch) < 0) {
                res += ch;
            }
        }
        return res;
    }
}