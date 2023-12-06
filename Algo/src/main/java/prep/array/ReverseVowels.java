package prep.array;

import java.util.Arrays;
import java.util.HashSet;

public class ReverseVowels {
    public static void main(String[] args) {
        System.out.println(helper("leetcode"));
        System.out.println(helper2("leetcode"));
    }

    private static String helper(String s) {
        StringBuilder result = new StringBuilder(s);
        String ref = "aeiouAEIOU";
        for (int i = 0, j = s.length() - 1; i < j; ) {
            if (ref.indexOf(s.charAt(i)) != -1 && ref.indexOf(s.charAt(j)) != -1) {
                char temp = s.charAt(i);
                result.setCharAt(i, s.charAt(j));
                result.setCharAt(j, temp);
                i++;
                j--;
            }
            if (ref.indexOf(s.charAt(i)) == -1) {
                i++;
            }
            if (ref.indexOf(s.charAt(j)) == -1) {
                j--;
            }
        }
        return result.toString();
    }

    private static String helper2(String s){
        char[] chars = s.toCharArray();
        int start = 0 , end = s.length()-1;
        HashSet<Character> ref = new HashSet<>();
        ref.add('a');
        ref.add('e');
        ref.add('i');
        ref.add('o');
        ref.add('u');
        ref.add('A');
        ref.add('E');
        ref.add('I');
        ref.add('O');
        ref.add('U');
        while (start < end){
            if (!ref.contains(s.charAt(start))){
                start++;
                continue;
            }
            if (!ref.contains(s.charAt(end))){
                end--;
                continue;
            }
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(chars);
    }
}
