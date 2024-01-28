package prep.array.assign;

import java.util.Arrays;

public class NextGreaterElement {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        int i = 0, j = 0;
        for(int n : nums1){
            boolean found = false;
            for(; i < nums2.length ; i++){
                if(nums2[i] == n){
                    found = true;
                }
                if(found){
                    if(nums2[i] > n){
                        result[j++] = nums2[i];
                        break;
                    }
                }
            }
            if(i == nums2.length){
                result[j++] = -1;
            }
            i = 0;
        }
        return result;
    }
}
