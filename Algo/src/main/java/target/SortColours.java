package target;

import java.util.Arrays;

public class SortColours {
    public static void main(String[] args) {
        int[] nums = {2, 1, 2, 0, 1, 0, 1, 0, 1};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * TC: O(N)
     * SC: O(1)
     * Sort left and right portions so that middle can be sorted by itself
    * */
    private static void sort(int[] nums) {
        int n = nums.length;
        int currIdx = 0, zeroIdx = 0, twoIdx = n - 1;
        while (currIdx <= twoIdx) {
            if (nums[currIdx] == 2) { //Don't increment currIdx as there can ba chance of 1 being unprocessed
                nums[currIdx] = nums[twoIdx];
                nums[twoIdx--] = 2;
            } else if (nums[currIdx] == 0) {
                nums[currIdx] = nums[zeroIdx];
                nums[zeroIdx++] = 0;
                currIdx++;
            } else {
                currIdx++;
            }
        }
    }
}
