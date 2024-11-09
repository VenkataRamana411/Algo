package LeetCode;

import java.util.PriorityQueue;

public class KthLargest {
    PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int i = 0 ; i < k ; i++){
            pQueue.add(nums[i]);
        }
    }

    public int add(int val) {
        if(pQueue.size() < k || pQueue.peek() < val){
            pQueue.add(val);
            if (pQueue.size() > k){
                pQueue.remove();
            }
        }
        return pQueue.peek();
    }

    static class helper{
        public static void main(String[] args) {
            KthLargest kthLargest = new KthLargest(3,new int[]{4,5,8,2});
            System.out.println(kthLargest.add(3));
            System.out.println(kthLargest.add(5));
            System.out.println(kthLargest.add(10));
            System.out.println(kthLargest.add(9));
            System.out.println(kthLargest.add(4));
        }
    }
}
