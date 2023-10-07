package ks.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubSetSum {
    public static void main(String[] args) {
        int[] nums = new int[]{3,1,2};
        List<Integer> result = new ArrayList<>();
        helper(nums,0,new ArrayList<>(),result,0);
        Collections.sort(result);
        System.out.println(result);
    }
    /**
    * TC: 2^n (Recursion) * 2^n log (2^n) (To sort 2^n elements)
     * SC: 2^n (Total combinations)
    * */
    private static void helper(int[] nums, int index, List<Integer> integerList, List<Integer> result, int subSum){
        if (index == nums.length){
            result.add(subSum);
            return;
        }
        integerList.add(nums[index]);
        subSum += nums[index];
        helper(nums,index+1,integerList,result,subSum);
        subSum -= nums[index];
        integerList.remove(integerList.size()-1);
        helper(nums,index+1,integerList,result,subSum);
    }
}
