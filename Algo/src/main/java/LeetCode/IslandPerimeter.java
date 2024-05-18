package LeetCode;

public class IslandPerimeter {
    public static void main(String[] args) {
        int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        System.out.println(islandPerimeterDFS(grid));
        System.out.println(islandPerimeter(new int[][]{{1}}));
    }

    public static int islandPerimeter(int[][] grid) {
        int result = 0;
        int rowLength = grid.length;
        int colLength = grid[0].length;
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                if (grid[row][col] == 1) {
                    if (row - 1 < 0 || grid[row - 1][col] == 0) {
                        result++;
                    }
                    if (row + 1 == rowLength || grid[row + 1][col] == 0) {
                        result++;
                    }
                    if (col - 1 < 0 || grid[row][col - 1] == 0) {
                        result++;
                    }
                    if (col + 1 == colLength || grid[row][col + 1] == 0) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

    public static int islandPerimeterDFS(int[][] grid) {
        int result = 0;
        int rowLength = grid.length;
        int colLength = grid[0].length;
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                if (grid[row][col] == 1) {
                    result += dfsHelper(grid,row,col,rowLength,colLength);
                }
            }
        }
        return result;
    }

    private static int dfsHelper(int[][] grid, int row, int col, int rowLength, int colLength) {
        if (row < 0 || row >= rowLength || col < 0 || col >= colLength || grid[row][col] == 0) {
            return 1;
        }
        if (grid[row][col] == -1) {
            return 0;
        }
        grid[row][col] = -1;
        return dfsHelper(grid, row - 1, col, rowLength, colLength) + dfsHelper(grid, row + 1, col, rowLength, colLength)
                + dfsHelper(grid, row, col - 1, rowLength, colLength) + dfsHelper(grid, row, col+1, rowLength, colLength);

    }
}
