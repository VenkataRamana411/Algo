package striver.dp.subseqences;

import java.util.Arrays;

public class KnapSack {
    public static void main(String[] args) {
        int[] weight = {1,2,4,5};
        int[] value = {5,4,8,6};
        int maxWeight = 5;
        int n = weight.length;
        System.out.println(helper(weight,value,maxWeight, n -1));
        int[][] dp = new int[n][maxWeight+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        System.out.println(helperMemo(weight,value,maxWeight,n-1,dp));
        System.out.println(helperTab(weight,value,maxWeight));
        System.out.println(helperTabOpt(weight,value,maxWeight));
        System.out.println(helperTabOptOpt(weight,value,maxWeight));
    }


    private static int helperTab(int[] weight,int[] value,int maxWeight){
        int n = weight.length;
        int[][] dp = new int[n][maxWeight+1];
        for (int i = weight[0]; i <= maxWeight; i++){
            dp[0][i] = value[0];
        }
        for (int i = 1; i < n; i++){
            for (int j = 0; j <= maxWeight; j++){
                int noTake = dp[i-1][j];
                int take = Integer.MIN_VALUE;
                if (weight[i] <= j){
                    take = value[i] + dp[i-1][j-weight[i]];
                }
                dp[i][j] = Math.max(take,noTake);
            }
        }
        return dp[n-1][maxWeight];
    }


    private static int helperTabOpt(int[] weight,int[] value,int maxWeight){
        int n = weight.length;
        int[] dp = new int[maxWeight+1];
        for (int i = weight[0]; i <= maxWeight; i++){
            dp[i] = value[0];
        }
        for (int i = 1; i < n; i++){
            int[] curr = new int[maxWeight+1];
            for (int j = 0; j <= maxWeight; j++){
                int noTake = dp[j];
                int take = Integer.MIN_VALUE;
                if (weight[i] <= j){
                    take = value[i] + dp[j-weight[i]];
                }
                curr[j] = Math.max(take,noTake);
            }
            dp = curr;
        }
        return dp[maxWeight];
    }

    private static int helperTabOptOpt(int[] weight,int[] value,int maxWeight){
        int n = weight.length;
        int[] dp = new int[maxWeight+1];
        for (int i = weight[0]; i <= maxWeight; i++){
            dp[i] = value[0];
        }
        for (int i = 1; i < n; i++){
            for (int j = maxWeight; j >= 0; j--){
                int noTake = dp[j];
                int take = Integer.MIN_VALUE;
                if (weight[i] <= j){
                    take = value[i] + dp[j-weight[i]];
                }
                dp[j] = Math.max(take,noTake);
            }
        }
        return dp[maxWeight];
    }


    /**
    * Tc: O(N * W)
     * SC: O(N * W)
    * */

    private static int helperMemo(int[] weight,int[] value,int maxWeight,int index,int[][] dp){
        if (index == 0){
            if (weight[index] <= maxWeight){
                return value[index];
            }
            return 0;
        }
        if (dp[index][maxWeight] != -1){
            return dp[index][maxWeight];
        }
        int noTake = helper(weight,value, maxWeight,index-1);
        int take = Integer.MIN_VALUE;
        if (weight[index] <= maxWeight){
            take = value[index] + helper(weight,value, maxWeight-weight[index],index-1);
        }
        return Math.max(take,noTake);
    }

    private static int helper(int[] weight, int[] value, int maxWeight, int index){
        if (index == 0){
            if (weight[index] <= maxWeight){
                return value[index];
            }
            return 0;
        }
        if (weight[index] <= maxWeight){
            return Math.max(value[index] + helper(weight,value, maxWeight-weight[index],index-1),helper(weight,value, maxWeight,index-1));
        }
        return helper(weight,value, maxWeight,index-1);
    }

}
