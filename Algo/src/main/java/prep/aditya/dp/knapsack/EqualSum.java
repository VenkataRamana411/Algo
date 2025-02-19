package prep.aditya.dp.knapsack;

public class EqualSum {
    public static void main(String[] args) {
        int[] arr = {1,5,11,5};
        System.out.println(recursion(arr));
    }
    private static boolean recursion(int[] arr){
        int sum = 0;
        for (int num : arr){
            sum += num;
        }
        /**
         * Total is odd ==> Return false as we can't have fractions
         * */

        if (sum % 2 != 0){
            return false;
        }
        /**
         * Check if we have any subset with half the sum
         * */
        return memoization(arr,sum/2);
        // TS : RS == LS
        //return helper(arr,0,0,sum);
    }

    private static boolean memoization(int[] arr,int sum){
        int n = arr.length;
        boolean[][] dp = new boolean[n+1][sum+1];
        for(int i = 1; i <= n; i++){
            dp[i][0] = true;
        }
        for(int i = 1; i <= n; i++){
            for (int j = 1; j <= sum; j++){
                if (j < arr[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];

                }
            }
        }
        return dp[n][sum];
    }
    private static boolean helper(int[] arr,int index,int leftSum,int rightSum){
        if (index >= arr.length){
            return false;
        }
        if (leftSum + arr[index] == rightSum - arr[index]){
            return true;
        }else {
            return helper(arr,index+1,leftSum+arr[index],rightSum-arr[index]) || helper(arr,index+1,leftSum,rightSum);
        }
    }
}
