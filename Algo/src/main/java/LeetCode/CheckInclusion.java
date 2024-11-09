package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class CheckInclusion {
    public static void main(String[] args) {

    }

    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> s1Map = new HashMap<>();
        Map<Character,Integer> s2Map = new HashMap<>();
        for(char c : s1.toCharArray()){
            s1Map.put(c,s1Map.getOrDefault(c,0)+1);
        }
        for(char c : s2.toCharArray()){
            s1Map.put(c,s2Map.getOrDefault(c,0)+1);
        }
        for(Map.Entry<Character,Integer> entry : s1Map.entrySet()){
            if(s2Map.getOrDefault(entry.getKey(),0) != entry.getValue()){
                return false;
            }
        }
        return true;
    }
}
