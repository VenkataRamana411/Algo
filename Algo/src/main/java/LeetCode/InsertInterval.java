package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        System.out.println(Arrays.deepToString(insert(intervals, newInterval)));
        int[][] intervals2 = {{1, 3}, {6, 9}};
        int[] newInterval2 = {2, 5};
        System.out.println(Arrays.deepToString(insert(intervals2, newInterval2)));
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int rangeStart = -1, rangeEnd = -1;
        int i = 0;
        for (; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (rangeStart == -1) {
                if (interval[0] < newInterval[0] && interval[1] > newInterval[0]) {
                    rangeStart = Math.min(interval[0], newInterval[0]);
                    rangeEnd = Math.max(interval[1], newInterval[1]);
                } else {
                    list.add(interval);
                }
            } else {
                if (interval[0] <= newInterval[1] && interval[1] > newInterval[1]) {
                    rangeEnd = Math.max(interval[1], newInterval[1]);
                    i++;
                    break;
                } else if (interval[0] > newInterval[1]) {
                    rangeEnd = Math.max(intervals[i - 1][1], newInterval[i]);
                    break;
                }
            }
        }
      /*  System.out.println(i);
        System.out.println(rangeStart);
        System.out.println(rangeEnd);*/
        if (rangeStart == -1 && rangeEnd == -1) {
            list.add(newInterval);
        } else {
            list.add(new int[]{rangeStart, rangeEnd});
        }

        while (i < intervals.length) {
            list.add(intervals[i++]);
        }
        int[][] result = new int[list.size()][2];
        int k = 0;
        for (int[] interval : list) {
            result[k++] = interval;
        }
        return result;
    }
}
