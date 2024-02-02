package LeetCode;

import java.util.Arrays;

public class DivideArray {
    public static void main(String[] args) {
        int[] nums = {1,3,4,8,7,9,3,5,1};
        System.out.println(Arrays.deepToString(divideArray(nums, 3)));
    }

    public static int[][] divideArray(int[] nums, int k) {
        int n = nums.length, rows = n/3;
        int[][] result = new int[rows][3];
        Arrays.sort(nums);
        int counter = 0;
        for (int i = 0 ; i < rows; i++){
            int j = 0 , prev = nums[counter];
            while (j < 3){
                if (nums[counter] <= (prev+k)){
                    result[i][j++] = nums[counter++];
                }else {
                    return new int[0][];
                }
            }
        }
        return result;
    }
}
