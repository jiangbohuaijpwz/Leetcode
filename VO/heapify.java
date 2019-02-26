public class Solution {
    /*
     * @param A: Given an integer array
     * @return: nothing
     */
    // siftup.  O(nlgn)
    public void heapify(int[] A) {
        for (int i = 1; i < A.length; i++) {
            siftup(A, i);
        }    
    }
    private void siftup(int[] A, int k) {
        int father = (k - 1) / 2;
        while (father >= 0 && A[father] > A[k]) {
            swap(father, k, A);
            k = father;
            father = (k - 1) / 2;
        } 
    }
    
    
    private void swap(int i, int j, int[] A) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    
    // siftdown.  O(n) 因为从倒数第二层开始siftdown，
    // 倒数第二层的节点大约有 n/4 个， 这 n/4 个数，最多 siftdown 1次就到底了，O(n/4)
    // T(n) = O(n/4) + O(n/8 * 2) + O(n/16 * 3) ...
    public void heapify(int[] A) {
        for (int i = A.length / 2; i>= 0; i--) {
            siftdown(A, i);
        }
    }
    
    private void siftdown(int[] A, int k) {
        while (k * 2 + 1 < A.length || k * 2 + 2 < A.length) {
            int min = k;
            if (k * 2 + 1 < A.length && A[k * 2 + 1] <= A[min]) {
                min = k * 2 + 1;
            }
            if (k * 2 + 2 < A.length && A[k * 2 + 2] <= A[min]) {
                min = k * 2 + 2;
            }
            if (min == k) {
                break;
            }
            int temp = A[k];
            A[k] = A[min];
            A[min] = temp;
            k = min;
        }
    }
}

