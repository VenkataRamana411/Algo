package LeetCode;

import java.util.Arrays;

public class HandOfStraights {
    public static void main(String[] args) {
        int[] hand = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        System.out.println(isNStraightHand(hand, 3));
    }

    public static boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        Arrays.sort(hand);
        for (int i = 0; i < hand.length; i++) {
            if (hand[i] != 0) {
                int prev = hand[i], currGroupSize = 1;
                hand[i] = 0;
                for (int j = i + 1; j < hand.length && currGroupSize < groupSize; j++) {
                    if (hand[j] == prev + 1) {
                        prev = hand[j];
                        hand[j] = 0;
                        currGroupSize++;
                    }
                }
                if (currGroupSize < groupSize){
                    return false;
                }
            }
        }
        for (int num : hand) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
}
