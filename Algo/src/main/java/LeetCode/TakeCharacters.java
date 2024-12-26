package LeetCode;

public class TakeCharacters {
    public static void main(String[] args) {
//        System.out.println(takeCharacters("aabaaaacaabc", 2));
//        System.out.println(takeCharacters("abc", 1));
//        System.out.println(takeCharacters("a", 1));
        System.out.println(takeCharacters("cbbac", 1));

    }

    public static int takeCharacters(String s, int k) {
        int n = s.length();
        int countA = 0, countB = 0, countC = 0, windowSize = 0, left = n / 2;
        int right = left + 1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                countA++;
            } else if (s.charAt(i) == 'b') {
                countB++;
            } else {
                countC++;
            }
        }
        while (left >= 0 && right < n) {
            if (s.charAt(left) == 'a' && countA - 1 >= k) {
                countA--;
                left--;
                windowSize++;
            } else if (s.charAt(left) == 'b' && countB - 1 >= k) {
                countB--;
                left--;
                windowSize++;
            } else if (s.charAt(left) == 'c' && countC - 1 >= k) {
                countC--;
                left--;
                windowSize++;
            } else if (s.charAt(right) == 'a' && countA - 1 >= k) {
                countA--;
                right++;
                windowSize++;
            } else if (s.charAt(right) == 'b' && countB - 1 >= k) {
                countB--;
                right++;
                windowSize++;
            } else if (s.charAt(right) == 'c' && countC - 1 >= k) {
                countC--;
                right++;
                windowSize++;
            } else {
                break;
            }
        }
        if (countA < k || countB < k || countC < k){
            return -1;
        }
        return n - windowSize;
    }
}
