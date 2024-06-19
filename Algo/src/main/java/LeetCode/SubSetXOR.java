package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class SubSetXOR {
    public static void main(String[] args) {
        int[] nums = {1,3};
        int result = 0;
        List<Integer> resultList = new ArrayList<>();
        backTracker(nums,0,resultList,result);
        System.out.println(result);
        System.out.println(backTrackerHelper(new int[]{5,1,6},0,0));
    }

    private static void backTracker(int[] nums, int index, List<Integer> resultList,int result){
        if(index == nums.length){
            resultList.add(result);
            return;
        }
        result ^= nums[index];
        backTracker(nums,index+1,resultList,result);
        result ^= nums[index];
        backTracker(nums,index+1,resultList,result);
    }

    private static int backTrackerHelper(int[] nums, int index,int result){
        if(index == nums.length){
            return result;
        }
        result ^= nums[index];
        int pick = backTrackerHelper(nums,index+1,result);
        result ^= nums[index];
        int noPick = backTrackerHelper(nums,index+1,result);
        return pick + noPick;
    }
}
