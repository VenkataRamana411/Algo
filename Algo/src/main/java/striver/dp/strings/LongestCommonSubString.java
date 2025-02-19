package striver.dp.strings;

public class LongestCommonSubString {
    public static void main(String[] args) {
        String text1 = "abcjklp";
        String text2 = "acjkp";
        System.out.println(helperTab(text1,text2));
    }

    public static int helperTab(String text1, String text2){
        int result = 0;
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                if (text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    result = Math.max(result,dp[i][j]);
                }
            }
        }
        return result;
    }

}
