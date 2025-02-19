package striver.dp.subseqences;

import java.util.Arrays;

public class KnapSackUnbounded {
    public static void main(String[] args) {
        int[] wt = {2, 4, 6};
        int[] val = {5, 11, 13};
        int total = 10;
        int n = wt.length;
        int[][] dp = new int[n][total + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(helper(wt,val,total,n-1,dp));
        System.out.println(helperTab(wt,val,total));

    }

    private static int helperTab(int[] wt,int[] val,int total){
        int n = wt.length;
        int[][] dp = new int[n][total + 1];
        for (int i = 0; i <= total ;i++){
            dp[0][i] = (i / wt[0]) * val[0];
//            if (i >= wt[0]){
//                dp[0][i] = (i / wt[0]) * val[0];
//            }
        }
        for (int i =1; i < n; i++){
            for (int j = 0; j <= total; j++){
                int notTake = dp[i-1][j];
                int take = 0;
                if (wt[i] <= j){
                    take = val[i] + dp[i][j-wt[i]];
                }
                dp[i][j] = Math.max(take,notTake);
            }
        }
        return dp[n-1][total];
    }

    private static int helper(int[] wt, int[] val, int total, int index, int[][] dp) {
        if (index == 0){
            return  (total / wt[0]) * val[0];
        }
        if (dp[index][total] != -1){
            return dp[index][total];
        }
        int noTake = helper(wt,val,total,index-1, dp);
        int take = -1;
        if (wt[index] <= total){
            take = val[index] + helper(wt,val,total-wt[index],index,dp);
        }
        return dp[index][total] = Math.max(noTake,take);
    }
}
