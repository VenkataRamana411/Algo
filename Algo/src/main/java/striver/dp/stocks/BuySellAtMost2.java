package striver.dp.stocks;

import java.util.Arrays;

public class BuySellAtMost2 {
    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
//        System.out.println(helper(prices, 0, true, 2));
//        int[][][] dp = new int[prices.length][2][3];
//       for (int[][] rows : dp){
//           for (int[] row: rows){
//               Arrays.fill(row,-1);
//           }
//       }
//        System.out.println(helper(prices,0,1,dp,2));
        System.out.println(helperTab(prices));
    }

    private static int helperTab(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];
        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < 2; j++) {
                for (int cap = 1; cap <= 2; cap++){
                    int profit;
                    if (j == 1) {
                        profit = Math.max(-prices[i] + dp[i + 1][0][cap], dp[i + 1][1][cap]);
                    } else {
                        profit = Math.max(prices[i] + dp[i + 1][1][cap-1], dp[i + 1][0][cap]);
                    }
                    dp[i][j][cap] = profit;
                }
            }
        }
//        for (int ind = n-1; ind >= 0; ind--) {
//            for (int buy = 0; buy < 2; buy++) {
//                for (int cap = 1; cap <= 2; cap++){
//                    if (buy == 1) {
//                        //dp[ind][buy][cap] = Math.max(-prices[ind] + dp[ind + 1][0][cap], dp[ind + 1][1][cap]);
//                        dp[ind][buy][cap] = Math.max(prices[ind] + dp[ind + 1][0][cap-1], dp[ind + 1][1][cap]);
//                    }
//                    if (buy == 0){
//                        dp[ind][buy][cap] = Math.max(-prices[ind] + dp[ind + 1][0][cap], dp[ind + 1][1][cap]);
//                        dp[ind][buy][cap] = Math.max(-prices[ind] + dp[ind + 1][1][cap], dp[ind + 1][0][cap]);
//                        //dp[ind][buy][cap] = Math.max(prices[ind] + dp[ind + 1][1][cap-1], dp[ind + 1][0][cap]);
//                    }
//                }
//            }
//        }

//        // Fill the DP table from the end to the start
//        for (int i = n - 1; i >= 0; i--) {
//            for (int j = 0; j < 2; j++) {  // j = 0 (no stock), j = 1 (holding stock)
//                for (int cap = 1; cap <= 2; cap++) {  // cap = 1 or 2 (transactions remaining)
//                    int profit;
//                    if (j == 1) {
//                        // If we are holding stock, we can either:
//                        // - Stay in the same state, i.e., do nothing.
//                        // - Sell the stock on day i.
//                        profit = Math.max(-prices[i] + dp[i + 1][0][cap], dp[i + 1][1][cap]);
//                    } else {
//                        // If we are not holding stock, we can either:
//                        // - Stay in the same state, i.e., do nothing.
//                        // - Buy the stock on day i.
//                        profit = Math.max(prices[i] + dp[i + 1][1][cap - 1], dp[i + 1][0][cap]);
//                    }
//                    dp[i][j][cap] = profit;
//                }
//            }
//        }
        return dp[0][1][2];
    }

    private static int helper(int[] prices, int index, int buy, int[][][] dp, int k) {
        if (index == prices.length || k == 0) {
            return 0;
        }
        if (dp[index][buy][k] != -1) {
            return dp[index][buy][k];
        }
        int profit;
        if (buy == 1) {
            //If we buy that means we given some money from the profit
            profit = Math.max(-prices[index] + helper(prices, index + 1, 0, dp, k), helper(prices, index + 1, 1, dp, k));
        } else {
            profit = Math.max(prices[index] + helper(prices, index + 1, 1, dp, k - 1), helper(prices, index + 1, 0, dp, k));
        }
        return dp[index][buy][k] = profit;
    }

    private static int helper(int[] prices, int index, boolean buy, int k) {
        if (index == prices.length || k == 0) {
            return 0;
        }
        int profit;
        if (buy) {
            profit = Math.max(-prices[index] + helper(prices, index + 1, false, k), helper(prices, index + 1, true, k));
        } else {
            profit = Math.max(prices[index] + helper(prices, index + 1, true, k - 1), helper(prices, index + 1, false, k));
        }
        return profit;
    }
}
