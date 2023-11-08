package LeetCode;

import java.util.Arrays;

public class EliminateMaximum {
    public static void main(String[] args) {
        int[] distance = new int[]{4,2,3};
        int[] speed = new int[]{2,1,1};
        System.out.println(eliminateMaximum(distance,speed));
    }

    private static int eliminateMaximum(int[] dist, int[] speed) {
        int result = 1;
        int[] arrivals = new int[dist.length];
        for (int i = 0; i < dist.length; i++) {
            arrivals[i] = dist[i] / speed[i];
        }
        Arrays.sort(arrivals);
        for (int i = 1; i < arrivals.length; i++) {
            if (arrivals[i] > arrivals[i - 1]) {
                result++;
            } else {
                break;
            }
        }
        return result;
    }
}
