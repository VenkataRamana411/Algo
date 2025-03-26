package LeetCode.lc2025;

import java.util.HashMap;
import java.util.HashSet;

public class NumberOfSubstrings {
    public static void main(String[] args) {
        String[] strings = {"abcabc", "aaacb", "abc"};
        for (String s : strings) {
            System.out.println(s.length());
            System.out.println(s + " : " + numberOfSubstrings(s));
        }
    }

    public static int numberOfSubstrings(String s) {
        int result = 0, left = 0, n = s.length();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            //Add to window
            hashMap.put(s.charAt(right), hashMap.getOrDefault(s.charAt(right), 0) + 1);
            while (hashMap.size() == 3) {
                //length-right gives all substrings
                result += n - right;

                //Reduce left index until we have all characters
                char leftChar = s.charAt(left);
                hashMap.put(s.charAt(left), hashMap.get(s.charAt(left)) - 1);

                //Remove the char if no reference is there
                if (hashMap.get(leftChar) == 0) {
                    hashMap.remove(leftChar);
                }
                left++;
            }
        }
        return result;
    }
}
