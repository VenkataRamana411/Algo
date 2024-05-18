package prep.dp;

public class Tribonacci {
    public static void main(String[] args) {
        System.out.println(tribonacciMemoization(25));
    }

    public static int tribonacci(int n) {
        if(n < 2){
            return n;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3 ; i <= n ; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[n];
    }
    public static int tribonacciMemoization(int n) {
        if (n <= 1){
            return n;
        }
        if (n == 2){
            return 1;
        }
        int[] dp = new int[n+1];
        return helper(n,dp);
//        if(n < 3){
//            return n == 2 ? 1 : n;
//        }
//        int prev1 = 1, prev2 = 1, prev3 = 0 , curr = 0;
//        for(int i = 3 ; i <= n ; i++){
//            curr = prev1 + prev2 + prev3;
//            prev3 = prev2;
//            prev2 = prev1;
//            prev1 = curr;
//        }
//        return curr;
    }
    private static int helper(int n, int[] dp){
        if (n <= 1){
            return n;
        }
        if (n == 2){
            return 1;
        }
        if (dp[n] != 0){
            return dp[n];
        }
        return dp[n] = helper(n-1,dp) + helper(n-2,dp) + helper(n-3,dp);
    }
}
