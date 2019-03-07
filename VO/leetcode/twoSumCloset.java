package leetcode;

import java.util.Arrays;

public class twoSumCloset {

    public static int twoSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        int res = Math.abs(nums[0] + nums[end] - target);
        while (start < end) {
            int sum = nums[start] + nums[end];
            // System.out.println(sum);
            if (Math.abs(sum - target) <= Math.abs(res)) {
                res = Math.abs(sum - target);
            }
            if (sum < target) {
                start++;
            } else {
                end--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,2,1,-4};
        System.out.println(twoSumClosest(nums, 4));
    }
}
