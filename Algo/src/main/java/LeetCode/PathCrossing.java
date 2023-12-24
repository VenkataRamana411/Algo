package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class PathCrossing {
    public static void main(String[] args) {
        System.out.println(isPathCrossing("SENESSEENWNNWNNENNNNNEESSWN"));
    }

   /* private static boolean helper(String s) {

    }*/

    public static boolean isPathCrossing(String s) {
        List<Integer> list = new ArrayList<>();
        int temp = 0;
        list.add(temp);
        for (int i = 0; i < s.length(); i++) {
            int charTemp = s.charAt(i);
            if (charTemp == 'N') {
                temp += 1;
            } else if (charTemp == 'E') {
                temp += 10;
            } else if (charTemp == 'S') {
                temp -= 1;
            } else {
                temp -= 10;
            }
            if (list.contains(temp)) {
                return true;
            } else {
                list.add(temp);
            }
        }
        return false;
    }
}
