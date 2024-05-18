package LeetCode;

import java.util.Arrays;

public class MaximumHappinessSum {
    public static void main(String[] args) {
        System.out.println(maximumHappinessSum(new int[]{1,2,3},2));
    }

    public static long maximumHappinessSum(int[] happiness, int k) {
        long result = 0;
        Arrays.sort(happiness);
        int pick = happiness.length - 1, counter = 0;
        while (k > 0) {
            int curr = happiness[pick--]-counter;
            if (curr < 1){
                break;
            }
            result += curr;
            counter++;
            k--;
        }
        return result;
    }
}
