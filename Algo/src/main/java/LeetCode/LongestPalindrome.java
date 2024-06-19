package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("ababababa"));
    }
    public static int longestPalindrome(String s) {
        Map<Character,Integer> freqMap = new HashMap<>();
        for(int i = 0 ; i < s.length(); i++){
            freqMap.put(s.charAt(i),freqMap.getOrDefault(s.charAt(i),0)+1);
        }
        if (freqMap.size() == 1){
            return freqMap.get(s.charAt(0));
        }
        int result = 0,center = 0;
        for(int count : freqMap.values()){
            if(count % 2 == 0){
                result += count;
            }else if (count > 2){
                result += count-1;
            }else {
                center = 1;
            }
        }
        return result + center;
    }
}
