package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class HighestPeak {
    public static void main(String[] args) {
        int[][] isWater1 = new int[][]{{0,1},{0,0}};
        int[][] isWater2 = new int[][]{{0,0,1},{1,0,0},{0,0,0}};
        HighestPeak highestPeak = new HighestPeak();
        System.out.println(Arrays.deepToString(highestPeak.highestPeak(isWater1)));
        System.out.println(Arrays.deepToString(highestPeak.highestPeak(isWater2)));
    }

    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] result = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(isWater[i][j] == 1){
                    visited[i][j] = true;
                    queue.add(new int[]{i,j});
                }
            }
        }
        int[][] directions = {{0, 1},{0, -1},{1, 0},{-1, 0}};
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];
            int currRow, currCol;
            visited[row][col] = true;
            for (int[] dir : directions) {
                currRow = row + dir[0];
                currCol = col + dir[1];
                if (currRow >= 0 && currRow < m && currCol >= 0 && currCol < n && !visited[currRow][currCol]) {
                    result[currRow][currCol] = result[curr[0]][curr[1]] +1;
                    visited[currRow][currCol] = true;
                    queue.add(new int[]{currRow, currCol});
                }
            }
        }
        //        int m = isWater.length;
//        int n = isWater[0].length;
//        int[][] result = new int[m][n];
//        Queue<int[]> queue = new LinkedList<>();
//        boolean[][] visited = new boolean[m][n];
//        queue.add(new int[]{isWater[0][0]});
//        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
//        while (!queue.isEmpty()) {
//            int[] curr = queue.poll();
//            int row = curr[0];
//            int col = curr[1];
//            visited[row][col] = true;
//            if (isWater[row][col] == 1) {
//                result[row][col] = 0;
//            }else{
//                int max = 0;
//                if(row > 0 && visited[row-1][col]){
//                    max = Math.max(max,result[row-1][col]);
//                }
//                if(row < m-1 && visited[row+1][col]){
//                    max = Math.max(max,result[row+1][col]);
//                }
//                if(col > 0 && visited[row][col-1]){
//                    max = Math.max(max,result[row][col-1]);
//                }
//                if(col > n-1 && visited[row][col+1]){
//                    max = Math.max(max,result[row][col+1]);
//                }
//                result[row][col] = max+1;
//            }
//            for (int[] dir : directions){
//                row += dir[0];
//                col += dir[1];
//                if (row >= 0 && row < m && col >= 0 && col < n && result[row][col] != -1 && !visited[row][col]) {
//                    queue.add(new int[]{row, col});
//                }
//            }
//        }
        return result;
    }
}
