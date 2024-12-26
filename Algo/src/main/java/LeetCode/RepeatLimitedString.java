package LeetCode;

import java.util.*;

public class RepeatLimitedString {
    public static void main(String[] args) {
        System.out.println(repeatLimitedString("aababab",2));
    }
    public static String repeatLimitedString(String s, int repeatLimit) {
        StringBuilder sb = new StringBuilder();
        Map<Character,Integer> hashMap = new HashMap<>();
        for (char c : s.toCharArray()){
            hashMap.put(c,hashMap.getOrDefault(c,0)+1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b)-> Character.compare(b,a));
        pq.addAll(hashMap.keySet());
        while (!pq.isEmpty()){
            Character currChar = pq.poll();
            Integer currFreq = hashMap.get(currChar);
            for(int i = 0 ; i < repeatLimit && currFreq != 0;i++){
                sb.append(currChar);
                currFreq--;
            }
            hashMap.put(currChar,currFreq);
            if (hashMap.get(currChar) > 0 && !pq.isEmpty()){
                Character nextChar = pq.poll();
                Integer nextCharFreq = hashMap.get(nextChar);
                sb.append(nextChar);
                nextCharFreq--;
                hashMap.put(nextChar,nextCharFreq);
                if (nextCharFreq > 0){
                    pq.add(nextChar);
                }
                pq.add(currChar);
            }

        }
        return sb.toString();
    }
}
