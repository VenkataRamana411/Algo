package target.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {3, 7}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> list = new ArrayList<>();
        int[] currentInterval = intervals[0];
        int i = 1;
        while (i < intervals.length) {
            if (currentInterval[1] >= intervals[i][0]) { //Extend currentInterval by merging
                currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]);
            } else {
                list.add(currentInterval);
                currentInterval = intervals[i];
            }
            i++;
        }
        list.add(currentInterval);
        return list.toArray(new int[list.size()][2]);
    }
}
