package LeetCode;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class MinimumBits {
    public static void main(String[] args) {
//        System.out.println(minBitFlips(10,7));
//        System.out.println(minBitFlips(10,82));
//        String s = "abd";
        Calendar calendar = new GregorianCalendar();
        String allowed = "ab";
        String[] words = {"ad","bd","aaab","baa","badab"};
        System.out.println(countConsistentStrings(allowed,words));
    }

    public static int minBitFlips(int start, int goal) {
        // XOR to find differing bits
        int xorResult = start ^ goal;
        int count = 0;
        // Count the number of 1s in xorResult (differing bits)
        while (xorResult != 0) {
            count += xorResult & 1; // Increment if the last bit is 1
            xorResult >>= 1; // Shift right to process the next bit
        }
        return count;
    }
    public static int countConsistentStrings(String allowed, String[] words) {
        int result = 0;
        HashMap<Character, Integer> chars = new HashMap<>();
        for (char c : allowed.toCharArray()) {
            chars.put(c, 1);
        }
        for (String s : words) {
            boolean isConsistent = true;
            for (char c : s.toCharArray()) {
                if (!chars.containsKey(c)) {
                    isConsistent = false;
                    break;
                }
            }
            if (isConsistent) {
                result++;
            }
        }
        return result;
    }
}
