package LeetCode;

public class FirstPalindrome {
    public static void main(String[] args) {
        String[] words = {"abc","car","ada","racecar","cool"};
        System.out.println(firstPalindrome(words));
    }
    public static String firstPalindrome(String[] words) {
        for (String s : words) {
            int i = 0, j = s.length() - 1;
            while (i < j) {
                if (s.charAt(i) != s.charAt(j)) {
                    break;
                }
                i++;
                j--;
            }
            if (i >= j) {
                return s;
            }

        }
        return "";
    }
}
