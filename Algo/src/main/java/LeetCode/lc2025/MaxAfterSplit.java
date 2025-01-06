package LeetCode.lc2025;

public class MaxAfterSplit {

    public static void main(String[] args) {
        System.out.println(maxScore("011101"));
    }
    public static int maxScore(String s) {
        int rc = 0;
        int lc = 0;
        int best = Integer.MIN_VALUE;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                rc++;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                lc++;
            } else {
                rc--;
            }
            best = Math.max(best, rc + lc);
        }
        return Math.max(best, rc + lc);
    }
}
