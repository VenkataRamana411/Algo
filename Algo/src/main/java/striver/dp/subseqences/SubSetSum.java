package striver.dp.subseqences;

import java.util.Arrays;

public class SubSetSum {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int target = 8;
        int n = arr.length;
        System.out.println(helper(arr, target, n -1));
        int[][] dp = new int[n][target +1];
        for (int[] row: dp){
            Arrays.fill(row,-1);
        }
        System.out.println(helperMemo(arr,target, n -1,dp));
        System.out.println(helperTab(arr,target));
        System.out.println(helperTabOpt(arr,target));
    }
    private static boolean helper(int[] arr,int target,int index){
        if (target == 0){
            return true;
        }
        if (index == 0){
            return arr[0] == target;
        }
        if (arr[index] > target){
            return helper(arr,target,index-1);
        }
        return helper(arr,target-arr[index],index-1) || helper(arr,target,index-1);
    }
    private static boolean helperMemo(int[] arr,int target,int index,int[][] dp){
        if (dp[index][target] != -1){
            return dp[index][target] == 0;
        }
        if (target == 0){
            return true;
        }
        if (index == 0){
            return arr[0] == target;
        }
        if (arr[index] > target){
            return helper(arr,target,index-1);
        }

        if (helper(arr,target-arr[index],index-1) || helper(arr,target,index-1)){
            dp[index][target] = 0;
        }else {
            dp[index][target] = 1;
        }
        return dp[index][target] == 0;
    }

    /**
     * TC: O(N*K)
    * */
    private static boolean helperTab(int[] arr,int target){
        int n = arr.length;
        boolean[][] dp = new boolean [n][target +1];
        for (int i = 0; i < n; i++){
            dp[i][0] = true;
        }
        if (arr[0] <= target) {
            dp[0][arr[0]] = true;
        }
        for (int i = 1; i < n; i++){
            for (int j = 1; j <= target; j++){
                boolean noTake = dp[i-1][j];
                boolean take = false;
                if (arr[i] <= j){
                    take = dp[i-1][j-arr[i]];
                }
                dp[i][j] = take || noTake;
            }
        }
        return dp[n -1][target];
    }

    private static boolean helperTabOpt(int[] arr,int target){
        int n = arr.length;
        boolean[] dp = new boolean [target +1];
        dp[0] = true;
        if (arr[0] <= target) {
            dp[arr[0]] = true;
        }
        for (int i = 1; i < n; i++){
            boolean[] curr= new boolean[target+1];
            for (int j = 1; j <= target; j++){
                boolean noTake = dp[j];
                boolean take = false;
                if (arr[i] <= j){
                    take = dp[j-arr[i]];
                }
                curr[j] = take || noTake;
            }
            dp = curr;
        }
        return dp[target];
    }

}
