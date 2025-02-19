package striver.dp.subseqences;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int target = 7;
        int n = nums.length;
        System.out.println(coinChange(nums,target,n-1));
        int[][] dp = new int[n][target+1];
        for (int[] row : dp){
            Arrays.fill(row,-1);
        }
        System.out.println(coinChangeMemo(nums,target,n-1,dp));
        System.out.println(coinChangeTab(nums,target));
    }


    public static int coinChangeTab(int[] nums,int target){
        int n = nums.length;
        int[][] dp = new int[n][target+1];
        //It can be any target from 0 to Target at index 0
        for (int i = 0 ; i <= target; i++){
            if (i % nums[0] == 0){
                dp[0][i] = i / nums[0];
            }else {
                dp[0][i] = 20000;
            }
        }
        for (int i = 1; i < n; i++){
            for (int j = 0; j <= target; j++){
                int noTake = dp[i-1][j];
                int take = Integer.MAX_VALUE;
                if (nums[i] <= j){
                    take = 1 + dp[i][j-nums[i]];
                }
                dp[i][j] = Math.min(take,noTake);
            }
        }
        return dp[n-1][target];
    }

    /**
     * TC: O(N*T) as recurrence stands at same index at picking it
     *SC: O(N*T) + O(T)
     * */
    public static int coinChangeMemo(int[] nums,int target,int index,int[][] dp){
        if (index == 0){
            if (target % nums[0] == 0){
                return target / nums[0];
            }
            return 20000;
        }
        if (dp[index][target] != -1){
            return dp[index][target];
        }
        int noTake = coinChange(nums,target,index-1);
        int take = Integer.MAX_VALUE;
        if (nums[index] <= target){
            take = 1 + coinChange(nums,target-nums[index],index);
        }
        return dp[index][target] = Math.min(take,noTake);
    }

    /**
     * TC: O(2^n) as recurrence stands at same index at picking it
     *
    * */

    public static int coinChange(int[] nums,int target,int index){
        if (index == 0){
            if (target % nums[0] == 0){
                return target / nums[0];
            }
            return 20000;
        }
        int noTake = coinChange(nums,target,index-1);
        int take = Integer.MAX_VALUE;
        if (nums[index] <= target){
            take = 1 + coinChange(nums,target-nums[index],index);
        }
        return Math.min(take,noTake);
        //return result;
    }
}
