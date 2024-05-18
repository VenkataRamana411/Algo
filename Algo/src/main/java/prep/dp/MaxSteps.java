package prep.dp;

public class MaxSteps {
    public static void main(String[] args) {
        System.out.println(maxSteps(20));
    }

    /**
     * TC: O(N)
     * SC: O(N)
    * */
    private static int maxSteps(int n){
        int mod = 1000000007;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3 ; i <= n ; i++){
            dp[i] = ((dp[i-1] % mod) + (dp[i-2] % mod)) % mod;
        }
        return dp[n];
    }
}
