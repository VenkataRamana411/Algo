package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class MaxDistance {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(4);
        List<Integer> list2 = new ArrayList<>();
        list2.add(0);
        list2.add(5);
        List<List<Integer>> arrays = new ArrayList<>();
        arrays.add(list1);
        arrays.add(list2);
        System.out.println(maxDistance(arrays));
    }
    public static int maxDistance(List<List<Integer>> arrays) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (List<Integer> list : arrays) {
            int currMin = list.get(0);
            int currMax = list.get(list.size() - 1);
            if (currMin < min && currMax > max) {
                if (currMax - min > max - currMin) {
                    max = currMax;
                } else {
                    min = currMin;
                }
            } else {
                min = Math.min(min, currMin);
                max = Math.max(max, currMax);
            }
        }
        return max - min;
    }
}
