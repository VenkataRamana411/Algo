package striver.dp;

import java.util.Arrays;

public class NinaTraining {
    public static void main(String[] args) {
        int[][] points = {{10, 40, 70}, {20, 50, 80}, {30, 60, 90}};
        int result = 0;
        for (int i = 0; i < 3; i++) {
            result = Math.max(result, helper(points, i, points.length-1));
        }
        System.out.println(result);
        int[][] dp = new int[points.length+1][3];
        for (int[] row : dp){
            Arrays.fill(row,-1);
        }
        int result2 = 0;
        for (int i = 0; i < 3; i++) {
            result2 = Math.max(result, helperMemo(points,dp, i, points.length-1));
        }
        System.out.println(result2);
        System.out.println(tabulation(points));
        System.out.println(tabulationOpt(points));
    }

    private static int helper(int[][] points, int trainingType, int day) {
        if (day < 0) {
            return 0;
        }
        int t0 = Integer.MIN_VALUE, t1 = Integer.MIN_VALUE, t2 = Integer.MIN_VALUE;
        if (trainingType != 0) {
            t0 = points[day][0] + helper(points, 0, day - 1);
        }
        if (trainingType != 1) {
            t1 = points[day][1] + helper(points, 1, day - 1);
        }
        if (trainingType != 2) {
            t2 = points[day][2] + helper(points, 2, day - 1);
        }
        return Math.max(Math.max(t0, t1), t2);
    }

    private static int helperMemo(int[][] points,int[][] dp, int trainingType, int day) {
        if (dp[day][trainingType] != -1){
            return dp[day][trainingType];
        }
        if (day == 0){
            int max = 0;
            for (int i = 0; i <=2 ; i++){
                if (i != trainingType){
                    max = Math.max(max,points[0][i]);
                }
            }
            return dp[day][trainingType] = max;
        }
        int max = 0;
        for (int i = 0; i <=2 ; i++){
            if (i != trainingType){
                int curr = points[day][i] + helperMemo(points,dp,i,day-1);
                max = Math.max(max,curr);
            }
        }
        return dp[day][trainingType] = max;
    }

    /**
    * TC: O(N*3*4)
     * SC: O(N*4)
    * */
    private static int tabulation(int[][] points){
        int n = points.length;
        // n = 4. 0,1,2 & -1 at first day
        int[][] dp = new int[n+1][4];
        dp[0][0] = Math.max(points[0][1],points[0][2]);
        dp[0][1] = Math.max(points[0][0],points[0][2]);
        dp[0][2] = Math.max(points[0][0],points[0][1]);
        dp[0][3] = Math.max(points[0][0],Math.max(points[0][1],points[0][2]));
        for (int day = 1; day < n; day++){
            for (int trainingType = 0; trainingType < 4; trainingType++){
                 dp[day][trainingType] = 0;
                 for (int task = 0; task <= 2; task++){
                     if (task != trainingType){
                         int curr = points[day][task] + dp[day-1][task];
                         dp[day][trainingType] = Math.max(dp[day][trainingType],curr);
                     }
                 }
            }
        }
        return dp[n-1][3];
    }

    /**
     * TC: O(N*3*4)
     * SC: O(4)
     * */
    private static int tabulationOpt(int[][] points){
        int n = points.length;
        // n = 4. 0,1,2 & -1 at first day
        int[] dp = new int[4];
        dp[0] = Math.max(points[0][1],points[0][2]);
        dp[1] = Math.max(points[0][0],points[0][2]);
        dp[2] = Math.max(points[0][0],points[0][1]);
        dp[3] = Math.max(points[0][0],Math.max(points[0][1],points[0][2]));
        for (int day = 1; day < n; day++){
            int[] temp = new int[4];
            for (int trainingType = 0; trainingType < 4; trainingType++){
                temp[trainingType] = 0;
                for (int task = 0; task <= 2; task++){
                    if (task != trainingType){
                        int curr = points[day][task] + dp[task];
                        temp[trainingType] = Math.max(temp[trainingType],curr);
                    }
                }
            }
            dp = temp;
        }
        return dp[3];
    }

}
