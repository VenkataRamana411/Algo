package target.heap;

import java.util.PriorityQueue;

public class KthLargest {
    public static void main(String[] args) {
        int[] nums = {5, 3, 2, 1, 4};
        System.out.println(kthLargest2(nums, 2));
        System.out.println(kthLargest2(nums, 4));
        //System.out.println(kthLargest2(nums, 9));
    }

    private static int kthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : nums) {
            pq.add(n);
            if (pq.size() > k) {   // Remove unnecessary items on the go
                pq.poll();
            }
        }
        return pq.isEmpty() ? -1 : pq.poll();
    }

    private static int kthLargest2(int[] nums, int k) {
        return helper(nums, 0, nums.length - 1, k);
    }

    private static int helper(int[] nums, int low, int high, int k) {
        int partition = partition(nums, low, high);
        if (partition == k - 1) {
            return nums[partition];
        } else if (partition < k) {
            return helper(nums, partition + 1, high, k);
        } else {
            return helper(nums, low, partition - 1, k);
        }
    }

    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[high], pivotLocation = low;
        for (int i = low; i <= high; i++) {
            if (nums[i] < pivot) {
                int temp = nums[i];
                nums[i] = nums[pivotLocation];
                nums[pivotLocation] = temp;
                pivotLocation++;
            }
        }

        int temp = nums[high];
        nums[high] = nums[pivotLocation];
        nums[pivotLocation] = temp;
        return pivotLocation;
    }
}
