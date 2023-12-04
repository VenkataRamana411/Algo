package LeetCode;

import java.util.Arrays;

public class MinimizeMaximumPair {
    public static void main(String[] args) {
        System.out.println(helper(new int[]{3, 5, 4, 2, 4, 6}));
    }

    private static int helper(int[] nums) {
        int result = Integer.MIN_VALUE;
        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            if (nums[i] + nums[j] > result) {
                result = nums[i] + nums[j];
            }
        }
        return result;
    }
}
