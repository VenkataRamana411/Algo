package ae.array;

import java.util.Arrays;

public class ProductArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(arrayOfProducts(new int[]{1, 8, 6, 2, 4})));
        System.out.println(Arrays.toString(arrayOfProducts2(new int[]{1, 8, 6, 2, 4})));
    }

    public static int[] arrayOfProducts(int[] array) {
        int[] result = new int[array.length];
        int prev = 1;
        for(int i = 0 ; i < array.length ; i++){
            result[i] = prev;
            prev = prev * array[i];
        }
        prev = 1;
        for (int i = array.length-1; i >= 0 ; i--){
            result[i] = prev * result[i];
            prev = prev * array[i];
        }
        return result;
    }

    public static int[] arrayOfProducts2(int[] array) {
        int[] result = new int[array.length];
        long total = 1L;
        for (int j : array) {
            total *= j;
        }
        for (int i = array.length-1; i >= 0 ; i--){
            result[i] = (int) (total / array[i]);
        }
        return result;
    }
}
