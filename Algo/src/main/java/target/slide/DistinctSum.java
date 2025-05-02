package target.slide;

import java.util.HashSet;
import java.util.Set;

public class DistinctSum {
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3, 4, 6, 7, 7, -1};
        System.out.println(helper(nums, 3));
    }

    private static int helper(int[] nums, int k) {
        int i = 0, j = 0, curr = 0, result = 0;
        Set<Integer> set = new HashSet<>();
        while (j < nums.length) {
            if (set.contains(nums[j])) {
                i = j;
                set.clear();
                curr = nums[j];
            } else {
                curr += nums[j];
                if (j - i + 1 == k) {
                    result = Math.max(result, curr);
                    set.remove(nums[i]);
                    curr -= nums[i++];
                }
            }
            set.add(nums[j]);
            j++;
        }
        return result;
    }
}
