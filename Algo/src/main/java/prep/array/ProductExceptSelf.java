package prep.array;

import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelfOptimal(nums)));
    }
    public static int[] productExceptSelfOptimal(int[] nums){
        //Adding Prefix and suffix product without current index will give final answer
        int n = nums.length;
        int[] result = new int[n];
        result[0] = 1;
        Arrays.fill(result,0,n,1);
        int curr = 1;
        for(int i = 0 ; i < n; i++){
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
    public int[] productExceptSelf1(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = 1;
        suffix[n-1] = 1;
        for(int i = 1 ; i < n; i++){
            prefix[i] = prefix[i-1] * nums[i-1];
        }
        for(int i = n-2 ; i >= 0 ; i--){
            suffix[i] = suffix[i+1] * nums[i+1];
        }
        for(int i = 0 ; i < n ; i++){
            result[i] = prefix[i] * suffix[i];
        }
        return result;
    }
}
