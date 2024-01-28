package prep.array;

import java.util.ArrayList;
import java.util.List;

public class MaxOne2 {
    public static void main(String[] args) {
        //System.out.println(findMaxConsecutiveOnes(new int[]{1,0,1,0,1}));
        System.out.println(longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,},2));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int result = 0 , count = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                list.add(count);
                count = 0;
            }
        }
        if (list.size() == 1){
            return list.get(0)+1;
        }
        for (int i = 0 ; i < list.size()-1;i++){
            result = Math.max(result,list.get(i) + list.get(i + 1) + 1);
        }
        return result;
    }

    // [1,1,1,0,0,0,1,1,1,1,0]
    public static int longestOnes(int[] nums, int k) {
        int result = 0;
        int i = 0 , j = 0 , zeroCount = 0;
        while (i <= j && j < nums.length){
            if (nums[j] == 0){
                zeroCount++;
            }
            if (zeroCount > k){
                result = Math.max(result,j-i);
                if (nums[i] == 0){
                    zeroCount--;
                }
                i++;
            }
            j++;
        }
        return Math.max(result,j-i);
    }
    public static int longestOnesOptimal(int[] nums, int k) {
        int i = 0 , j;
        for (j = 0 ; j < nums.length ; j++){
            if (nums[j] == 0){
                k--;
            }
            if (k < 0 && nums[i++] == 0){
                k++;
            }
        }
        return j - i;
    }
}
