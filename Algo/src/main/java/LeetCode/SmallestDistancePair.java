package LeetCode;

import java.util.PriorityQueue;

public class SmallestDistancePair {
    public static void main(String[] args) {
        int[] nums = {1,6,1};
        System.out.println(smallestDistancePair(nums,2));
    }

    public static int smallestDistancePair(int[] nums, int k) {
        int smallest = nums[nums.length-1];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i = nums.length-2; i >= 0 ; i--){
            int curr = Math.abs(nums[i]-smallest);
            if (priorityQueue.size() < k){
                priorityQueue.add(curr);
            }else {
                if (priorityQueue.peek() > curr){
                    priorityQueue.poll();
                    priorityQueue.add(curr);
                }
            }
            smallest = Math.min(smallest,nums[i]);
        }

        return priorityQueue.poll();
    }
}
