package LeetCode;

public class MinFallingPathSum {
    public static void main(String[] args) {
        int[][] grid = {{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println(minFallingPathSum(grid));
    }

    public static int minFallingPathSum(int[][] grid) {
        int result = 0;
        int rowLength = grid.length;
        int colLength = grid[0].length;
        int[][] dp = new int[rowLength][colLength];
        for (int col = 0; col < colLength; col++) {
            dp[0][col] = grid[0][col];
        }
        for (int row = 1; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                dp[row][col] = dfsHelper(grid, row, col, rowLength, colLength, dp);
                // Update the result with the minimum path sum found so far
                if (row == rowLength - 1) {
                    result = Math.min(result, dp[row][col]);
                }
            }
        }
        return result;
    }

    private static int dfsHelper(int[][] grid, int row, int col, int rowLength, int colLength, int[][] dp) {
        // Base case: Check if current row and column indices are out of bounds
        if (row < 0 || row >= rowLength || col < 0 || col >= colLength) {
            return Integer.MAX_VALUE; // Return a large value for out of bounds indices
        }
        // Return the sum of the value at the current cell and the minimum value among adjacent cells
        int temp1 = dfsHelper(grid, row - 1, col - 1, rowLength, colLength, dp);
        int temp2 = dfsHelper(grid, row - 1, col + 1, rowLength, colLength, dp);
        return grid[row][col] + Math.min(temp1, temp2);
    }
}
