package LeetCode;

public class ProductDifference {
    public static void main(String[] args) {
        System.out.println(maxProductDifference(new int[]{1, 6, 7, 5, 2, 4, 10, 6, 4}));
    }

    public static int maxProductDifference(int[] nums) {
        int max1, max2, min1, min2;
        if (nums[0] > nums[1]) {
            max1 = nums[0];
            max2 = nums[1];
            min2 = nums[0];
            min1 = nums[1];
        } else {
            max2 = nums[0];
            max1 = nums[1];
            min1 = nums[0];
            min2 = nums[1];
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= max2) {
                if (nums[i] >= max1) {
                    max2 = max1;
                    max1 = nums[i];
                } else {
                    max2 = nums[i];
                }
            }
            if (nums[i] <= min2) {
                if (nums[i] <= min1) {
                    min2 = min1;
                    min1 = nums[i];
                } else {
                    min2 = nums[i];
                }
            }
        }
        return (max1 * max2) - (min1 * min2);
    }
}
