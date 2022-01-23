package Array;

import java.util.*;

public class TwoNumberSum {
    public static void main(String[] args) {
        int[] array = {3, 5, -4, 8, 11, 1, -1, 6};
        int target = 10;
        /*
        * Time - O(n) , Space - O(n)
        *
        * */
        System.out.println(Arrays.toString(twoNumberSum(array, target)));
        /*
         * Time - O(n) , Space - O(1)
         *
         * */
        System.out.println(Arrays.toString(twoNumberSumPointerAppraoch(array, target)));
    }

    public static int[] twoNumberSum(int[] array, int targetSum) {
        // Write your code here.
        int[] result = new int[2];

        Map<Integer,Boolean> hmap = new HashMap<>();
        for (int j : array) {
            int temp = targetSum - j;
            if (hmap.containsKey(temp)) {
                result[0] = temp;
                result[1] = j;
                return result;
            } else {
                hmap.put(j, true);
            }
        }
        return new int[0];
    }

    public static int[] twoNumberSumPointerAppraoch(int[] array,int targetSum){
        int[] result = new int[2];
        Arrays.sort(array);
        for(int i = 0 , j = array.length-1 ; i < j ;){
            int temp = array[i]+array[j];
            if(temp == targetSum){
                result[0] = array[i];
                result[1] = array[j];
                return result;
            }else if(temp < targetSum){
                i++;
            }else {
                j--;
            }

        }
        return new int[0];
    }
}

