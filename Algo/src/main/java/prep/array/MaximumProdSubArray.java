package prep.array;

import java.util.Arrays;

public class MaximumProdSubArray {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 4, -4, 5, -2, -1, -1, -2, -3};
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        int[] prefixProd = new int[nums.length];
        int[] suffixProd = new int[nums.length];
        int maxPrefix = 0, maxSuffix = 0, currPrefix = 1, currSuffix = 1;
        for (int i = 0, j = nums.length - 1; i < nums.length; i++, j--) {
            if (nums[i] == 0) {
                currPrefix = 1;
            } else {
                currPrefix *= nums[i];
            }
            prefixProd[i] = currPrefix;
            if (currPrefix > maxPrefix) {
                maxPrefix = currPrefix;
            }
            if (nums[j] == 0) {
                currSuffix = 1;
            } else {
                currSuffix *= nums[j];
            }
            if (currSuffix > maxSuffix) {
                maxSuffix = currSuffix;
            }
            suffixProd[j] = currSuffix;
        }
        System.out.println(Arrays.toString(prefixProd));
        System.out.println(Arrays.toString(suffixProd));
        return Math.max(maxPrefix, maxSuffix);
    }

    public static int maxProduct1(int[] nums) {
        int maxPrefix = Integer.MIN_VALUE, maxSuffix = Integer.MIN_VALUE, currPrefix = 1, currSuffix = 1;
        for (int i = 0, j = nums.length - 1; i < nums.length; i++, j--) {
            maxPrefix = Math.max(currPrefix *= nums[i],maxPrefix);
            if (nums[i] == 0) {
                currPrefix = 1;
            }
            maxSuffix = Math.max(currSuffix *= nums[j],maxSuffix);
            if (nums[j] == 0) {
                currSuffix = 1;
            }
        }
        return Math.max(maxPrefix, maxSuffix);
    }
}
