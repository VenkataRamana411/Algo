package LeetCode;

import java.util.Arrays;

public class RedistributeChars {
    public static void main(String[] args) {
        String[] words = new String[]{"abc","aabc","bc"};
        System.out.println(makeEqual(words));
    }

    public static boolean makeEqual(String[] words) {
        int[] chars = new int[26];
        for (String word : words){
            for (int i = 0 ; i < word.length() ; i++){
                chars[word.charAt(i)-'a']++;
            }
        }
        int temp = chars[words[0].charAt(0)-'a'];
        for (int i = 0 ; i < 26 ; i++){
            if (chars[i] != 0 && chars[i] != temp){
                return false;
            }
        }
        return true;
    }
}
