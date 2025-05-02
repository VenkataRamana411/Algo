package target;

import java.util.Arrays;

public class TriangleNumbers {
    public static void main(String[] args) {
        int[] nums = {4,6,9,11,15,18};

        System.out.println(helper(nums));
    }

    /**
     * Combination of numbers in which A+B > C is called triangle triplet
     * TC: O(Nlog(N) * O(N^2))
     * SC:O(1)
    * */
    private static int helper(int[] nums){
        int result = 0, n = nums.length;
        Arrays.sort(nums);
        for (int i = n-1; i >= 0; i--){
            int left = 0;
            int right = i-1;
            while (left < right){
                //right-left ==> Should be added as input is sorted
                if (nums[left] + nums[right] > nums[i]){
                    result += right-left;
                    right--;
                }else {
                    left++;
                }
            }
        }
        return result;
    }
}
