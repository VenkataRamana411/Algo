package prep.string;

import java.util.Arrays;
import java.util.Collections;

public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram","nagarmm"));
    }

    /**
     * Frequency array approach
     * TC: O(M+N)
     * SC: O(1)
     *
    * */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        int[] chars = new int[26];
        for(int i = 0 ; i < s.length() ; i++){
            chars[s.charAt(i)-'a']++;
            chars[t.charAt(i)-'a']--;
        }
        //Find if any char is having frequency more than one
        for (int num : chars){
            if (num != 0){
                return false;
            }
        }
        return true;
    }
}
