package LeetCode;

public class MaxScore {

    static StringBuilder sb = null;

    public static void main(String[] args) {
        System.out.println(maximumGain("aabbaaxybbaabb", 5, 4));
        System.out.println(maximumGain("cdbcbbaaabab", 4, 5));
    }

    public static int maximumGain(String s, int x, int y) {
        int score = 0;
        String input1, input2 = null;
        char char1, char2;
        sb = new StringBuilder(s);
        if (x < y) {
            input1 = "ba";
            input2 = "ab";
            char1 = 'b';
            char2 = 'a';
        } else {
            input1 = "ab";
            input2 = "ba";
            char1 = 'a';
            char2 = 'b';
        }
        while (s.contains(input1)) {
            score += helperAB(sb, x, input1.charAt(0), input1.charAt(1));
            s = sb.toString();
        }
        while (s.contains(input2)) {
            score += helperAB(sb, y, input2.charAt(0), input2.charAt(1));
            s = sb.toString();
        }
        return score;
    }

    private static int helperAB(StringBuilder sb, int points, char char1, char char2) {
        int tempScore = 0;
        for (int i = 1; i < sb.length(); i++) {
            if (sb.charAt(i - 1) == char1 && sb.charAt(i) == char2) {
                tempScore += points;
                sb.deleteCharAt(i);
                sb.deleteCharAt(i - 1);
            }
        }
        return tempScore;
    }
}
