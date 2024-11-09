package LeetCode;

import java.util.*;

public class SortJumbled {
    public static void main(String[] args) {
        int[] mapping = {8, 9, 4, 0, 2, 1, 3, 5, 7, 6};
        int[] nums = {991, 338, 38};
        System.out.println(Arrays.toString(sortJumbled(mapping, nums)));
    }

    public static int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        List<int[]> pairList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int temp = nums[i], mappedNumber = 0, place = 1;
            if (temp == 0) {
                pairList.add(new int[]{mapping[0], i});
                continue;
            }
            while (temp != 0) {
                mappedNumber = place * mapping[temp % 10] + mappedNumber;
                place *= 10;
                temp /= 10;
            }
            pairList.add(new int[]{mappedNumber, i});
        }
        pairList.sort((a, b) -> a[0] - b[0]);
        int[] answer = new int[nums.length];
        for (int i = 0; i < pairList.size(); i++) {
            answer[i] = nums[pairList.get(i)[1]];
        }
        return answer;
    }
}
