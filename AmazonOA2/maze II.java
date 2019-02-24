class Solution {
    int[] dx = new int[]{1,-1,0,0};
    int[] dy = new int[]{0,0,1,-1};
    int m = 0, n = 0;
    class Point {
        int x;
        int y;
        int step;
        public Point(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || maze[0] == null) {
            return -1;
        }
        if (maze[start[0]][start[1]] == 1 || maze[destination[0]][destination[1]] == 1) {
            return 0;
        }
        m = maze.length;
        n = maze[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(res[i], -1);
        }
        Queue<Point> q = new LinkedList<Point>();
        q.add(new Point(start[0], start[1], 0));
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Point head = q.poll();
                int x = head.x;
                int y = head.y;
                if (res[x][y] != -1 && head.step >= res[x][y]) {
                    continue;
                }
                res[x][y] = head.step;
                for (int j = 0; j < 4; j++) {
                    int step = head.step;
                    int dirX = x + dx[j];
                    int dirY = y + dy[j];
                    step++;  // 因为根据上面两行，已经走了一步；
                    while (dirX >= 0 && dirX < m && dirY >= 0 && dirY < n && maze[dirX][dirY] == 0) {
                        dirX += dx[j];
                        dirY += dy[j];
                        step++;
                    }
                    step--;
                    dirX -= dx[j];
                    dirY -= dy[j];
                    q.add(new Point(dirX, dirY, step));
                }
            }
        }
        return res[destination[0]][destination[1]];
    }
}
