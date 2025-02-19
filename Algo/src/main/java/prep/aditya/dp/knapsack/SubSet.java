package prep.aditya.dp.knapsack;

import java.util.Arrays;

public class SubSet {
    public static void main(String[] args) {
        int[] arr = {3,34,4,12,5,2};
//        System.out.println(recursion(arr,9,arr.length-1));
//        System.out.println(recursion(arr,35,arr.length-1));
//        int sum = 9;
//        int[][] memo = new int[sum+1][arr.length];
//        for (int[] dp: memo){
//            Arrays.fill(dp,-1);
//        }
//        System.out.println(memoization(arr,9,arr.length-1,memo));
        System.out.println(tabulation(arr,9));
        System.out.println(tabulation(arr,35));
        System.out.println(tabulation(arr,36));
        int[] arr2 = {1,2,3,4};
        System.out.println(recursion(arr,8,arr2.length-1));

    }
    private static boolean recursion(int[] arr,int sum,int index){
        if (sum == 0){
            return true;
        }
        if (index == 0){
            return false;
        }
        if (arr[index] > sum){
            return recursion(arr,sum,index-1);
        }
        return recursion(arr,sum-arr[index],index-1) || recursion(arr,sum,index-1);
    }
    private static boolean memoization(int[] arr,int sum,int index,int[][] memo){
        if (sum == 0){
            return true;
        }
        if (index < 0){
            return false;
        }
        if (memo[sum][index] != -1){
            return memo[sum][index] == 1;
        }
        if (arr[index] > sum){
            memo[sum][index] = memoization(arr,sum,index-1,memo) ? 1 : 0;
        }else {
            memo[sum][index] = (memoization(arr,sum-arr[index],index-1,memo) || memoization(arr,sum,index-1,memo)) ? 1 : 0;
        }
        return memo[sum][index] == 1;
    }
    private static boolean tabulation(int[] arr,int sum){
        int n = arr.length;
        boolean[][] dp = new boolean[n+1][sum+1];
        for (int i = 0; i <= n; i++){
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= sum; j++){
                if (j < arr[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                }
            }
        }
        return dp[n][sum];
    }
}
