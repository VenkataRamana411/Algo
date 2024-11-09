package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

public class MinGroups {
    public static void main(String[] args) {
        int[][] intervals = {{5,10},{6,8},{1,5},{2,3},{1,10}};
        System.out.println(minGroups(intervals));
    }

    public static int minGroups(int[][] intervals) {
        int result = 0;
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] > o2[0]){
                return 1;
            } else if (o1[0] == o2[0]) {
                if (o1[1] > o2[1]){
                    return 1;
                }
            }
            return -1;
        });
        return result;
    }
}
