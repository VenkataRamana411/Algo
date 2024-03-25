package LeetCode;

import java.util.HashMap;

public class ContiguousArray {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,0,0,1,1,0,1,1};
        System.out.println(findMaxLength(nums));
    }

    public static int findMaxLength(int[] nums) {
        int sum = 0, count = 0;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        hmap.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                sum--;
            } else {
                sum++;
            }
            if (hmap.containsKey(sum)) {
                count = Math.max(count, i-hmap.get(sum));
            } else {
                hmap.put(sum, i);
            }
        }
        return count;
    }
}
