package LeetCode;

public class MaxAreaOfIsland {
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}
                , {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println(maxAreaOfIsland(grid));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        int rowLength = grid.length;
        int colLength = grid[0].length;
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                if (grid[row][col] == 1) {
                    result = Math.max(result, dfsHelper(grid, row, col, rowLength, colLength));
                }
            }
        }
        return result;
    }

    private static int dfsHelper(int[][] grid, int row, int col, int rowLength, int colLength) {
        if (row < 0 || row >= rowLength || col < 0 || col >= colLength || grid[row][col] == 0) {
            return 0;
        }
        grid[row][col] = 0;
//        return 1+ dfsHelper(grid, row - 1, col, rowLength, colLength) + dfsHelper(grid, row + 1, col, rowLength, colLength)
//                + dfsHelper(grid, row, col - 1, rowLength, colLength) + dfsHelper(grid, row, col + 1, rowLength, colLength);
        int count = 1;
        count += dfsHelper(grid, row - 1, col, rowLength, colLength);
        count += dfsHelper(grid, row + 1, col, rowLength, colLength);
        count += dfsHelper(grid, row, col - 1, rowLength, colLength);
        count += dfsHelper(grid, row, col + 1, rowLength, colLength);
        return count;
    }
}
