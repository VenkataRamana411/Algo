package LeetCode;

import java.util.Arrays;

public class MaxMoves {
    public static void main(String[] args) {

    }

    private static final int[] dirs = {-1, 0, 1};

    public static int maxMoves(int[][] grid) {
        int result = 0, m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < m; i++) {
            result = Math.max(result, dfs(grid, i, 0, dp));
        }
        return result;
    }

    private static int dfs(int[][] grid, int row, int col, int[][] dp) {
        if (dp[row][col] != -1) {
            return grid[row][col];
        }
        int max = 0;
        for (int dir : dirs) {
            int newRow = row + dir, newCol = col + 1;
            if (newRow >= 0
                    && newCol >= 0
                    && newRow < grid.length
                    && newCol < grid[0].length
                    && dp[row][col] == -1
                    && grid[row][col] < grid[newRow][newCol]){
                max = Math.max(max,1 + dfs(grid,newRow,newCol,dp));
            }
        }
        dp[row][col] = max;
        return max;
    }
}
