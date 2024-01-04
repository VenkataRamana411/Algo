package prep.array;

import java.util.Arrays;

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 1};
        System.out.println(missingNumber3(nums));
    }


    /**
     * TC:O(N)
     * SC: O(1)
     * */
    public static int missingNumberOptimal(int[] nums) {
        //Applying XOR with every number in the range of [0..N] will give us result as even numbers of times will be cancelled
        int result = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            result = result ^ i ^ nums[i];
        }
        // To include N we need to do it
        return result ^ i;
    }

    public static int missingNumber2(int[] nums) {
        int currentSum = 0;
        for (int n : nums) {
            currentSum += n;
        }
        int expectedSum = (nums.length)*(nums.length+1)/2;
        return expectedSum-currentSum;
    }

    public static int missingNumber3(int[] nums) {
        int currentSum = nums.length;
        for (int i = 0 ; i < nums.length ; i++) {
            currentSum += i-nums[i];
            // 3+0-2=1
            // 1+1-0=2
            // 2+2-1=3
        }
        return currentSum;
    }

    /**
     * TC:O(NlogN)
     * SC:(1)
     */
    public static int missingNumber(int[] nums) {
        System.out.println(1 ^ 3);
        System.out.println(1 ^ 2);
        System.out.println(1 ^ 20 ^ 21);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        return -1;
    }


}
