package ks.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 6, 7};
        List<List<Integer>> ans = new ArrayList<>();
        //combination(nums, 0, 7, ans, new ArrayList<>());
        int[] nums2 = new int[]{10,1,2,7,6,1,5};
        Arrays.sort(nums2);
        combinationWithOutRepetition(nums2, 0, 8, ans, new ArrayList<>());
        System.out.println(ans);
    }

    private static void combination(int[] nums, int index, int target, List<List<Integer>> ans, List<Integer> result) {
        if (index == nums.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(result));
            }
            return;
        }
        if (nums[index] <= target) {
            result.add(nums[index]);
            combination(nums, index, target - nums[index],ans, result);
            result.remove(result.size() - 1);
        }
        combination(nums, index + 1, target, ans, result);
    }
    private static void combinationWithOutRepetition(int[] nums, int index, int target, List<List<Integer>> ans, List<Integer> result) {
        if (index == nums.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(result));
            }
            return;
        }
        if (nums[index] <= target) {
            result.add(nums[index]);
            combinationWithOutRepetition(nums, index+1, target - nums[index],ans, result);
            result.remove(result.size() - 1);
        }
        combinationWithOutRepetition(nums, index + 1, target, ans, result);
    }
}
