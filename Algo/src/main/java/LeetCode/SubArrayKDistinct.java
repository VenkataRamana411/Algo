package LeetCode;

import java.util.*;

public class SubArrayKDistinct {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 3};
        System.out.println(subarraysWithKDistinct(nums, 2));
    }

    public static int subarraysWithKDistinct(int[] nums, int k) {
        return slidingWindowAtMost(nums, k) - slidingWindowAtMost(nums, k - 1);
    }
    public static int slidingWindowAtMost(int[] nums, int k) {
        int result = 0, left = 0;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for (int right = 0; right < nums.length; right++) {
            hmap.put(nums[right], hmap.getOrDefault(nums[right], 0) + 1);
            while (hmap.size() > k) {
                hmap.put(nums[left], hmap.get(nums[left]) - 1);
                if (hmap.get(nums[left]) == 0) {
                    hmap.remove(nums[left]);
                }
                left++;
            }
            result += (right - left + 1);
        }
        return result;
    }
}
