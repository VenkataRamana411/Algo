package LeetCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SortPeople {

    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Map<Integer,String> hmap = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            hmap.put(heights[i],names[i]);
        }

        Arrays.sort(heights);
        String[] result = new String[n];
        int i = n;
        for (int height : heights) {
            result[i--] = hmap.get(height);
        }
        return result;
    }
}
