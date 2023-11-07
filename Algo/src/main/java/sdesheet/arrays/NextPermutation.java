package sdesheet.arrays;

import java.util.Arrays;
import java.util.Collections;

public class NextPermutation {
    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3};
        helper(input);
        System.out.println(Arrays.toString(input));
    }

    private static void helper(int[] input) {
        int index = -1;
        int arrayLength = input.length;
        for (int i = arrayLength - 2; i >= 0; i--) {
            if (input[i] < input[i + 1]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            for (int i = 0; i < arrayLength / 2; i++) {
                int temp = input[i];
                input[i] = input[arrayLength - i - 1];
                input[arrayLength - i - 1] = temp;
            }
            return;
        }
        for (int i = arrayLength - 1; i > index; i--) {
            if (input[i] > input[index]) {
                int temp = input[index];
                input[index] = input[i];
                input[i] = temp;
                break;
            }
        }
        for (int i = index + 1, j = arrayLength - 1; i < j; i++, j--) {
            int temp = input[j];
            input[j] = input[i];
            input[i] = temp;
        }
        //Arrays.sort(input, index + 1, input.length);
    }
}
