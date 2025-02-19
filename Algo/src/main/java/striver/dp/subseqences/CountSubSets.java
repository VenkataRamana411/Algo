package striver.dp.subseqences;

import java.util.Arrays;

public class CountSubSets {
    public static void main(String[] args) {
        int[] nums = {1,4,4,5};
        int n = nums.length;
        int tar = 5;
        System.out.println(findWays(nums, tar, n - 1));
        int[][] dp = new int[n][tar+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        System.out.println(findWaysMemo(nums, tar, n - 1,dp));
        System.out.println(findWaysTab(nums,tar));
        System.out.println(findWaysTabOpt(nums,tar));
    }

    private static int findWaysTab(int[] nums,int tar){
        int n = nums.length;
        int[][] dp = new int[n][tar+1];
        for (int i = 0; i < n; i++){
            dp[i][0] = 1;
        }
//        if (nums[0] == tar){
//            dp[0][tar] = 1;
//        }
        /**
         * Basically we are saying by picking first element in the array, we can make target of itself
         * Ex: [8,2,3,4] ==> Sum of 8 can be achieved by taking zero index element
        * */

        if (nums[0] <= tar) {
            dp[0][nums[0]] = 1;
        }


        for (int i = 1; i < n; i++){
            for (int j = 1; j <= tar; j++){
                int noTake = dp[i-1][j];
                int take = 0;
                if (j >= nums[i]){
                    take = dp[i-1][j-nums[i]];
                }
                dp[i][j] = take + noTake;
            }
        }
        return dp[n-1][tar];
    }


    private static int findWaysTabOpt(int[] nums,int tar){
        int n = nums.length;
        int[] dp = new int[tar+1];
        dp[0] = 1;
        if (nums[0] <= tar){
            dp[nums[0]] = 1;
        }
        for(int i = 1; i < n; i++){
            int[] curr = new int[tar+1];
            /*Intialization is needed as we are starting from 1. base case for zero target is always true*/
            curr[0] = 1;
            for (int j = 1; j <= tar; j++){
                int noTake = dp[j];
                int take = 0;
                if (nums[i] <= j){
                    take = dp[j-nums[i]];
                }
                curr[j] = take + noTake;
            }
            dp = curr;
        }
        return dp[tar];
    }

    private static int findWaysMemo(int[] nums,int tar,int index,int[][] dp){
        if (index == 0){
            if (nums[index] == tar){
                return 1;
            }
            return 0;
        }
        if (dp[index][tar] != -1){
            return dp[index][tar];
        }
        if (tar == 0){
            return 1;
        }
        int noTake = findWays(nums, tar, index - 1);
        int take = 0;
        if (tar-nums[index] >= 0){
            take = findWays(nums, tar - nums[index], index - 1);
        }
        return dp[index][tar] = take + noTake;
    }
    private static int findWays(int[] nums,int tar,int index){
        if (index == 0){
            if (nums[index] == tar){
                return 1;
            }
            return 0;
        }
        if (tar == 0){
            return 1;
        }
        int noTake = findWays(nums, tar, index - 1);
        int take = 0;
        if (tar-nums[index] >= 0){
            take = findWays(nums, tar - nums[index], index - 1);
        }
        return take + noTake;
    }
}
