package ks.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubSequences {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 2};
        //printSubsequence(nums, 0, new ArrayList<>(), nums.length);
       // printAllSubSequenceWithSum(new int[]{1,2,1},0,new ArrayList<>(),3);
        //printSubSequenceWithSum(new int[]{1,2,1},0,new ArrayList<>(),3);
        System.out.println(countSubSequences(new int[]{1,2,1},0,0,2));
    }

    private static void printSubsequence(int[] nums, int index, List<Integer> result, int n) {
        if (index == n) {
            System.out.println(result);
            return;
        }
        result.add(nums[index]);
        printSubsequence(nums, index + 1, result, n);
        result.remove(result.size() - 1);
        printSubsequence(nums, index + 1, result, n);
    }

    private static void printAllSubSequenceWithSum(int[] nums, int index, List<Integer> result, int target) {
        if (target <= 0 || index == nums.length) {
            if (target == 0) {
                System.out.println(result);
            }
            return;
        }
        result.add(nums[index]);
        target = target - nums[index];
        printAllSubSequenceWithSum(nums, index + 1, result, target);
        result.remove(result.size() - 1);
        target = target + nums[index];
        printAllSubSequenceWithSum(nums, index + 1, result, target);
    }
    private static boolean printSubSequenceWithSum(int[] nums, int index, List<Integer> result, int target) {
        if (target <= 0 || index == nums.length) {
            if (target == 0) {
                System.out.println(result);
                return true;
            }
            return false;
        }
        result.add(nums[index]);
        target = target - nums[index];
        if (printSubSequenceWithSum(nums, index + 1, result, target)){
            return true;
        }
        result.remove(result.size() - 1);
        target = target + nums[index];
        return printSubSequenceWithSum(nums, index + 1, result, target);
    }
    private static int countSubSequences(int[] nums,int index,int result,int target){
        if (target <= 0 || index == nums.length){
            if (target == 0){
                return 1;
            }
            return 0;
        }
        target = target - nums[index];
        int left = countSubSequences(nums,index+1,result,target);
        target = target + nums[index];
        int right = countSubSequences(nums,index+1,result,target);
        return left + right;
    }
}
