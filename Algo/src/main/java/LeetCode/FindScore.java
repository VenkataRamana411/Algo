package LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class FindScore {
    public static void main(String[] args) {
//        int[] nums = {2, 1, 3, 4, 5, 2};
//        System.out.println(findScore(nums));
        int[] nums2 = {2, 5, 6, 6, 10};
        System.out.println(findScore(nums2));
    }

    public static long findScore(int[] nums) {
        long result = 0L;
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>((a, b) -> {
            if (a.value == b.value) {
                return Integer.compare(a.index, b.index);
            }
            return Integer.compare(a.value, b.value);
        });
        for (int i = 0; i < nums.length; i++) {
            priorityQueue.add(new Pair(nums[i], i));
        }
        while (!priorityQueue.isEmpty()) {
            Pair polled = priorityQueue.poll();
            if (nums[polled.index] != -1) {
                result += polled.value;
                int index = polled.index;
                nums[index] = -1;
                if (index > 0) {
                    nums[index - 1] = -1;
                }
                if (index < nums.length - 1) {
                    nums[index + 1] = -1;
                }
            }
        }
        return result;
    }

    static class Pair {
        int value;
        int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
