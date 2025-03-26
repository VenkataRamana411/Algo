package LeetCode.lc2025;

public class NiceSubArray {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(4));
        System.out.println(Integer.toBinaryString(48));
        System.out.println(Integer.toBinaryString(30));
        System.out.println(Integer.toBinaryString(10));
        System.out.println(30 & 10);
        int[] nums = {1, 3, 8, 48, 10};
       // System.out.println(longestNiceSubarray(nums));
        System.out.println(longestNiceSubarray(new int[]{3,1,5,11,13}));
    }

    public static int longestNiceSubarray(int[] nums) {
        int result = 1;
        int j = 0, i = 1;
        for (; i < nums.length; i++) {
            if ((nums[j] & nums[i]) != 0) {
                result = Math.max(result, i - j);
                j = i;
            }
        }
        return Math.max(result, i - j);
    }
}
