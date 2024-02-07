package LeetCode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {
    public static void main(String[] args) {

    }

    public String frequencySort(String s) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> priorityQueue = new PriorityQueue<>((a,b) -> Integer.compare(b.getValue(),a.getValue()));
        priorityQueue.addAll(charMap.entrySet());
        StringBuilder sb = new StringBuilder();
        while (!priorityQueue.isEmpty()){
            Map.Entry<Character, Integer> entry = priorityQueue.poll();
            char temp_char = entry.getKey();
            int temp = entry.getValue();
            for (int i = 1; i < temp ; i++){
                sb.append(temp_char);
            }
        }
        return sb.toString();
    }
}
