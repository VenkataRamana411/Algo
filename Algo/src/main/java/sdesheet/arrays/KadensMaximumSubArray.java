package sdesheet.arrays;

public class KadensMaximumSubArray {
    public static void main(String[] args) {
        System.out.println(helper(new int[]{-2, -3, 4, -1, -2, 1, 5, -3}));
    }

    private static int helper(int[] nums) {
        int maximum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (maximum < sum) {
                maximum = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return maximum;
    }
}
