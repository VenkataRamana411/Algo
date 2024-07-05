package striver.bs;

import java.util.Arrays;

public class FindOccurrence {
    public static void main(String[] args) {
        int[] nums = {2, 4, 6, 8, 8, 8, 11, 13};
        System.out.println(Arrays.toString(helperWithBounds(nums, 8)));
        System.out.println(Arrays.toString(helperWithoutBounds(nums, 8)));
    }

    /**
     * TC: 2 * O(log N)
     * SC: O(1)
     */

    private static int[] helperWithBounds(int[] nums, int target) {
        int first = -1, last = -1;
        int low = 0, high = nums.length - 1, mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] >= target) {
                first = mid;
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        low = 0;
        high = nums.length - 1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] > target) {
                last = mid;
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        if (first == -1 || nums[first] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{first, last - 1};
    }

    private static int[] helperWithoutBounds(int[] nums, int target) {
        int first = firstOccurrence(nums, target);
        if (first == -1){
            return new int[]{-1, -1};
        }
        int last = lastOccurrence(nums, target);
        return new int[]{first, last};
    }

    private static int lastOccurrence(int[] nums, int target) {
        int last = -1;
        int low = 0, high = nums.length - 1, mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] == target) {
                last = mid;
                low = mid + 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return last;
    }

    private static int firstOccurrence(int[] nums, int target) {
        int first = -1;
        int low = 0, high = nums.length - 1, mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] == target) {
                first = mid;
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return first;
    }
}
