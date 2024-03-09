package prep.sorting;

import java.util.Arrays;

public class SortColours {
    /**
     * 75. Sort Colors
     * Solved
     * Medium
     * Topics
     * Companies
     * Hint
     * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
     * <p>
     * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
     * <p>
     * You must solve this problem without using the library's sort function.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [2,0,2,1,1,0]
     * Output: [0,0,1,1,2,2]
     * Example 2:
     * <p>
     * Input: nums = [2,0,1]
     * Output: [0,1,2]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * n == nums.length
     * 1 <= n <= 300
     * nums[i] is either 0, 1, or 2.
     * <p>
     * <p>
     * Follow up: Could you come up with a one-pass algorithm using only constant extra space?
     * <p>
     * <p>
     * Seen this question in a real interview before?
     * 1/4
     * Yes
     * No
     * Accepted
     * 1.8M
     * Submissions
     * 2.9M
     * Acceptance Rate
     * 61.7%
     */
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors2(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        int left = 0;
        int mid = 0;
        int right = nums.length-1;
        while (mid <= right){
            if (nums[mid] == 0){
                int temp = nums[left];
                nums[left++] = nums[mid];
                nums[mid++] = temp;
            }else if (nums[mid] == 2){
                int temp = nums[right];
                nums[right--] = nums[mid];
                nums[mid] = temp;
            }else {
                mid++;
            }
        }
    }

    public static void sortColors2(int[] nums) {
        //Move 0's to left and 2's to right then we have 1's in the middle
        int left = 0;
        int i = 0;
        int right = nums.length-1;
        while (i <= right){
            if (nums[i] == 0){
                swap(nums,i,left);
                i++;
                left++;
            }else if (nums[i] == 2){
                swap(nums,i,right);
                right--;
            }else {
                i++;
            }
        }
    }
    private static void swap(int[] nums,int a ,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
