package prep.array;

import java.util.Arrays;

public class WiggleSort {
    public static void main(String[] args) {
        int[] nums = new int[]{3,5,2,1,6,4};
        wiggleHelper(nums);
        System.out.println(Arrays.toString(nums));
    }
    /**
     * TC: O(n)
     * SC: O(1)
    * */
    private static void wiggleHelper(int[] nums){
        // {3,5,2,1,6,4}
        // {3,5,1,6,2,4}

        // Every odd index is a peak
        for (int i = 0 ; i < nums.length-1 ; i++){
            if (i % 2 == 0){
                if (nums[i] > nums[i+1]){
                    swap(nums, i);
                }
            }else {
                if (nums[i] < nums[i+1]){
                    swap(nums, i);
                }
            }
        }
    }

    private static void swap(int[] nums, int i) {
        int temp = nums[i +1];
        nums[i +1] = nums[i];
        nums[i] = temp;
    }

}
