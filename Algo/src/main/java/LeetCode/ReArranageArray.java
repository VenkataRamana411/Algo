package LeetCode;

import java.util.Arrays;

public class ReArranageArray {
    public static void main(String[] args) {
        int[] nums = {28, -41, 22, -8, -37, 46, 35, -9, 18, -6, 19, -26, -37, -10, -9, 15, 14, 31};
        System.out.println(Arrays.toString(rearrangeArray(nums)));
    }

    public static int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        int pos = 0, neg = 1;
        //If number is positive update in even index or else in odd index
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ans[pos] = nums[i];
                pos += 2;
            } else {
                ans[neg] = nums[i];
                neg += 2;
            }
        }
        return ans;
    }

    public int[] rearrangeArrayIfOrderIsNotRequired(int[] nums) {
        for(int i = 0 ; i < nums.length ; i++){
            if(i % 2 == 0){
                if(nums[i] < 0){
                    int idx = i + 1;
                    while(idx < nums.length){
                        if(nums[idx] >= 0){
                            int temp = nums[i];
                            nums[i] = nums[idx];
                            nums[idx] = temp;
                            break;
                        }
                        idx++;
                    }
                }
            }else{
                if(nums[i] >= 0){
                    int idx = i + 1;
                    while(idx < nums.length){
                        if(nums[idx] < 0){
                            int temp = nums[i];
                            nums[i] = nums[idx];
                            nums[idx] = temp;
                            break;
                        }
                        idx++;
                    }
                }
            }
        }
        return nums;
    }
}

