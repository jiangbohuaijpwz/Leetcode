import java.io.*;
import java.util.*;

// https://www.jianshu.com/p/d489b3fcf11a
public class Solution {
    public static int find(int[][] input)
    {   
      if (input == null || input.length == 0 || input[0] == null) {
        return -1;
      }
      int m = input.length, n = input[0].length;
      for(int i = 0; i < m; i++) {
        for(int j = 0; j < n; j++) {
          int fromTop = Integer.MIN_VALUE;
          int fromLeft = Integer.MIN_VALUE;
          if (i == 0 && j == 0) {
            continue;
          }
          if (i - 1 >= 0) {
            fromTop = Math.min(input[i - 1][j], input[i][j]);
          }
          if (j - 1 >= 0) {
            fromLeft = Math.min(input[i][j - 1], input[i][j]);
          }
          input[i][j] = Math.max(fromTop, fromLeft);
        }
             
      }
      return input[m - 1][n - 1];
        
    }
  
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] input = {{8,4,7}, {6,5,9}};
        System.out.println(find(input));
    }
 
}