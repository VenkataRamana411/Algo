package prep.backtrack;

import java.util.LinkedList;
import java.util.Queue;

public class RatInMaze {
    public static void main(String[] args) {
        int[][] maze = {{0, 0, -1, 0}, {-1, 0, -1, 0}, {-1, 0, 0, 0}};
        int m = maze.length;
        int n = maze[0].length;
        System.out.println(backTrackHelper(maze, 0, 0, m, n, m - 1, n - 1));
        System.out.println(bfsBackTracker(maze, 0, 0, m, n, m - 1, n - 1));
        maze = new int[][]{{0, -1, -1, 0}, {-1, -1, -1, -1}, {0, 0, 0, 0}};
        System.out.println(bfsBackTrackerKSteps(maze, 0, 0, m, n, m - 1, n - 4, 2));
        maze = new int[][]{
                {0, -1, -1, -1},
                {-1, 0, -1, -1},
                {0, -1, -1, 0}};
        System.out.println(bfsBackTrackerMaximumOfKSteps(maze, 0, 0, m, n, m - 1, n - 1, 3));
    }

    private static boolean bfsBackTracker(int[][] maze, int sourceRow, int sourceCol, int m, int n, int destRow, int destCol) {
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        //To add diagonal changes all we need to do is add ==> {1,1},{1,-1},{-1,1},{-1,-1}
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sourceRow, sourceCol});
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];
            visited[row][col] = true;
            if (row == destRow && col == destCol) {
                return true;
            }
            for (int[] dir : directions) {
                row += dir[0];
                col += dir[1];
                if (row >= 0 && row < m && col >= 0 && col < n && maze[row][col] != -1 && visited[row][col] == false) {
                    queue.add(new int[]{row, col});
                }
            }
        }
        return false;
    }

    private static boolean bfsBackTrackerKSteps(int[][] maze, int sourceRow, int sourceCol, int m, int n, int destRow, int destCol, int k) {
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sourceRow, sourceCol});
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];
            visited[row][col] = true;
            if (row == destRow && col == destCol) {
                return true;
            }
            for (int[] dir : directions) {
                row += dir[0] * k;
                col += dir[1] * k;
                if (row >= 0 && row < m && col >= 0 && col < n && maze[row][col] != -1 && visited[row][col] == false) {
                    queue.add(new int[]{row, col});
                }
            }
        }
        return false;
    }

    //Take maximum of k steps that means from 1 to K we can take any number of steps
    private static boolean bfsBackTrackerMaximumOfKSteps(int[][] maze, int sourceRow, int sourceCol, int m, int n, int destRow, int destCol, int k) {
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sourceRow, sourceCol});
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];
            visited[row][col] = true;
            if (row == destRow && col == destCol) {
                return true;
            }
//            else{
//                visited[row][col] = false;
//            } BackTracking step ??? check it
            for (int[] dir : directions) {
                for (int i = 1; i <= k; i++) {
                    row += dir[0] * i;
                    col += dir[1] * i;
                    if (row >= 0 && row < m && col >= 0 && col < n && maze[row][col] != -1 && visited[row][col] == false) {
                        queue.add(new int[]{row, col});
                    }
                }
            }
        }
        return false;
    }

    private static boolean backTrackHelper(int[][] maze, int row, int col, int m, int n, int destRow, int destCol) {
        if (row < 0 || row >= m || col < 0 || col >= n || maze[row][col] == -1) {
            return false;
        }
        if (row == destRow && col == destCol && maze[destRow][destCol] == 0) {
            return true;
        }
        int temp = maze[row][col];
        maze[row][col] = -1;
        boolean up = backTrackHelper(maze, row - 1, col, m, n, destRow, destCol);
        boolean down = backTrackHelper(maze, row + 1, col, m, n, destRow, destCol);
        boolean left = backTrackHelper(maze, row, col - 1, m, n, destRow, destCol);
        boolean right = backTrackHelper(maze, row, col + 1, m, n, destRow, destCol);
        maze[row][col] = temp;
        return up || down || left || right;
    }


}
