// lintcode 533
public class Solution {
    /**
     * @param nums: an integer array
     * @param target: An integer
     * @return: the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
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
}