package LeetCode;

import java.util.Arrays;

public class MinPushes {
    public static void main(String[] args) {
        System.out.println(minimumPushes("aabbcdddefgg"));
    }

    public static int minimumPushes(String word) {

        int result = 0;
        int[] freq = new int[27];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        Arrays.sort(freq);
        int pushCost = 1, key = 2;
        for (int i = freq.length - 1; i >= 0; i--) {
            if (freq[i] == 0) {
                return result;
            }
            if (key < 10) {
                key++;
            } else {
                pushCost++;
                key = 3;
            }
            result += freq[i] * pushCost;
        }
        return result;
    }

}
