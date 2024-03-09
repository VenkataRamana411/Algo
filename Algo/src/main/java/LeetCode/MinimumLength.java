package LeetCode;

public class MinimumLength {
    public static void main(String[] args) {
        System.out.println(minimumLength("aabccabba"));
        System.out.println(minimumLength("cabaabac"));
        System.out.println(minimumLength("bbbbbbbbbbbbbbbbbbb"));
    }

    public static int minimumLength(String s) {
        int length = s.length();
        int i = 0, j = length - 1, count = 0;
        char[] ch = s.toCharArray();
        while (i < j) {
            char c = ch[i];
            if (c != ch[j]) {
                break;
            }
            while (i < length && c == ch[i]) {
                i++;
                count++;
            }
            while (i < j && c == ch[j]) {
                j--;
                count++;
            }
        }
        return length - count;
    }

    public int minimumLength2(String s) {
        int i = 0, j = s.length() - 1, count = 0;
        while (i < j) {
            Character c = s.charAt(i);
            if (!c.equals(s.charAt(j))) {
                break;
            }
            while (i < s.length() && c.equals(s.charAt(i))) {
                i++;
                count++;
            }
            while (i < j && c.equals(s.charAt(j))) {
                j--;
                count++;
            }
        }
        return s.length() - count;
    }
}
