package LeetCode;

import java.util.Arrays;

public class SpecialArray {
    public static void main(String[] args) {
        System.out.println(specialArray(new int[]{0,0,4,3,5}));
    }

    public static int specialArray(int[] nums) {
        int N = nums.length;
        int[] freq = new int[N + 1];

        for (int i = 0; i < N; i++) {
            freq[Math.min(N, nums[i])]++;
        }

        int numGreaterThanOrEqual = 0;
        for (int i = N; i >= 1; i--) {
            numGreaterThanOrEqual += freq[i];
            if (i == numGreaterThanOrEqual) {
                return i;
            }
        }

        return -1;
    }
}
