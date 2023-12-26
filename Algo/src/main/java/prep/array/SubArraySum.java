package prep.array;

import java.util.ArrayList;
import java.util.List;

public class SubArraySum {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 2, -3, 1, 6};
        System.out.println(subArrayWithSumZero(nums));
        System.out.println(subArrayWithSumZeroOptimized(nums));
    }

    /**
     * TC: O(n2)
     * SC: O(1)
     * <p>
     * 4 6 3 4 10
     * 10 6 4 7  6
     */
    private static boolean subArrayWithSumZero(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
    * TC: O(n)
     * SC: O(1)
    * */
    private static boolean subArrayWithSumZeroOptimized(int[] nums) {
        List<Integer> prefixSum = new ArrayList<>();
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp += nums[i];
            // If prefix sum is repeated or 0 then there will be subArray with sum 0
            //4, 2, -3, 1, 6
            //4  6   3  4   10
            if (temp == 0 || prefixSum.contains(temp)) {
                return true;
            }
            prefixSum.add(temp);
        }
        return false;
    }
}
