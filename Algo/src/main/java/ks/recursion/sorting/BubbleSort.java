package ks.recursion.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 6, 9, 2, 4, 8, 74, 7};
        helper(nums, nums.length);
        System.out.println(Arrays.toString(nums));
    }

    private static void helper(int[] nums, int length) {
        if (length == 1) {
            return;
        }
        int count = 0;
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                int temp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = temp;
                ++count;
            }
        }
        if (count == 0) {
            return;
        }
        helper(nums, length - 1);
    }
}
