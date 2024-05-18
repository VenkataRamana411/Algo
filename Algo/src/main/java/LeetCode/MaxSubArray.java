package LeetCode;

import java.util.HashMap;

public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,1,2,1,2};
        //int[] nums = {1, 2, 2, 1, 3};
        System.out.println(maxSubarrayLength(nums, 1));
    }

    public static int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int longestArray = 0, left = 0, right = 0;
        for (; right < nums.length; right++) {
            int temp = nums[right];
            if (hmap.containsKey(temp)) {
                if (hmap.get(temp) >= k) {
                    longestArray = Math.max(right - left, longestArray);
                    while (left < nums.length) {
                        if (hmap.get(nums[left]) == 1) {
                            hmap.remove(nums[left]);
                        } else {
                            hmap.put(nums[left], hmap.get(nums[left]) - 1);
                        }
                        if (nums[left++] == temp) {
                            break;
                        }
                    }
                } else {
                    hmap.put(temp, hmap.get(temp) + 1);
                }
            } else {
                hmap.put(temp, 1);
            }
        }
        return Math.max(right - left, longestArray);
    }
}
