package striver.dp.grids;

import java.util.Arrays;

public class TrianglePath {
    public static void main(String[] args) {
        int[][] triangle = {{1},{2,3},{3,6,7},{8,9,6,10}};
        System.out.println(helper(triangle,0,0,triangle.length-1));
        int[][] dp = new int[triangle.length][triangle[triangle.length-1].length];
        for (int[] row : dp){
            Arrays.fill(row,-1);
        }
        System.out.println(helperMemo(triangle,0,0, triangle.length-1, dp));
        System.out.println(helperTab(triangle));
        System.out.println(helperTabOpt(triangle));
    }

    private static int helperTab(int[][] triangle){
        int m = triangle.length;
        int n = triangle[triangle.length - 1].length;
        int[][] dp = new int[m][n];
        for (int j = 0; j < n; j++){
            dp[n-1][j] = triangle[n-1][j];
        }
        for (int i = n-2; i >= 0; i--){
            for (int j = i; j >= 0; j--){
                int p1 = triangle[i][j] + dp[i + 1][j];
                int p2 = triangle[i][j] + dp[i + 1][j+1];
                dp[i][j] = Math.min(p1,p2);
            }
        }
        return dp[0][0];
    }

    private static int helperTabOpt(int[][] triangle){
        int n = triangle[triangle.length - 1].length;
        int[] dp = new int[n];
        for (int j = 0; j < n; j++){
            dp[j] = triangle[n-1][j];
        }
        for (int i = n-2 ; i >= 0; i--){
            int[] temp = new int[n];
            for (int j = i; j >= 0; j--){
                int p1 = triangle[i][j] + dp[j];
                int p2 = triangle[i][j] + dp[j+1];
                temp[j] = Math.min(p1,p2);
            }
            dp = temp;
        }
        return dp[0];
    }
    private static int helper(int[][] triangle,int row,int col,int lastRow){
        if (row == lastRow){
            return triangle[row][col];
        }
        int p1 = triangle[row][col] + helper(triangle,row+1,col,lastRow);
        int p2 = triangle[row][col] + helper(triangle,row+1,col+1,lastRow);
        return Math.min(p1,p2);
    }
    private static int helperMemo(int[][] triangle,int row,int col,int lastRow,int[][] dp){
        if (row == lastRow){
            return triangle[row][col];
        }
        if (dp[row][col] != -1){
            return dp[row][col];
        }
        int p1 = triangle[row][col] + helper(triangle,row+1,col,lastRow);
        int p2 = triangle[row][col] + helper(triangle,row+1,col+1,lastRow);
        return dp[row][col] = Math.min(p1,p2);
    }
}
