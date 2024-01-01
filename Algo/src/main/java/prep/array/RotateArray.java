package prep.array;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        //rotate(nums, k);
        //System.out.println(Arrays.toString(nums));
        rotateInPlace(nums, k);
        //rotate3(new int[]{-1,-100,3,99},2);
    }

    /**
     * TC: O(n * 2^n)
     * SC: O(N)
     * TLE
     */
    public static void rotate(int[] nums, int k) {
        if (k == 0) {
            return;
        }
        int temp = nums[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            int temp2 = nums[i];
            nums[i] = temp;
            temp = temp2;
        }
        rotate(nums, k - 1);
    }

//[1, 2, 3, 4, 5, 6, 7]
//[5, 6, 7, 1, 2, 3, 4]
    /*
     * currIndex = currIndex + 3 % 7;
     * */

    /**
     * TC: O(N)
     * SC: O(N)
     */
    public static void rotate2(int[] nums, int k) {
        int n = nums.length;
        int[] result = Arrays.copyOfRange(nums, 0, n);
        //int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int targetIndex = (i + k) % n;
            nums[targetIndex] = result[i];
        }
        System.out.println(Arrays.toString(nums));
    }


    /**
    *
     * TC: O(N) + O(N)
     * SC: O(1)
    * */
    public static void rotateInPlace(int[] nums,int k){
        int n = nums.length;
        if( n == 0 || k <= 0 || k % n == 0){
            return;
        }
        k = k % n ;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }
    private static void reverse(int[] nums,int from,int to){
        while (from < to){
            int temp = nums[from];
            nums[from] = nums[to];
            nums[to] = temp;
            from++;
            to--;
        }
        System.out.println(Arrays.toString(nums));
    }


    public static void rotate3(int[] nums, int k) {
        int n = nums.length, currIdx = 0, count = 0, temp = nums[0];
        while (count < n) {
            int targetIndex = (currIdx + k) % n;
            int temp2 = nums[targetIndex];
            nums[targetIndex] = temp;
            temp = temp2;
            currIdx = targetIndex;
            count++;
        }
        System.out.println(Arrays.toString(nums));
    }

    private static int helper(int[] nums, int targetIdx, int element) {
        int temp = nums[targetIdx];
        nums[targetIdx] = element;
        return temp;
    }
}
