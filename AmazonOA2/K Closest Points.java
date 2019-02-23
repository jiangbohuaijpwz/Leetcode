/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class Solution {
    /**
     * @param points: a list of points
     * @param origin: a point
     * @param k: An integer
     * @return: the k closest points
     */
    public Point[] kClosest(Point[] points, Point origin, int k) {
        Point[] result = new Point[k];
        PriorityQueue<Point> pq = new PriorityQueue<Point>(k, new Comparator<Point>(){
            @Override
            public int compare(Point b, Point a) {
                int diff = distanceCompare(a, b, origin);
                if (distanceCompare(a, b, origin) != 0) {
                    return distanceCompare(a, b, origin);
                } else if (a.x - b.x != 0) {
                    return a.x - b.x;
                } else {
                  return a.y - b.y;  
                }
            }
        });
        for (int i = 0; i < points.length; i++) {
            pq.add(points[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            result[i] = pq.poll();
        }
        return result;
    }
    
    private int distanceCompare(Point a, Point b, Point origin) {
        return ((a.x - origin.x) * (a.x - origin.x) + (a.y - origin.y) * (a.y - origin.y)) - ((b.x - origin.x) * (b.x - origin.x) + (b.y - origin.y) * (b.y - origin.y));
    }
}