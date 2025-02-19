package striver.dp;

import java.util.Arrays;

public class FrogJump {
    public static void main(String[] args) {
        int[] heights = {10, 20, 30, 10,25,40};
        int n = heights.length;
        System.out.println(frogJump(heights, n - 1));
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[heights.length] = 0;
        System.out.println(frogJumpMemo(heights, n - 1, dp));
        System.out.println(frogJumpTab(heights));
        System.out.println(frogJumpTabOptimized(heights));
        System.out.println(frogJumpTabKSteps(heights,heights.length));
    }

    public static int frogJump(int[] heights, int index) {
        //If you are already at index 0 return result
        if (index == 0) {
            return 0;
        }
        int oneStep = frogJump(heights, index - 1) + Math.abs(heights[index] - heights[index - 1]);
        int twoSteps = Integer.MAX_VALUE;
        if (index > 1) {
            twoSteps = frogJump(heights, index - 2) + Math.abs(heights[index] - heights[index - 2]);
        }
        return Math.min(oneStep, twoSteps);
    }

    public static int frogJumpMemo(int[] heights, int index, int[] dp) {
        if (index == 0) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int s1 = frogJumpMemo(heights, index - 1, dp) + Math.abs(heights[index] - heights[index - 1]);
        int s2 = Integer.MAX_VALUE;
        if (index > 1){
            s2 = frogJumpMemo(heights, index - 2, dp) + Math.abs(heights[index] - heights[index - 2]);
        }
        dp[index] = Math.min(s1, s2);
        return dp[index];
    }
    public static int frogJumpTab(int[] heights){
        int n = heights.length;
        int[] dp = new int[n+1];
        //Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < n; i++){
            int s1 = dp[i-1] + Math.abs(heights[i]-heights[i-1]);
            int s2 = Integer.MAX_VALUE;
            if (i > 1){
                s2 = dp[i-2] + Math.abs(heights[i]-heights[i-2]);
            }
            dp[i] = Math.min(s1,s2);
        }
        return dp[n-1];
    }

    public static int frogJumpTabOptimized(int[] heights){
        int n = heights.length;
        int prev1 = 0;
        int prev2 = 0;
        for (int i = 1; i < n; i++){
            int s1 = prev1 + Math.abs(heights[i]-heights[i-1]);
            int s2 = Integer.MAX_VALUE;
            if (i > 1){
                s2 = prev2 + Math.abs(heights[i]-heights[i-2]);
            }
            int curr = Math.min(s1,s2);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    public static int frogJumpTabKSteps(int[] heights,int k){
        int n = heights.length;
        int[] dp = new int[n+1];
        //Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < n; i++){
            int minSteps = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++){
                if (i-j >= 0){
                    int jump = dp[i-j] + Math.abs(heights[i]-heights[i-j]);
                    minSteps = Math.min(minSteps,jump);
                }
            }
            dp[i] = minSteps;
        }
        return dp[n-1];
    }
}
