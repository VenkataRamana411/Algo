package LeetCode;

public class PathWithMaxGold {
    public static void main(String[] args) {
        int[][] grid = {{0, 6, 0}, {5, 8, 7}, {0, 9, 0}};
        System.out.println(getMaximumGold(grid));
    }

    public static int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int result = -1;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] != 0) {
                    result = Math.max(getMaxGold(grid,row,col,m,n),result);
                }
            }
        }
        return result;
    }

    private static int getMaxGold(int[][] grid, int row, int col, int m, int n) {
        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 0) {
            return 0;
        }
        int currentGold = grid[row][col];
        grid[row][col] = 0;
        int up = currentGold + getMaxGold(grid, row - 1, col, m, n);
        int down = currentGold + getMaxGold(grid, row + 1, col, m, n);
        int left = currentGold + getMaxGold(grid, row, col - 1, m, n);
        int right = currentGold + getMaxGold(grid, row, col + 1, m, n);
        grid[row][col] = currentGold;
        return Math.max(Math.max(up, down), Math.max(left, right));
    }
}
