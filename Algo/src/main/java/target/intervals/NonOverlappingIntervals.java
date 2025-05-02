package target.intervals;

import java.util.Arrays;

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        System.out.println(eraseOverlapIntervals(new int[][]{{1, 100}, {11, 22}, {1, 11}, {2, 12}}));
    }

    /**
     * TC: O(N)
     * Sort and Greedy
    * */
    public static int eraseOverlapIntervals(int[][] intervals) {
        int result = 0;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int j = 0;
        for (int i = 1; i < intervals.length; i++) {
            //Check if current pair start is well below end of last pair
            if (intervals[i][0] < intervals[j][1]) {
                result++;
            } else {
                j = i;
            }
        }
        return result;
    }
}
