package prep.graph.algo;

import java.util.Arrays;
import java.util.PriorityQueue;

public class BinaryMazeDijkstra {
    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1, 1}, {1, 1, 0, 1}, {1, 1, 1, 1}, {1, 1, 0, 0}, {1, 0, 0, 1},};
        System.out.println(helper(grid, 0, 1, grid.length, grid[0].length, 2, 2));
        System.out.println(dijkstra(grid,0,1,2,2));
    }

    private static int dijkstra(int[][] grid, int sourceRow, int sourceCol, int destRow, int destCol) {
        int m = grid.length, n = grid[0].length;
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>((x, y) -> y.distance - x.distance);
        int[][] dist = new int[m][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[sourceRow][sourceCol] = 0;
        priorityQueue.add(new Pair(0, new int[]{sourceRow, sourceCol}));
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!priorityQueue.isEmpty()) {
            Pair curr = priorityQueue.poll();
            int currDistance = curr.distance;
            int currRow = curr.path[0];
            int currCol = curr.path[1];
            for (int[] dir : directions) {
                int row = currRow + dir[0];
                int col = currCol + dir[1];
                if (row >= 0 && col >= 0 && row < m && col < n && grid[row][col] == 1) {
                    if (dist[row][col] > currDistance + 1) {
                        dist[row][col] = currDistance + 1;
                        priorityQueue.add(new Pair(currDistance + 1, new int[]{row, col}));
                    }
                }
            }
        }
        return dist[destRow][destCol];
    }

    private static int helper(int[][] grid, int row, int col, int n, int m, int destRow, int destCol) {
        if (row == n || col == m || row < 0 || col < 0 || grid[row][col] == 0) {
            return Integer.MAX_VALUE;
        }
        if (row == destRow && col == destCol) {
            return 0;
        }
        grid[row][col] = 0;
        int down = helper(grid, row + 1, col, n, m, destRow, destCol);
        int up = helper(grid, row - 1, col, n, m, destRow, destCol);
        int right = helper(grid, row, col + 1, n, m, destRow, destCol);
        int left = helper(grid, row, col - 1, n, m, destRow, destCol);
        grid[row][col] = 1;
        int minPath = Math.min(Math.min(up, down), Math.min(left, right));
        return minPath == Integer.MAX_VALUE ? Integer.MAX_VALUE : minPath + 1;
//        // Base cases
//        if (row == n || col == m || row < 0 || col < 0 || grid[row][col] == 0) {
//            return Integer.MAX_VALUE; // Return a large number to signify an invalid path
//        }
//        if (row == destRow && col == destCol) {
//            return 0; // Reached the destination, no further steps needed
//        }
//
//        // Mark the current cell as visited
//        grid[row][col] = 0;
//
//        // Recursive calls in all four directions (down, up, right, left)
//        int down = helper(grid, row + 1, col, n, m, destRow, destCol);
//        int up = helper(grid, row - 1, col, n, m, destRow, destCol);
//        int right = helper(grid, row, col + 1, n, m, destRow, destCol);
//        int left = helper(grid, row, col - 1, n, m, destRow, destCol);
//
//        // Restore the cell after exploration
//        grid[row][col] = 1;
//
//        // Return the minimum of the four possible paths
//        int minPath = Math.min(Math.min(down, up), Math.min(right, left));
//
//        return (minPath == Integer.MAX_VALUE) ? Integer.MAX_VALUE : (minPath + 1);
    }

    static class Pair {
        public int distance;
        public int[] path;

        public Pair(int distance, int[] path) {
            this.distance = distance;
            this.path = path;
        }

    }
}
