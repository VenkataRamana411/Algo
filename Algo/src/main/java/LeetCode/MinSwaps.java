package LeetCode;

import java.util.Arrays;

public class MinSwaps {
    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 0, 1};
        // System.out.println(minSwaps(nums));
        System.out.println(minSwaps(new int[]{0, 1, 1, 1, 0, 0, 1, 1, 0}));
    }

    public static int minSwaps(int[] nums) {
        int swapCount = Integer.MAX_VALUE, countOne = 0;
        int[] temp = new int[nums.length * 2];
        int j = 0, k = nums.length;
        for (int num : nums) {
            if (num == 1) {
                countOne++;
            }
            temp[j++] = num;
            temp[k++] = num;
        }
        int currentOnes = 0;
        for (int start = 0, end = 0; end < temp.length; ) {
            if (end - start == countOne) {
                if (temp[start++] == 1) {
                    currentOnes--;
                }
                if (temp[end++] == 1) {
                    currentOnes++;
                }
                swapCount = Math.min(countOne - currentOnes, swapCount);
                if (swapCount == 0) {
                    return 0;
                }
            } else {
                if (temp[end++] == 1) {
                    currentOnes++;
                }
            }
        }
        return swapCount;
    }
}
