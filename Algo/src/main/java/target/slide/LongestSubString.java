package target.slide;

import java.util.HashSet;
import java.util.Set;

public class LongestSubString {

    public static void main(String[] args) {
        //System.out.println(longestSubstringWithoutRepeat("ksubstring"));
        System.out.println(longestSubstringWithoutRepeat("tmmzuxt"));

    }

    private static int longestSubstringWithoutRepeat(String s) {
        int lIdx = 0, result = 0;
        Set<Character> set = new HashSet<>();
        for (int rIdx = 0; rIdx < s.length(); rIdx++) {
            if (set.contains(s.charAt(rIdx))) {
                result = Math.max(result, rIdx - lIdx);
                char curr = s.charAt(rIdx);
                while (set.contains(curr)) {
                    set.remove(s.charAt(lIdx++));
                }
            }
            set.add(s.charAt(rIdx));
        }
        result = Math.max(result, s.length() - lIdx);
        return result;
    }
}
