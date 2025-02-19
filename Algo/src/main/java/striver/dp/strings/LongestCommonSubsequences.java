package striver.dp.strings;

import java.util.Arrays;

public class LongestCommonSubsequences {
    public static void main(String[] args) {
        String text1 = "brute";
        String text2 = "groot";
        System.out.println(helper(text1,text2,text1.length()-1,text2.length()-1));
        int[][] dp = new int[text1.length()][text2.length()];
        for (int[] row : dp){
            Arrays.fill(row,-1);
        }
        System.out.println(helperMemo(text1,text2,text1.length()-1,text2.length()-1,dp));
        System.out.println(helperTab(text1,text2));
        System.out.println(helperTabOpt(text1,text2));
    }

    public static int helperTab(String text1, String text2){
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                if (text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }

            }
        }
        //BackTracking on DP Matrix
        StringBuilder sb = new StringBuilder();
        int i = n, j = m;
        while (i > 0 && j > 0){
            if (text1.charAt(i-1) == text2.charAt(j-1)){
                sb.append(text1.charAt(i-1));
                i--;
                j--;
            } else if (dp[i-1][j] > dp[i][j-1]) {
                i--;
            }else {
                j--;
            }
        }
        System.out.println(sb.reverse());
        return dp[n][m];
    }


    public static int helperTabOpt(String text1, String text2){
        int n = text1.length();
        int m = text2.length();
        int[] dp = new int[m+1];
        for (int i = 1; i <= n; i++){
            int[] curr = new int[m+1];
            for (int j = 1; j <= m; j++){
                if (text1.charAt(i-1) == text2.charAt(j-1)){
                    curr[j] = 1 + dp[j-1];
                }else{
                    curr[j] = Math.max(dp[j],curr[j-1]);
                }
            }
            dp = curr;
        }
        return dp[m];
    }

    /**
     *TC: O(N * M)
     * SC: O(N * M) + O(N * M) (Auxiliary stack space)
     *
    * */

    public static int helperMemo(String text1, String text2,int index1,int index2,int[][] dp) {
        if (index1 < 0 || index2 < 0){
            return 0;
        }
        if (dp[index1][index2] != -1){
            return dp[index1][index2];
        }
        if (text1.charAt(index1) == text2.charAt(index2)){
            return dp[index1][index2] = 1 + helperMemo(text1,text2,index1-1,index2-1,dp);
        }
        return dp[index1][index2] = Math.max(helperMemo(text1,text2,index1-1,index2,dp),helperMemo(text1,text2,index1,index2-1,dp));
    }

    /**
     * TC: (2^n * 2^m)
    * */
    public static int helper(String text1, String text2,int index1,int index2) {
        if (index1 < 0 || index2 < 0){
            return 0;
        }
        if (text1.charAt(index1) == text2.charAt(index2)){
            return 1 + helper(text1,text2,index1-1,index2-1);
        }
        return Math.max(helper(text1,text2,index1-1,index2),helper(text1,text2,index1,index2-1));
    }
}
