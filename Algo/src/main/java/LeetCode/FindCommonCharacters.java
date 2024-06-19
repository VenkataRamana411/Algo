package LeetCode;

import java.util.*;

public class FindCommonCharacters {
    public static void main(String[] args) {
        String[] words = {"bella","label","roller"};
        System.out.println(commonChars(words));
    }
    public static List<String> commonChars(String[] words) {
        Map<Character,Integer> freqMap = new HashMap<>();
        int target = words.length;
        List<String> result = new ArrayList<>();
        for(String word: words){
            Set<Character> charSet = new HashSet<>();
            for(char c : word.toCharArray()){
                if(!charSet.contains(c)){
                    freqMap.put(c,freqMap.getOrDefault(c,0)+1);
                }
                charSet.add(c);
            }
        }
        for(Character value : freqMap.keySet()){
            if(freqMap.get(value) == target){
                result.add(String.valueOf(value));
            }
        }
        return result;
    }
}
