package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class CanArrange {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 10, 6, 7, 8, 9};
        System.out.println(canArrange(arr, 10));
    }

    public static boolean canArrange(int[] arr, int k) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }
        int pairCount = 0, count = arr.length / 2;

        for (int i = 0; i < count; i++) {
            Integer temp = list.get(0);
            if (list.contains(k - temp)) {
                pairCount++;
                list.remove(list.indexOf(k-temp));
            }
            list.remove(0);
        }
        return pairCount == count;
    }
}
