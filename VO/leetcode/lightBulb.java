package leetcode;

public class lightBulb {
    public static int light(int[] nums) {
        int res = 1;
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int min = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (min > nums[i]) {
                res++;
            }
            min = Math.min(nums[i], min);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,1,3,2,4};
        System.out.println(light(nums));
    }
}
