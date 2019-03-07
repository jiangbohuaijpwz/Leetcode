package leetcode;

import java.util.PriorityQueue;

public class inputStream {
    public static void main(String[] args) {
        add(4,3);
        add(2,3);
        add(8,3);
        add(3,3);
        add(9,3);
    }
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void add(int n, int K){
        pq.add(n);
        if (pq.size() < K) {
            System.out.println("no output");
        } else if (pq.size() == K) {
            System.out.println(pq.peek());
        } else {
            pq.poll();
            System.out.println(pq.poll());
        }
    }
}
