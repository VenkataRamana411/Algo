package striver.dp.grids;

import java.util.Arrays;

public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int m = grid.length;
        int n = grid[0].length;
        System.out.println(helper(grid, 0, 0, m, n));
        int[][] dp = new int[m+1][n+1];
        for (int[] row : dp){
            Arrays.fill(row,-1);
        }
        System.out.println(helperMemo(grid, 0, 0, m, n,dp));
        System.out.println(helperTab(grid));
        int[][] grid2 = {{1,2,3},{4,5,6}};
        System.out.println(helperTab(grid2));
        System.out.println(helperTabOpt(grid));
        System.out.println(helperTabOpt(grid2));
    }

    /**
     * TC: O(M * N)
     * SC: O(M * N)
    * */

    private static int helperTab(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (i == 0){
                    dp[i][j] = grid[i][j];
                    if (j != 0){
                        dp[i][j] += dp[i][j-1];
                    }
                    continue;
                }
                int up = grid[i][j] + dp[i - 1][j];
                int left = grid[i][j];
                if (j >= 1){
                    left += dp[i][j-1];
                }else {
                    left = Integer.MAX_VALUE;
                }
                dp[i][j] = Math.min(up,left);
            }
        }
        return dp[m-1][n-1];
    }

    private static int helperTabOpt(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < m; i++){
            int[] temp = new int[n];
            for (int j = 0; j < n; j++){
                if (i == 0){
                    temp[j] = grid[i][j];
                    if (j != 0){
                        temp[j] += temp[j-1];
                    }
                    continue;
                }
                int up = grid[i][j] + dp[j];
                int left = grid[i][j];
                if (j >= 1){
                    left += temp[j-1];
                }else {
                    left = Integer.MAX_VALUE;
                }
                temp[j] = Math.min(up,left);
            }
            dp = temp;
        }
        return dp[n-1];
    }

    private static int helper(int[][] grid, int row, int col, int m, int n) {
//        if (row >= m || col >= n) {
//            return 1000;
//        }
        if (row == m - 1 && col == n - 1) {
            return grid[row][col];
        }
        int down = grid[row][col];
        if (row + 1 < m) {
            down += helper(grid, row + 1, col, m, n);
        }else {
            down = Integer.MAX_VALUE;
        }
        int right = grid[row][col];
        if (col + 1 < n) {
            right += helper(grid, row, col + 1, m, n);
        }else {
            right = Integer.MAX_VALUE;
        }
        return Math.min(down, right);
//        int down = grid[row][col] + helper(grid, row + 1, col, m, n);
//        int right = grid[row][col] + helper(grid, row, col + 1, m, n);
//        return Math.min(down, right);
    }

    private static int helperMemo(int[][] grid, int row, int col, int m, int n,int[][] dp) {
        if (row == m - 1 && col == n - 1) {
            return grid[row][col];
        }
        if (dp[row][col] != -1){
            return dp[row][col];
        }
        int down = grid[row][col];
        if (row + 1 < m) {
            down += helper(grid, row + 1, col, m, n);
        }else {
            down = Integer.MAX_VALUE;
        }
        int right = grid[row][col];
        if (col + 1 < n) {
            right += helper(grid, row, col + 1, m, n);
        }else {
            right = Integer.MAX_VALUE;
        }
        return dp[row][col] = Math.min(down, right);
    }
}
