package ae.array;

import java.util.Arrays;

public class SmallestDifference {
    public static void main(String[] args) {
        int[] arrayOne = new int[]{-1, 5, 10, 20, 28, 3};
        int[] arrayTwo = new int[]{26, 134, 135, 15, 17};
        System.out.println(Arrays.toString(smallestDifferenceOptimal(arrayOne, arrayTwo)));
    }
/**
* TC: O(n2)
 * SC: O(1)
* */
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        // Write your code here.
        int[] result = new int[2];
        // -1 3  5  10  20  28
        // 15 16 17 26  134 135
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < arrayOne.length ; i++){
            int temp = arrayOne[i];
            for (int j = 0 ; j < arrayTwo.length; j++){
                if (min > Math.abs(temp - arrayTwo[j])){
                    min = Math.abs(temp - arrayTwo[j]);
                    result[0] = temp;
                    result[1] = arrayTwo[j];
                }
            }
        }
        return result;
    }
    public static int[] smallestDifferenceOptimal(int[] arrayOne, int[] arrayTwo) {
        // Write your code here.
        int[] result = new int[2];
        // -1 3  5  10  20  28
        // 15 16 17 26  134 135
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int idxOne = 0, idxTwo = 0 , smallest = Integer.MAX_VALUE , current = Integer.MAX_VALUE;
        while (idxOne < arrayOne.length && idxTwo < arrayTwo.length){
            int temp1 = arrayOne[idxOne];
            int temp2 = arrayTwo[idxTwo];
            if (temp2 > temp1){
                current = temp2 -temp1;
                idxOne++;
            } else if (temp1 > temp2) {
                current = temp1 - temp2;
                idxTwo++;
            }else {
                return new int[]{temp1,temp2};
            }
            if (current < smallest){
                result[0] = temp1;
                result[1] = temp2;
                smallest = current;
            }
        }
        return result;
    }
}
