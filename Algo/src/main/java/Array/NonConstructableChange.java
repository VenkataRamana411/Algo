package Array;

import java.util.Arrays;

public class NonConstructableChange {
    public static void main(String[] args) {
        int[] array = {5, 7, 1, 1, 2, 3, 22};
        /*
        * O(nlogn) - Sorting + O(n) loping one time ==> O(nlogn) time & O(1) space
        * */
        System.out.println(nonConstructibleChange(array));
    }

    public static int nonConstructibleChange(int[] coins) {
        Arrays.sort(coins);
        int change = 0;
        for (int coin : coins) {
            if (coin > change + 1) {
                return change + 1;
            } else {
                change += coin;
            }
        }
        return change+1;
    }

}
