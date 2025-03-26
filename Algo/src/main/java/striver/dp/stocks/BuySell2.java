package striver.dp.stocks;

import java.util.Arrays;

public class BuySell2 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(helper(prices,0,true));
        int[][] dp = new int[prices.length][2];
        for (int[] row : dp){
            Arrays.fill(row,-1);
        }
        System.out.println(helper(prices,0,1,dp));
        System.out.println(helperTab(prices));
    }

    private static int helperTab(int[] prices){
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        dp[0][1] = -prices[0];
        dp[0][0] = 0;
        for (int i = 1; i < n; i++){
            for (int j = 0; j < 2; j++){
                int profit = 0;
                if (j == 1){
                    profit = Math.max(-prices[i] + dp[i-1][0],dp[i-1][1]);
                }else {
                    profit = Math.max(prices[i] + dp[i-1][1],dp[i-1][0]);
                }
                dp[i][j] = profit;
            }
        }
        return dp[n-1][0];
    }

    private static int helper(int[] prices,int index,int buy,int[][] dp){
        if (index == prices.length){
            return 0;
        }
        if (dp[index][buy] != -1){
            return dp[index][buy];
        }
        int profit;
        if (buy == 1){
            //If we buy that means we given some money from the profit
            profit = Math.max(-prices[index] + helper(prices,index+1,0,dp),helper(prices,index+1,1,dp));
        }else {
            profit = Math.max(prices[index] + helper(prices,index+1,1,dp),helper(prices,index+1,0,dp));
        }
        return dp[index][buy] = profit;
    }

    private static int helper(int[] prices,int index,boolean buy){
        if (index == prices.length){
            return 0;
        }
        int profit = 0;
        if (buy){
            profit = Math.max(-prices[index] + helper(prices,index+1,false),helper(prices,index+1,true));
        }else {
            profit = Math.max(prices[index] + helper(prices,index+1,true),helper(prices,index+1,false));
        }
        return profit;
    }
}
