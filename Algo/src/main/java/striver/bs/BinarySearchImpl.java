package striver.bs;

public class BinarySearchImpl {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 6, 7, 9, 12, 16, 17};
        int target = 65;
        System.out.println(binarySearchIterative(nums, target));
    }

    private static int binarySearchIterative(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] == target) {
                System.out.println("Element Found");
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
