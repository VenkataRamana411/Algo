package striver.dp.strings;

public class LongestPalidromicSubsequence {
    public static void main(String[] args) {
        String s = "bbabcbcab";
        StringBuilder sb = new StringBuilder(s);
        System.out.println(s);
        System.out.println(sb.reverse());
        System.out.println(helperTab(s,sb.reverse().toString()));
        //For Min insertions to make string palindrome ==> len(s)-LongestPalindromicSubSequence
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
        return dp[n][m];
    }
}
