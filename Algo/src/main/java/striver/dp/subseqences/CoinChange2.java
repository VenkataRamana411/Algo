package striver.dp.subseqences;

import java.util.Arrays;

public class CoinChange2 {
    public static void main(String[] args) {
        int[] coins = {3,5,7,8,9,10,11};
        int amount = 1000;
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for (int[] row: dp){
            Arrays.fill(row,-1);
        }
        //System.out.println(helper(coins,amount,n-1,dp));
        System.out.println(helper(coins,amount));
    }

    private static int helper(int[] coins, int amount){
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for (int i = 0; i <= amount; i++){
            if (i%coins[0] == 0){
                dp[0][i] = 1;
            }
        }
        for(int i = 1; i < n; i++){
            for (int j = 0; j <= amount; j++){
                int noTake = dp[i-1][j];
                int take = 0;
                if (j >= coins[i]){
                    take = dp[i][j-coins[i]];
                }
                dp[i][j] = take + noTake;
            }
        }
        return dp[n-1][amount];
    }
    public static int helper(int[] coins, int amount, int index, int[][] dp) {
        if (index == 0){
            if (amount % coins[index] == 0){
                return 1;
            }
            return 0;
        }
        if (dp[index][amount] != -1){
            return dp[index][amount];
        }
        int noTake = helper(coins,amount,index-1,dp);
        int take = 0;
        if (amount >= coins[index]){
            take = helper(coins,amount-coins[index],index,dp);
        }
        return noTake + take;
    }
}
