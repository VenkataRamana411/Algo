package LeetCode;

import java.util.Arrays;

public class MaxSubString {
    public static void main(String[] args) {
        System.out.println(maxSubstrings("abcdeafdef"));
        System.out.println(maxSubstrings("abcdeafzefz"));
        System.out.println(maxSubstrings("bcdaaaab"));
        System.out.println(maxSubstrings("aaaeaaa"));
    }

    public static int maxSubstrings(String word) {
        int result = 0, lastIdx = 0;
        int[] chars = new int[26];
        Arrays.fill(chars, -1);
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (chars[c - 'a'] != -1) {
                if( i - chars[c - 'a'] + 1 >= 4){
                    result++;
                    while (lastIdx < i) {
                        chars[word.charAt(lastIdx) - 'a'] = -1;
                        lastIdx++;
                    }
                }
            } else {
                chars[c - 'a'] = i;
            }
        }
        return result;
    }
}
