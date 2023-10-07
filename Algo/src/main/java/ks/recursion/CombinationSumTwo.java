package ks.recursion;

import java.util.*;

public class CombinationSumTwo {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2};
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();
        List<List<Integer>> answer = new ArrayList<>();
        combinationOptimization(nums, 0, 4, answer, new ArrayList<>());
        System.out.println(answer);
    }

    private static void combination(int[] nums, int index, int target, Set<List<Integer>> ans, List<Integer> result) {
        if (index == nums.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(result));
            }
            return;
        }
        if (nums[index] <= target) {
            result.add(nums[index]);
            combination(nums, index + 1, target - nums[index], ans, result);
            result.remove(result.size() - 1);
        }
        combination(nums, index + 1, target, ans, result);
    }

    private static void combinationOptimization(int[] nums, int index, int target, List<List<Integer>> ans, List<Integer> result) {
        if (target == 0) {
            ans.add(new ArrayList<>(result));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[index] > target){
                break;
            }
            result.add(nums[i]);
            combinationOptimization(nums,i+1,target-nums[i],ans,result);
            result.remove(result.size()-1);
        }
    }
}
