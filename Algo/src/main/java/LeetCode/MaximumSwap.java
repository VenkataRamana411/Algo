package LeetCode;

import java.util.HashMap;
import java.util.PriorityQueue;

public class MaximumSwap {
    public static void main(String[] args) {
        //System.out.println(maximumSwap(1998));
        System.out.println(maximumSwap(98368));
    }

    public static int maximumSwap(int num) {
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            int tempIdx = sb.lastIndexOf(String.valueOf(i));
            if (tempIdx != -1) {
                hashMap.put(i, tempIdx);
            }
        }
        int currIdx = 0;
        for (; currIdx < sb.length(); currIdx++) {
            int temp = sb.charAt(currIdx) - '0';
            if (temp != 9) {
                int j = 10;
                while (j-- > temp) {
                    if (hashMap.containsKey(j) && hashMap.get(j) > currIdx && temp != j) {
                        sb.setCharAt(hashMap.get(j), sb.charAt(currIdx));
                        sb.setCharAt(currIdx, (char) (j + '0'));
                        return Integer.parseInt(sb.toString());
                    }
                }
            }
        }
        return num;
    }

    static class Pair {
        int num;
        int lastIdx;

        Pair(int num, int lastIdx) {
            this.num = num;
            this.lastIdx = lastIdx;
        }
    }
}
