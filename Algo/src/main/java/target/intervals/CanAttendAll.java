package target.intervals;

import java.util.*;

public class CanAttendAll {
    public static void main(String[] args) {
        System.out.println(canAttendAllMeetings(new int[][]{{1, 5}, {3, 9}, {6, 8}}));
        System.out.println(canAttendAllMeetings(new int[][]{{10, 12}, {6, 9}, {13, 15}}));
    }

    private static boolean canAttendAllMeetings(int[][] meetings) {
        Arrays.sort(meetings, (x, y) -> Integer.compare(x[0], y[0])); //Sorting 2D Array
        //Arrays.sort(meetings, (x, y) -> x[0] - y[0]);
//        List<Integer[]> list = new ArrayList<>();
//        list.sort((o1, o2) -> o1[0].compareTo(o2[0]));
        for (int i = 1; i < meetings.length; i++) {
            if (meetings[i][0] < meetings[i - 1][1]) {
                return false;
            }
        }
        return true;
    }

}
