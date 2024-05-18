package prep.dp;

public class RemoveChocolates {
    public static void main(String[] args) {
        System.out.println(waysToRemove(5));
    }

    private static int waysToRemove(int n){
        int mod = 1000000007;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        for (int i = 4 ; i <= n ; i++){
            dp[i] = ((dp[i-1]%mod)+dp[i-3]%mod)%mod;
        }
        return dp[n];
    }
}
