package prep.dp;

public class GoldMine {
    public static void main(String[] args) {
        int[][] mine = {{1, 3, 1, 5}, {2, 2, 4, 1}, {5, 0, 2, 3}, {0, 6, 1, 2}};
        System.out.println(findMaxGold(mine));
    }

    private static int findMaxGold(int[][] mine) {
        int m = mine.length, n = mine[0].length , result = 0;
        int[][] dp = new int[m][n];
        for (int row = 0; row < m; row++) {
            dp[row][0] = mine[row][0];
        }
        for (int col = 1; col < n; col++) {
            for (int row = 0; row < m; row++) {
                int leftUp = (row == 0) ? 0 : dp[row-1][col-1];
                int left = dp[row][col-1];
                int leftDown = (row == m-1) ? 0 : dp[row+1][col-1];
                dp[row][col] = mine[row][col] + Math.max(Math.max(leftUp,left), leftDown);
                result = Math.max(result,dp[row][col]);
            }
        }
        return result;
    }
}
