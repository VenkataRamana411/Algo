package target;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-1};
        System.out.println(helper(nums));
    }

    /**
     * TC: O(Nlog(N) + O(N^2))
     * SC: O(N^2) - Worst case to store all triple combinations???
    * */
    private static List<List<Integer>> helper(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length, left = 0,right = 0;
        Arrays.sort(nums);
        /**
         * Sort the elements and then take one element at a time then problem will be converted to 2 pointer approach
         * Now we just need to find a combination of elements that will add up to 0 when combining with first element
         * To ensure no duplicates, we are skipping values at initial stage as well as post finding required triplet
        * */
        for (int i = 0; i < n; i++){
            //[3,3,....] ==> No need to compute for 2nd occurrence of 3
            if(i != 0 && nums[i] == nums[i-1]){
                continue;
            }
            left = i+1;
            right = n -1;
            while (left < right){
                int curr = Math.abs(nums[i]) - Math.abs(nums[left] + nums[right]);
                if (curr == 0){
                    result.add(List.of(nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                    //[3,3,3,...] ==> No need to compute for 2nd occurrence of 3
                    while (left < right && nums[left] == nums[left-1]){
                        left++;
                    }
                    //[...,5,5,5] ==> No need to compute for 2nd occurrence of 5
                    while (left < right && nums[right] == nums[right+1]){
                        right--;
                    }
                } else if (curr < 0) {
                    left++;
                }else {
                    right--;
                }
            }
        }
        return result;
    }
}
