package target.slide;

public class MaxSumRotation {
    public static void main(String[] args) {
        int[] nums = {2, 11, 4, 5, 3, 9, 2};
        System.out.println(helper(nums, 3));
        System.out.println(helper2(nums, 3));
    }

    private static int helper(int[] nums, int k) {
        int result = 0, n = nums.length;
        int i = n - k, j = n - k, temp = 0;
        for (; j < n + k; j++) {
            temp += nums[j % n]; //Module Rotation
            if (j - i + 1 == k) {
                result = Math.max(result, temp);
                temp -= nums[i % n];
                i++;
            }
        }
        return result;
    }

    private static int helper2(int[] nums, int k) {
        int result = 0, n = nums.length;
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        int i = 0, j = 0, temp = 0;
        for (; j < n; j++) {
            temp += nums[j];
            if (j - i + 1 == n - k) { // This will ensure only k elements will be left
                result = Math.max(result, total - temp); // Take total and remove from current sum will give us actual window size
                temp -= nums[i++];
            }
        }
        return result;
    }

}
