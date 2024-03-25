package LeetCode;

import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result,1);
        int curr = 1;
        for(int i = 0; i < n; i++){
            result[i] *= curr;
            curr *= nums[i];
        }
        curr = 1;
        for(int i = n-1 ; i >= 0; i--){
            result[i] *= curr;
            curr *= nums[i];
        }
        return result;
    }
}
