package prep.graph.algo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class PathWithMinEffortDijkstra {
    public static void main(String[] args) {
        int[][] heights = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        System.out.println(helper(heights));
    }

    private static int helper(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] diff = new int[m][n];
        for (int[] row : diff) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        diff[0][0] = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>((x, y) -> y.distance - x.distance);
        priorityQueue.add(new Pair(0, new int[]{0, 0}));
        while (!priorityQueue.isEmpty()) {
            Pair curr = priorityQueue.poll();
            int currDiff = curr.distance;
            int currRow = curr.path[0];
            int currCol = curr.path[1];
            for (int[] dir : directions) {
                int row = currRow + dir[0];
                int col = currCol + dir[1];
                if (row >= 0 && row < m && col >= 0 && col < n) {
                    int absHeight = Math.abs(heights[currRow][currCol]-heights[row][col]);
                    absHeight = Math.max(currDiff,absHeight);
                    if (absHeight < diff[row][col]){
                        diff[row][col] = absHeight;
                        priorityQueue.add(new Pair(absHeight,new int[]{row,col}));
                    }
                }
            }
        }
        return diff[m-1][n-1];
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
