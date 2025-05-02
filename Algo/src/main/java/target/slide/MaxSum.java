package target.slide;

public class MaxSum {
    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 1, 3, 2};
        System.out.println(helper(nums, 3));
    }

    private static int helper(int[] nums, int k) {
        int result = 0;
        int i = 0, j = 0, temp = 0;
        for (; j < nums.length; j++) {
            temp += nums[j];
            if (j - i + 1 == k) { //Fixed length window
                result = Math.max(result, temp);
                temp -= nums[i++];
            }
        }
        return result;
    }
}
