package ae.dp;

public class MaxSubsetSumNoAdjacent {
    public static void main(String[] args) {
        System.out.println(maxSubsetSumNoAdjacent(new int[]{75,105,120,75,90,135}));
    }

    public static int maxSubsetSumNoAdjacent(int[] array) {
        // Write your code here.
        int n = array.length;
        if (n < 3){
            if (n == 1){
                return array[0];
            }else if (n == 2){
                return Math.max(array[0],array[1]);
            }else {
                return 0;
            }
        }
        int[] dp = new int[n + 1];
        dp[0] = array[0];
        dp[1] = array[1];
        dp[2] = array[0] + array[2];
        for (int i = 3; i < n; i++) {
            dp[i] = array[i] + Math.max(dp[i - 2], dp[i - 3]);
        }
        return dp[n-1];
    }
}
