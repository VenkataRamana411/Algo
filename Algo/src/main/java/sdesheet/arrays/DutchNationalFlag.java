package sdesheet.arrays;

import java.util.Arrays;

public class DutchNationalFlag {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0};
        helper(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void helper(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        while (mid <= high){
            if (nums[mid] == 0){
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            }else {
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            }
        }
    }
}
