package ae.dp;

import java.util.Arrays;

public class MinNumberOfCoinsForChange {
    public static void main(String[] args) {
        System.out.println(minNumberOfCoinsForChange(7,new int[]{1,5,10}));
    }

    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        // Write your code here.
        int tempChange = n , count = 0;
        Arrays.sort(denoms);
        for (int i = denoms.length-1 ; i >= 0 ; i--){
            if (denoms[i] <= n){
                count += n / denoms[i];
                n = n % denoms[i];
            }
        }
        return count;
    }
}
