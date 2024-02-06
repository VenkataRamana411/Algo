package LeetCode;

import java.util.*;

public class MaxSlidingWindow {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(maxSlidingWindowOptimal(nums, 3)));
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{}, 2)));
    }

    public static int[] maxSlidingWindowOptimal(int[] nums, int k) {
        Deque<Integer> q=new ArrayDeque<>();
        int j=0;
        int ans[]=new int[nums.length-k+1];
        int i=0;
        for(i=0;i<k;i++){
            while(!q.isEmpty()&&nums[i]>=nums[q.peekLast()]){
                q.removeLast();
            }
            q.addLast(i);
        }
        for(int index=i;index<nums.length;index++){
            ans[j++]=nums[q.peek()];
            while(!q.isEmpty() && q.peek() <= index-k){
                q.removeFirst();
            }
            while(!q.isEmpty() && nums[index] >= nums[q.peekLast()]){
                q.removeLast();
            }
            q.addLast(index);
        }
        ans[j] = nums[q.peek()];
        return ans;
    }
    /**
    * TLE
    * */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int i = 0, j = 0, l = 0, n = nums.length;
        int[] result = new int[n - k + 1];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (; j < n; j++) {
            priorityQueue.add(nums[j]);
            if (j - i + 1 == k) {
                result[l++] = priorityQueue.peek();
                priorityQueue.remove(nums[i++]);
            }
        }
        return result;
    }
}
