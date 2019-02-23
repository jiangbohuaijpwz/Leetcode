import java.io.*;
import java.util.*;

// https://www.jianshu.com/p/d489b3fcf11a
public class Solution {
    static int[] dx = new int[]{1,-1,0,0};
    static int[] dy = new int[]{0,0,1,-1};
    public static int  removeObstacle(int numRows, int numColumns, int[][] lot) {
        if (lot == null || lot.length == 0 || lot[0] == null) {
          return -1;
        }
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0,0,1));
        int res = 0;
        while (!q.isEmpty()) {
          res++;
          int size = q.size();
          for (int k = 0; k < size; k++) {
            Point head = q.poll();
            int xValue = head.x;
            int yValue = head.y;
            for (int i = 0; i < 4; i++) {
              int dirX = xValue + dx[i];
              int dirY = yValue + dy[i];
              if (dirX < 0 || dirX >= numRows || dirY < 0 || dirY >= numColumns || lot[dirX][dirY] == 0) {
                continue;
              }
              if (lot[dirX][dirY] == 9) {
                return res;
              }
              q.add(new Point(dirX, dirY, lot[dirX][dirY]));
              lot[dirX][dirY] = 0;
            }
          }
          
      }
      return -1;
    }
    
    static class Point{
      int x;
      int y;
      int value;
      public Point(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
      }
    }
  
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,1,1,1},{0,1,1,1},{0,1,0,1},{1,1,9,1},{0,0,1,1}};
        // System.out.println(removeObstacle(5,4,grid));
      System.out.println(removeObstacle(3,3,new int[][]{{1,0,0},{1,0,0},{1,9,1}}));
    }
 
}