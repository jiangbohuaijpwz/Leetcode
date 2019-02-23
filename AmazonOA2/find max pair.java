import java.io.*;
import java.util.*;

// [[1,3000],[2,5000],[3,7000],[4,10000]]
// [[1,2000],[2,3000],[3,4000],[4,5000]]

// question : the output resArr is an address
public class Solution {
    public static int[][] findMaxPair(int[][] forwardShip, int[][] returnShip, int maxDistance) {
        int m = forwardShip.length;
        int n = returnShip.length;
        Arrays.sort(forwardShip, new Comparator<int[]>(){
          public int compare(int[] a, int[] b) {
            return Integer.compare(a[1], b[1]);
          }
        });
      
        Arrays.sort(returnShip, new Comparator<int[]>(){
          public int compare(int[] a, int[] b) {
            return Integer.compare(a[1], b[1]);
          }  
        });
      
        List<int[]> res = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
              int go = forwardShip[i][1];
              int back = returnShip[j][1];
              if (go + back <= maxDistance) {
                if (go + back >= max) {
                    max = go + back;
                    res.add(0, new int[]{forwardShip[i][0], returnShip[j][0], max});
                }
              }
            }
        }
      
      int size = 1;
      for (int i = 0; i < res.size() - 1; i++) {
        if (res.get(i)[2] == res.get(i + 1)[2]) {
          size++;
        }
      }
      int[][] resArr = new int[size][2];
      for (int i = 0; i < size; i++) {
        resArr[i] = new int[]{res.get(i)[0],res.get(i)[1]};
      }
      System.out.println(resArr[0][0]);
      System.out.println(resArr[0][1]);
      System.out.println(resArr[1][0]);
      System.out.println(resArr[1][1]);
      return resArr;
    }
  
    public static void main(String[] args) {
        int[][] forwardShip = new int[][]{{1,3000}, {2,5000}, {3,7000}, {4,10000}};
        int[][] returnShip = new int[][]{{1,2000},{2,3000},{3,4000}, {4,5000}};
        System.out.println(findMaxPair(forwardShip, returnShip,10000));
    }
}