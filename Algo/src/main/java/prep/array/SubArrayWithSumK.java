package prep.array;

import java.util.HashMap;

public class SubArrayWithSumK {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, -3, 1, 1, 1, 4, 2, -3};
        int count = 0;
        //System.out.println(helper(nums, 2, 0, 0, 0));
        System.out.println(optimalHelper(nums, 6));

    }

    private static int optimalHelper(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            /**
             * Prefix sum at index i will always equal to (sum-target) + target
             * */
            if (prefixMap.containsKey(sum - k)) {
                count += prefixMap.get(sum - k);
            }
            prefixMap.put(sum, prefixMap.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    private static int helper1(int[] nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum == target) {
                    count++;
                }
            }
        }
        return count;
    }
}
