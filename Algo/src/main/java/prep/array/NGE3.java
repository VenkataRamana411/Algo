package prep.array;

public class NGE3 {
    /**
     * Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive integer exists, return -1.
     * <p>
     * Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does not fit in 32-bit integer, return -1.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: n = 12
     * Output: 21
     * Example 2:
     * <p>
     * Input: n = 21
     * Output: -1
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= n <= 231 - 1
     */
    public static void main(String[] args) {
        System.out.println(nextGreaterElement(6537421));
    }

    /**
     * TC: O(N)
     * SC: O(N)
     * */
    public static int nextGreaterElement(int n) {
        char[] nums = String.valueOf(n).toCharArray();
        int i = nums.length - 2;
        StringBuilder result = new StringBuilder();
        //Iterate from right to left till you find decreasing sequence
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        // i -> 3
        //If there is no decreasing sequence there is no possibility of a greater element
        if (i == -1) {
            return -1;
        }
        //From right find an integer which is greater than inflection to swap
        // k -> 4
        int k = nums.length - 1;
        while (nums[k] <= nums[i]) {
            k--;
        }
        swap(nums, i, k); // 6547321
        //654
        for (int j = 0 ; j <= i ; j++){
            result.append(nums[j]);
        }
        //6541237
        for (int j = nums.length-1 ; j > i ; j--){
            result.append(nums[j]);
        }
        long ans = Long.parseLong(result.toString());
        return (ans > Integer.MAX_VALUE ? -1 : (int) ans);
    }

    private static void swap(char[] nums, int i, int k) {
        char temp = nums[k];
        nums[k] = nums[i];
        nums[i] = temp;
    }
}
