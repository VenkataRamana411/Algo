package target.slide;

public class LongestSubStringReplacement {

    public static void main(String[] args) {
        System.out.println(longestSubstringReplacement("BBABCCDD",2));

    }

    private static int longestSubstringReplacement(String s,int k) {
        int[] freq = new int[26];
        int result = 0, lIdx = 0, maxFreq = 0; // Tracks the max frequency of any single character in the window
        for (int rIdx = 0; rIdx < s.length(); rIdx++) {
            freq[s.charAt(rIdx) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(rIdx) - 'A']);
            int windowSize = rIdx - lIdx + 1; // +1 Because we are considering current char as well
            if (windowSize - maxFreq > k) {
                freq[s.charAt(lIdx) - 'A']--; //Character doesn't matter on leftIdx as we will calculate new max anyways
                lIdx++;
            }
            result = Math.max(result, rIdx - lIdx + 1);
        }
        return result;
    }
}
