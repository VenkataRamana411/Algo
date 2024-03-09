package LeetCode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinOpes {
    public static void main(String[] args) {
        int[] nums1 = {1000000000,999999999,1000000000,999999999,1000000000,999999999};
        System.out.println(minOperations(nums1, 1000000000));

       /* int[] nums = new int[]{97, 24, 43, 45, 26};
        System.out.println(minOperations(nums, 45));*/

    }

    public static int minOperations(int[] nums, int k) {
        int result = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int n : nums) {
            priorityQueue.add(n);
        }
        while (!priorityQueue.isEmpty() && priorityQueue.size() > 1) {
            int num1 = priorityQueue.poll();
            int num2 = priorityQueue.poll();
            if (num1 >= k) {
                return result;
            } else if (num2 >= k) {
                return ++result;
            } else {
                long longnum = (long) Math.min(num1, num2) * 2 + Math.max(num1, num2);
                priorityQueue.add(longnum >Integer.MAX_VALUE ? k : (int) longnum);
                result++;
            }
        }
        return result;
    }

}
