package striver.dp.grids;

public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(helper(0, 0, 2, 2));
        System.out.println(helper(0, 0, 1, 1));
        System.out.println(helper(0, 0, 3, 3));
        System.out.println(helper(0, 0, 3, 2));
        System.out.println(helper(0, 0, 1, 6));
        System.out.println(helperTab(3,3));
        System.out.println(helperTab(1,6));
        System.out.println(helperTabOpt(3,3));
    }

    /**
     * TC: 2 ^ n
     * SC: O(Path Length) == O(m-1 + n-1)
    * */
    private static int helper(int row, int col, int m, int n) {
        if (row >= m  || col >= n) {
            return 0;
        }
        if (row == m - 1 && col == n - 1) {
            return 1;
        }
        return helper(row + 1, col, m, n) + helper(row, col + 1, m, n);
    }

    private static int helperTab(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m ; i++){
            for (int j = 0; j < n; j++){
                if (i == 0 && j == 0){
                    dp[i][j] = 1;
                    continue;
                }
                int up = 0;
                int left = 0;
                if (i > 0){
                    up = dp[i-1][j];
                }
                if (j > 0){
                    left = dp[i][j-1];
                }
                dp[i][j] = up + left;
            }
        }
        return dp[m-1][n-1];
    }

    private static int helperTabOpt(int m, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < m ; i++){
            int[] temp = new int[n];
            for (int j = 0; j < n; j++){
                if (i == 0 && j == 0){
                    temp[j] = 1;
                    continue;
                }
                int up = 0;
                int left = 0;
                if (i > 0){
                    up = dp[j];
                }
                if (j > 0){
                    left = temp[j-1];
                }
                temp[j] = up + left;
            }
            dp = temp;
        }
        return dp[n-1];
    }

    /**
     * TC: number of states == O(n * m)
     * SC: O(Path Length) == O(m-1 + n-1)
     * */
    private static int helperMemo(int row, int col, int m, int n, int[][] dp) {
        if (row >= m  || col >= n) {
            return 0;
        }
        if (row == m - 1 && col == n - 1) {
            return 1;
        }
        if (dp[row][col] != -1) {
            return dp[row][col];
        }
        dp[row][col] = helper(row + 1, col, m, n) + helper(row, col + 1, m, n);
        return dp[row][col];
    }
}
