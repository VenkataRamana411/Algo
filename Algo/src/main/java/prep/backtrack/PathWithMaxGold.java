package prep.backtrack;

public class PathWithMaxGold {
    public static void main(String[] args) {
        int[][] grid = {{0, 6, 0}, {5, 8, 7}, {0, 9, 0}};
        System.out.println(getMaximumGold(grid));
    }

    public static int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int result = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    result = Math.max(result, dfsHelper(i, j, grid, m, n));
                }
            }
        }
        return result;
    }

    private static int dfsHelper(int i, int j, int[][] grid, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
            return 0;
        }
        int val = grid[i][j];
        grid[i][j] = 0;
        int up = val + dfsHelper(i - 1, j, grid, m, n);
        int down = val + dfsHelper(i + 1, j, grid, m, n);
        int left = val + dfsHelper(i, j - 1, grid, m, n);
        int right = val + dfsHelper(i, j + 1, grid, m, n);
        grid[i][j] = val;
        return Math.max(Math.max(up,down),Math.max(left,right));
        //return up + down + left + right;
    }
}
