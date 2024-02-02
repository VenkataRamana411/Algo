package prep.string;


import java.util.HashSet;
import java.util.Set;

public class LongestSubString {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int result = Integer.MIN_VALUE, fromIdx = 0;
        Set<Character> charSet = new HashSet<>();
        charSet.add(s.charAt(0));
        int i = 0, j = 1;
        for (j = 1; j < s.length(); j++) {
            if (!charSet.contains(s.charAt(j))) {
                charSet.add(s.charAt(j));
            } else {
                int index = s.indexOf(s.charAt(j), fromIdx);
                result = Math.max(result, j - i);
                for (; i < index; i++) {
                    charSet.remove(s.charAt(i));
                }
                i = index + 1;
                fromIdx = index + 1;
            }
        }
        return Math.max(result, j - i);
    }

    public static int lengthOfLongestSubstring2(String s) {
        Set<Character> charSet = new HashSet<>();
        int i = 0, j = 0, result = 0;
        while (j < s.length()) {
            if (!charSet.contains(s.charAt(j))) {
                charSet.add(s.charAt(j));
                j++;
            } else {
                result = Math.max(result, charSet.size());
                charSet.remove(s.charAt(i));
                i++;
            }
        }
        return Math.max(result, charSet.size());
    }

    private static void helper(HashSet<Character> charSet) {

    }
}
