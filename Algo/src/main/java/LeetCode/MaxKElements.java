package LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxKElements {
    public static void main(String[] args) {
        System.out.println(maxKelements(new int[]{756902131, 995414896, 95906472, 149914376, 387433380, 848985151}, 6));
    }

    public static long maxKelements(int[] nums, int k) {
        long result = 0L;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int n : nums) {
            priorityQueue.add(n);
        }
        while (k-- > 0) {
            int temp = priorityQueue.poll();
            result += temp;
            temp = (int) Math.ceil(temp / 3.0);
            priorityQueue.add(temp);
        }
        return result;
    }
}
