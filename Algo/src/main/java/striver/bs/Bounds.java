package striver.bs;

public class Bounds {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 6, 7, 8, 9, 10, 11};
        System.out.println(lowerBound(nums, 5));
        System.out.println(upperBound(nums, 6));
        int[] nums2 = {10, 20, 25, 30, 40};
        System.out.println(floor(nums2, 24));
        System.out.println(ceil(nums2, 24));
    }

    /**
     * lowerBound = arr[index] >= n
     */
    private static int lowerBound(int[] nums, int n) {
        int ans = nums.length - 1;
        int low = 0, high = nums.length - 1, mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] >= n) {
                high = mid - 1;
                ans = mid;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    /**
     * upperBound = arr[index] > n
     */
    private static int upperBound(int[] nums, int n) {
        int ans = nums.length - 1;
        int low = 0, high = nums.length - 1, mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] > n) {
                high = mid - 1;
                ans = mid;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    /**
     * floor =  largest element <= x
     */
    private static int floor(int[] nums, int target) {
        int ans = 0;
        int low = 0, high = nums.length - 1, mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] == target) {
                return nums[mid];
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                ans = nums[mid];
                low = mid + 1;
            }
        }
        return ans;
    }

    /**
     * Ceil =  Smallest element >= x
     */
    private static int ceil(int[] nums, int target) {
        int ans = 0;
        int low = 0, high = nums.length - 1, mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] == target) {
                return nums[mid];
            } else if (nums[mid] > target) {
                high = mid - 1;
                ans = nums[mid];
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

}
