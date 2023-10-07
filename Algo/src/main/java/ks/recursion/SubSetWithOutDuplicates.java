package ks.recursion;

import java.util.*;

public class SubSetWithOutDuplicates {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2};
     /*   Set<List<Integer>> resultSet = new HashSet<>();
        helper(nums,0,new ArrayList<>(),resultSet);
        System.out.println(resultSet);*/
        Arrays.sort(nums);
        helperOptimized(nums,0,new ArrayList<>());
    }
    private static void helper(int[] nums, int index, List<Integer> result,Set<List<Integer>> resultSet){
        if (index == nums.length){
            resultSet.add(new ArrayList<>(result));
            return;
        }
        result.add(nums[index]);
        helper(nums,index+1,result,resultSet);
        result.remove(result.size()-1);
        helper(nums,index+1,result,resultSet);
    }
    private static void helperOptimized(int[] nums, int index, List<Integer> result){
        System.out.println(result);
        for (int i = index ; i < nums.length; i++){
            if (i != index && nums[i] == nums[i-1]){
                continue;
            }
            result.add(nums[i]);
            helperOptimized(nums,i+1,result);
            result.remove(result.size()-1);
        }
    }

}
