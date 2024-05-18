package LeetCode;

public class WonderfulSubString {
    public static void main(String[] args) {
        System.out.println(wonderfulSubstrings("aabb"));
    }

    public static long wonderfulSubstrings(String word) {
        int count = 0, oddcount = 0;
        int[] freq = new int[10];
        for (int i = 0; i < word.length(); i++) {
            int currIdx = i;
            while (currIdx < word.length()) {
                char curr = word.charAt(i);
                freq[curr - 'a']++;
                if (freq[curr - 'a'] % 2 != 0) {
                    oddcount++;
                }
                if (oddcount < 2) {
                    count++;
                }
            }

        }
        return count;
    }
}
