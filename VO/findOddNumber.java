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
    int[] arr = new int[]{2,3,2,3,4,5,6,5,4};
    System.out.println(findOdd(arr));
  } 
  
  public static int findOdd(int[] arr) {
    int res = arr[0];
    for (int i = 1; i < arr.length; i++) {
      res = res ^ arr[i];
    }
    return res;
  }
}