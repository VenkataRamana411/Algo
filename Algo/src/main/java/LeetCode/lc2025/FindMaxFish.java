package LeetCode.lc2025;

public class FindMaxFish {
    public static void main(String[] args) {
        int[][] grid = {{0, 2, 1, 0}, {4, 0, 0, 3}, {1, 0, 0, 4}, {0, 3, 2, 0}};
        System.out.println(findMaxFish(grid));
    }

    public static int findMaxFish(int[][] grid) {
        int result = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0 && vis[i][j] != -1) {
                    result = Math.max(result, helper(grid, vis, i, j, m, n));
                }
            }
        }
        return result;
    }

    private static int helper(int[][] grid, int[][] vis, int row, int col, int m, int n) {
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return 0;
        }
        if (vis[row][col] == -1 || grid[row][col] == 0) {
            return 0;
        }
        vis[row][col] = -1;
        return grid[row][col]
                + helper(grid, vis, row + 1, col, m, n)
                + helper(grid, vis, row - 1, col, m, n)
                + helper(grid, vis, row, col - 1, m, n)
                + helper(grid, vis, row, col + 1, m, n);
    }
}
