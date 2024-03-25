package LeetCode;

public class CustomSort {
    public static void main(String[] args) {
        System.out.println(customSortString("cba", "abcd"));
    }

    public static String customSortString(String order, String s) {
        int[] frequency = new int[26];
        for (char x : s.toCharArray()) {
            frequency[x - 'a']++;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            char tempChar = order.charAt(i);
            int charIndex = tempChar - 'a';
            helper(frequency, result, tempChar, charIndex);
        }
        for (int i = 0 ; i < frequency.length ; i++){
            if (frequency[i] != 0) {
                helper(frequency, result, (char) (i + 97), i);
            }
        }
        return result.toString();
    }

    private static void helper(int[] frequency, StringBuilder result, char tempChar, int charIndex) {
        int tempFreq = frequency[charIndex];
        while (tempFreq-- != 0) {
            result.append(tempChar);
            frequency[charIndex]--;
        }
    }


}
