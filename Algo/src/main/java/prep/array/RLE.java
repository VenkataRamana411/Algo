package prep.array;

import java.util.Arrays;

public class RLE {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        System.out.println(Arrays.toString(decompressRLElist(nums)));
    }

    public static int[] decompressRLElist(int[] nums) {
        int arrSize = 0;
        for(int i = 0 ; i < nums.length ; i+=2){
            arrSize += nums[i];
        }
        int[] result = new int[arrSize];
        int j = 0;
        for(int i = 0 ; i < nums.length; i+=2){
            Arrays.fill(result,j,j+nums[i],nums[i+1]);
            j += nums[i];
        }
        return result;
    }
}
