package LeetCode;

import java.util.Arrays;
import java.util.HashSet;

public class SetMisMatch {
    public static void main(String[] args) {
        findErrorNums2(new int[]{1,2,2,4});
    }
    public static int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        int temp = nums[0] , j = 1;
        for (int i = 1 ; i < nums.length ; i++){
            temp = temp ^ nums[i] ^ j++;
        }
        System.out.println(temp);
        return result;
    }
    public static int[] findErrorNums2(int[] nums) {
        int[] result = new int[2];
        HashSet<Integer> hset = new HashSet<>();
        for(int n : nums){
            if(hset.contains(n)){
                result[0] = n;
            }
            hset.add(n);
        }
        for(int i = 1 ; i <= nums.length ; i++){
            if(!hset.contains(i)){
                result[1] = i;
            }
        }
        return result;
    }
}
