package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class NonRepeatingC {
    public static void findFirstNonRepeating(String stream) {
        ArrayList<Character> list = new ArrayList<>();
        int[] count = new int[26];
        for (int i = 0; i < stream.length(); i++) {
            char ch = stream.charAt(i);
            if (count[ch - 'a'] == 0) {
                count[ch - 'a']++;
                list.add(ch);
            } else {
                list.remove(new Character(ch));
            }
            System.out.println("first non-repeating character so far is " + list.get(0));
        }
    }



    public static void main(String[] args) {
        String stream = "geeksforgeeksandgeeksquizfor";
        findFirstNonRepeating(stream);
    }
}
