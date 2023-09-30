package ks.recursion.sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 6, 8, 3, 456, 57, 6, 8};
        System.out.println(Arrays.toString(mergeS(nums)));
        mergeSortInPlace(nums, 0, nums.length);
        System.out.println(Arrays.toString(nums));
    }

    private static int[] mergeS(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int mid = arr.length / 2;
        int[] left = mergeS(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeS(Arrays.copyOfRange(arr, mid, arr.length));
        return mergeHelper(left, right);
    }

    private static int[] mergeHelper(int[] first, int[] second) {
        int[] result = new int[first.length + second.length];
        int i = 0, j = 0, k = 0;
        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                result[k++] = first[i++];
            } else {
                result[k++] = second[j++];
            }
        }
        while (i < first.length) {
            result[k++] = first[i++];
        }
        while (j < second.length) {
            result[k++] = second[j++];
        }
        return result;
    }

    private static void mergeSortInPlace(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSortInPlace(arr, low, mid);
        mergeSortInPlace(arr, mid + 1, high);
        mergeSortInPlaceHelper(arr, low, mid, high);
    }

    private static void mergeSortInPlaceHelper(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid;
        while (left < mid && right < high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }
        while (left < mid) {
            temp.add(arr[left]);
            left++;
        }
        while (right < high) {
            temp.add(arr[right]);
            right++;
        }
        for (int i = low; i < high; i++) {
            arr[i] = temp.get(i - low);
        }
    }
}
