package target.intervals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        List<Integer[]> intervals = new ArrayList<>();
        intervals.add(new Integer[]{1, 3});
        intervals.add(new Integer[]{6, 9});
        List<Integer[]> list = insertIntervalOptimized(intervals, new Integer[]{2, 5});
        for (Integer[] interval : list) {
            System.out.println("[" + interval[0] + "," + interval[1] + "]");
        }
        System.out.println("------------");
        //System.out.println(canAttendAllMeetings(new int[][]{{10, 12}, {6, 9}, {13, 15}}));
        intervals.clear();
        intervals.add(new Integer[]{1, 3});
        intervals.add(new Integer[]{8, 15});
        list = insertIntervalOptimized(intervals, new Integer[]{6, 7});
        for (Integer[] interval : list) {
            System.out.println("[" + interval[0] + "," + interval[1] + "]");
        }
        System.out.println("------------");

        intervals.clear();
        intervals.add(new Integer[]{1, 3});
        intervals.add(new Integer[]{5, 8});
        list = insertIntervalOptimized(intervals, new Integer[]{6, 7});
        for (Integer[] interval : list) {
            System.out.println("[" + interval[0] + "," + interval[1] + "]");
        }
        System.out.println("------------");
    }

    private static List<Integer[]> insertIntervalOptimized(List<Integer[]> intervals, Integer[] newInterval) {
        List<Integer[]> result = new ArrayList<>();
        intervals.sort(Comparator.comparing(a -> a[0]));
        int i = 0, n = intervals.size();
        while (i < n && intervals.get(i)[1] < newInterval[0]){
            result.add(intervals.get(i));
            i++;
        }
        while (i < n && intervals.get(i)[0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals.get(i)[0],newInterval[0]);
            newInterval[1] = Math.max(intervals.get(i)[1],newInterval[1]);
            i++;
        }
        result.add(newInterval);
        while (i < n){
            result.add(intervals.get(i));
            i++;
        }
        return result;
    }

    private static List<Integer[]> insertInterval(List<Integer[]> intervals, Integer[] newInterval) {
        List<Integer[]> result = new ArrayList<>();
        intervals.sort(Comparator.comparing(a -> a[0]));
        //Edge case to add at start or end
        if (intervals.get(intervals.size() - 1)[1] < newInterval[0]) {
            result.addAll(intervals);
            result.add(newInterval);
            return intervals;
        } else if (intervals.get(0)[0] > newInterval[1]) {
            result.add(newInterval);
            result.addAll(intervals);
            return result;
        }
        int i = 0;
        for (; i < intervals.size(); i++) {
            Integer[] curr = intervals.get(i);
            if (curr[1] > newInterval[0]) {
                if (curr[1] < newInterval[1]) {
                    curr[1] = newInterval[1];
                }
                if (curr[0] > newInterval[0]) {
                    curr[0] = newInterval[0];
                }
                result.add(curr);
                i++;
                break;
            }else {
                result.add(curr);
            }
        }
        while (i < intervals.size()) {
            result.add(intervals.get(i++));
        }
        return result;
    }

}
