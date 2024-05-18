package prep.dp;

public class CountWays {
    public static void main(String[] args) {
        System.out.println(countWays(70));
    }

    private static int countWays(int n) {
        int mod = 1000000007;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 3;
        dp[5] = 5;
        for (int i = 6; i <= n; i++) {
            dp[i] = ((dp[i-1] % mod) + (dp[i-3] % mod) + (dp[i-5] % mod)) % mod;
        }
        return dp[n];
    }
}
