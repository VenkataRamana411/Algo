package ks.recursion;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        //reverse(nums,0, nums.length-1);
        //reverse(nums, 0);
        //System.out.println(Arrays.toString(nums));
        //System.out.println(checkPalindrome("madam",0));
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }

    private static void reverse(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        reverse(nums, start + 1, end - 1);
    }

    private static void reverse(int[] nums, int index) {
        if (index >= nums.length / 2) {
            return;
        }
        int temp = nums[index];
        nums[index] = nums[nums.length - index - 1];
        nums[nums.length - index - 1] = temp;
        reverse(nums, index + 1);
    }

    private static boolean checkPalindrome(String value, int index) {
        if (index >= value.length() / 2) {
            return true;
        }
        if (value.charAt(index) != value.charAt(value.length() - index - 1)) {
            return false;
        }
        return checkPalindrome(value, index + 1);
    }

    public static String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder result = new StringBuilder();
        for(String str : arr){
            result.append(reverse(str, str.length() - 1, "")).append(" ");
            result.append(" ");
        }
        return result.toString();
    }
    private static String reverse(String str,int index,String result){
        if(index == 0){
            return result;
        }
        result = result + str.charAt(index);
        return reverse(str,index-1,result);
    }
}
