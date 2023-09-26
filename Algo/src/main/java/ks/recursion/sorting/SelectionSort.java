package ks.recursion.sorting;

import java.util.*;

public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 6, 9, 2, 4, 8, 74, 7};
        recursion(nums, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private static void recursion(int[] nums, int index) {
        if (index == 0) {
            return;
        }
        int temp = 0;
        for (int i = 0; i <= index; i++) {
            if (nums[i] > nums[temp]) {
                temp = i;
            }
        }
        int swap = nums[index];
        nums[index] = nums[temp];
        nums[temp] = swap;
        recursion(nums, index - 1);
    }
}
