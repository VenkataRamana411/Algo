package prep.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = new int[]{38,27,43,3,9,82,10};
        System.out.println(Arrays.toString(helper(nums)));
    }

    private static void inPlaceMerge(int[] nums,int left,int right){
        if (left <= right){
            int mid = (left + right) / 2;
            //left
            inPlaceMerge(nums,left,mid);
            //right
            inPlaceMerge(nums,mid+1,right);
            //merge

        }
    }
    private static void inPlaceConquer(){
        System.out.println("TODO");
    }

    private static int[] helper(int[] nums){
        if (nums.length == 1){
            return nums;
        }
        int mid = nums.length / 2;
        int[] left = helper(Arrays.copyOfRange(nums,0,mid));
        int[] right = helper(Arrays.copyOfRange(nums,mid,nums.length));
        return conquerHelper(left,right);
    }

    private static int[] conquerHelper(int[] left,int[] right){
        int[] result = new int[left.length+right.length];
        int i = 0 , j = 0 , k = 0;
        while (i < left.length && j < right.length){
            if (left[i] < right[j]){
                result[k++] = left[i++];
            }else {
                result[k++] = right[j++];
            }
        }
        while (i < left.length){
            result[k++] = left[i++];
        }
        while (j < right.length){
            result[k++] = right[j++];
        }
        return result;
    }
}
