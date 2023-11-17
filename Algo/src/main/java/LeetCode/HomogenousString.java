package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class HomogenousString {
    public static void main(String[] args) {
        String input = "abbcccaa";
        System.out.println(countHomogenous(input));
    }

    public static int countHomogenous(String s) {
        int result = 0;
        int value = 1;
        char temp = s.charAt(0);
        for (int i = 1; i < s.length();) {
            if (temp != s.charAt(i)){
                result += ((value * (value + 1)) / 2);
                value = 1;
                temp = s.charAt(i);
            }
            value++;
            i++;
        }
        return result;
    }
}
