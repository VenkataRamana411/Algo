package target;

import java.util.Arrays;

public class MovingZeros {
    public static void main(String[] args) {
        int[] nums = {2, 0, 4, 0, 9, 12, 0};
        moveOptimized(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * TC: O(N)
     * SC: O(1)
     */
    private static void moveOptimized(int[] nums) {
        int pos = 0;
        // Move all non zero elements to start
        for (int num : nums) {
            if (num != 0) {
                nums[pos++] = num;
            }
        }
        //Fill remaining with zeros
        while (pos < nums.length) {
            nums[pos++] = 0;
        }
    }



    /*TC: O(n^2)
     * */

    private static void move(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                int nonZeroIdx = i + 1;
                while (nonZeroIdx < n) {
                    if (nums[nonZeroIdx] != 0) {
                        nums[i] = nums[nonZeroIdx];
                        nums[nonZeroIdx] = 0;
                        break;
                    }
                    nonZeroIdx++;
                }
            }
        }
    }
}
