public class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    // public int findPeak(int[] A) {
    //     if (A == null || A.length == 0) {
    //         return 0;
    //     }
    //     int start = 0, end = A.length - 1;
    //     while (start + 1 < end) {
    //         int mid = start + (end - start) / 2;
    //         if (A[mid] > A[mid - 1] && A[mid] < A[mid + 1]) {
    //             start = mid;
    //         } else if (A[mid] > A[mid + 1] && A[mid] < A[mid - 1]) {
    //             end = mid;
    //         } else if (A[mid] > A[mid + 1] && A[mid] > A[mid - 1]) {
    //             return mid;
    //         } 
    //     }
    //     return -1;
    // }
    public int findPeak(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int start = 0, end = A.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > A[mid + 1] && A[mid] > A[mid - 1]) {
                return mid;
            } else if (A[mid] > A[mid + 1]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}