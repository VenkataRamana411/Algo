package LeetCode;

import java.util.*;

public class CanBeEqual {
    public static void main(String[] args) {

    }

    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> hmap = new HashMap<>();
        for (int num : target) {
            hmap.put(num, hmap.getOrDefault(num, 0));
        }
        for (int num : arr) {
            List<Integer> nums = new ArrayList<>();
            nums.remove(num);
            hmap.put(num, hmap.getOrDefault(num, 0));
        }
//        for(int num : freq){
//            if(num != 0){
//                return false;
//            }
//        }
        return true;
    }

    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> hmap = new LinkedHashMap<>();
        for (String word : arr) {
            hmap.put(word, hmap.getOrDefault(word, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : hmap.entrySet()) {
            if (entry.getValue() == 1) {
                k--;
                if (k == 0) {
                    return entry.getKey();
                }
            }
        }
        return "";
    }
}
