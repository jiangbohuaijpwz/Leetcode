import java.io.*;
import java.util.*;

class Solution {
  public static class Trie {
    private class TrieNode {
        Map<Character, TrieNode> children;
        boolean endOfWord;
        public TrieNode() {
            children = new HashMap<>();
            endOfWord = false;
        }
    }
    private final TrieNode root;
    public Trie() {
      root = new TrieNode();
    }
    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null) {
                node = new TrieNode();
                current.children.put(ch, node);
            }
            current = node;
        }
        //mark the current nodes endOfWord as true
        current.endOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            //if node does not exist for given char then return false
            if (node == null) {
                return false;
            }
            current = node;
        }
        //return true of current's endOfWord is true else return false.
        return current.endOfWord;
    }
  }
  
  private static void printDuplicateRows(int[][] input) {
    if (input == null || input.length == 0 || input[0] == null) {
      return;
    }
    Trie t = new Trie();
    for (int i = 0; i < input.length; i++) {
      String str = getStr(input[i]);
      if (!t.search(str)) {
        t.insert(str);
      } else {
        System.out.println("There is a duplicate row at position" + i);
      }
    }
  }
  
  private static String getStr(int[] input) {
    String res = "";
    for (int num : input) {
      res += String.valueOf(num);
    }
    return res;
  }
  
  public static void main(String[] args) {
    int[][] input = new int[][]{{1,1,0,1,0,1},{0,0,1,0,0,1},{1,0,1,1,0,0},        {1,1,0,1,0,1},{0,0,1,0,0,1},{0,0,1,0,0,1}};
    printDuplicateRows(input);
  }
}
