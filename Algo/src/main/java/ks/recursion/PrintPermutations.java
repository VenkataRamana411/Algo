package ks.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintPermutations {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> ans = new ArrayList<>();
        /*int[] freq = new int[nums.length];
        print(nums, new ArrayList<>(), freq, ans);
        System.out.println(ans);*/
        printOptimization(nums, 0, ans);
        System.out.println(ans);
    }

    /**
     * TC: n! * n ==> n! (combinations) & n (for loop)
     * SC: O(n)
     */

    private static void print(int[] nums, List<Integer> result, int[] freq, List<List<Integer>> ans) {
        if (result.size() == nums.length) {
            ans.add(new ArrayList<>(result));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (freq[i] == 1) {
                continue;
            }
            result.add(nums[i]);
            freq[i] = 1;
            print(nums, result, freq, ans);
            result.remove(result.size() - 1);
            freq[i] = 0;
        }
    }

    /**
     * TC: n! * n ==> n! (combinations) & n (for loop)
     * SC:
     */
    private static void printOptimization(int[] nums, int index, List<List<Integer>> ans) {
        if (index == nums.length) {
            System.out.println(Arrays.toString(nums));
            List<Integer> result = new ArrayList<>();
            for (int i : nums) {
                result.add(i);
            }
            ans.add(result);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swapHelper(nums, index, i);
            printOptimization(nums, index + 1, ans);
            swapHelper(nums,index,i);
        }
    }

    private static void swapHelper(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
