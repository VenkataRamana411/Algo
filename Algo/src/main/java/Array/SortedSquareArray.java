package Array;
import java.util.*;

public class SortedSquareArray {
    public static void main(String[] args) {

        int[] array1 = {1, 2, 3, 5, 6, 8, 9};
        System.out.println(Arrays.toString(sortedSquaredArray(array1)));
        //int[] array2 = {-50, -13, -2, -1, 0, 0, 1, 1, 2, 3, 19, 20};
        int[] array2 = {1, 4, 9, 25, 36, 64, 81};
        System.out.println(Arrays.toString(sortedSquaredArrayOptimal(array2)));

    }

    public static int[] sortedSquaredArray(int[] array) {
        // Write your code here.
        int[] temp = new int[array.length];
        for(int i = 0 , j = 0 ; i < array.length ; i++ ){
            temp[j++] = array[i] * array[i];
        }
        return temp;
    }

    public static int[] sortedSquaredArrayOptimal(int[] array) {
        // Write your code here.  [-10, -5, 0, 5, 15]
        int[] temp = new int[array.length];
        int left = 0 , right = array.length-1 , max = 0;
        for(int i = array.length-1 ; i >= 0; i-- ){
            if(Math.abs(array[right]) > Math.abs(array[left])){
                max = Math.abs(array[right]);
                --right;
            }else {
                max = Math.abs(array[left]);
                ++left;
            }
            temp[i] = max * max;
        }
        return temp;
    }
}
