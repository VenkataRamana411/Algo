package prep.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargest {
    /**
     * 215. Kth Largest Element in an Array
     * Attempted
     * Medium
     * Given an integer array nums and an integer k, return the kth largest element in the array.
     *
     * Note that it is the kth largest element in the sorted order, not the kth distinct element.
     *
     * Can you solve it without sorting?
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [3,2,1,5,6,4], k = 2
     * Output: 5
     * Example 2:
     *
     * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
     * Output: 4
     *
     *
     * Constraints:
     *
     * 1 <= k <= nums.length <= 105
     * -104 <= nums[i] <= 104
     *
     * Seen this question in a real interview before?
     * 1/4
     * Yes
     * No
     * Accepted
     * 2.2M
     * Submissions
     * 3.3M
     * Acceptance Rate
     * 66.8%
    * */
    public static void main(String[] args) {
        System.out.println(findKthLargestWithHeap(new int[]{3,2,1,5,6,4},2));
    }

    /**
     * TC: O(NlogK)
     * SC: O(K)
    * */
    public static int findKthLargestWithHeap(int[] nums, int k){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int n : nums){
            priorityQueue.add(n);
            //Poll element if size is more than k
            if (priorityQueue.size() > k){
                priorityQueue.poll();
            }
        }
        //Return the top element
        return priorityQueue.poll();
    }

    /**
     * TC: O(NlogN)
     * SC: O(1)
     * */
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
        /*for(int i = 0 ; i < nums.length ; i++){
            for(int j = i+1; j < nums.length ; j++){
                if(nums[i] > nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums[nums.length-k];*/
    }
}
