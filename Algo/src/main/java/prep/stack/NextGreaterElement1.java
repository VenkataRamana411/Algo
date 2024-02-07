package prep.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement1 {
    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }


    /**
     * TC:O(N+M)
     * SC:O(N)
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int j = 0;
        //Loop through superset and construct map with value and it's corresponding NGE
        //HashMap is used as we have unique values
        for (int num : nums2) {
            while (!stack.empty() && num > stack.peek()) {
                hmap.put(stack.pop(), num);
            }
            stack.add(num);
        }
        for (int n : nums1) {
            result[j++] = hmap.getOrDefault(n, -1);
        }
        return result;
    }

    public int[] nextGreaterElement_1(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        int i = 0, j = 0;
        for (int n : nums1) {
            boolean found = false;
            for (; i < nums2.length; i++) {
                if (nums2[i] == n) {
                    found = true;
                }
                if (found) {
                    if (nums2[i] > n) {
                        result[j++] = nums2[i];
                        break;
                    }
                }
            }
            if (i == nums2.length) {
                result[j++] = -1;
            }
            i = 0;
        }
        return result;
    }
}
