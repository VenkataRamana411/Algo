package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveZeros {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroesOptimal(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (num != 0) {
                list.add(num);
            }
        }
        int i = 0, j = 0;
        for (; i < list.size(); i++) {
            nums[j++] = list.get(i);
        }
        Arrays.fill(nums, j, nums.length, 0);
    }

    public static void moveZeroesOptimal(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
                k++;
            }
        }
    }
    public static void moveZeroesOptimal2(int[] nums) {
        int fast = 0;
        int slow = 0;
        int len = nums.length;
        while (fast < len) {
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        while (slow < len) {
            nums[slow++] = 0;
        }
    }


}
