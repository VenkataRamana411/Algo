package ae.array;

import java.util.Arrays;

public class SortedSquareArray {
    public static void main(String[] args) {
        int[] input = new int[]{-50,-9,-6,-2,0,4,6,8,10,24};
        System.out.println(Arrays.toString(helper(input)));
    }
    private static int[] helper(int[] input){
        int[] output = new int[input.length];
        int l = 0;
        int r = input.length-1;
        int index = input.length-1;
        for (int i = 0 ; i < input.length-1 ; i++){
            if (Math.abs(input[l]) > Math.abs(input[r])){
                output[index--] = input[l] * input[l];
                l++;
            }else {
                output[index--] = input[r] * input[r];
                r--;
            }
        }
        return output;
    }
}
