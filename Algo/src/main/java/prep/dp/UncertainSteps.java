package prep.dp;

public class UncertainSteps {
    public static void main(String[] args) {
        System.out.println(numberOfWays(6));
    }

    private static int numberOfWays(int n) {
        //Build given number using 1,2,3 whereas use 3 at most once [so basically k = 1]
        int mod = 1000000007;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        int count = 0;
        for (int i = 4; i <= n; i++) {
            if (count < 1){
                dp[i] = ((dp[i-1] % mod) + (dp[i-2] % mod) + (dp[i-3] % mod)) % mod;
                ++count;
            }else {
                dp[i] = ((dp[i-1] % mod) + (dp[i-2] % mod)) % mod;
            }
        }
        return dp[n];
    }
}
