package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoodCount {
    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 3, 2, 2, 4};
        System.out.println(countGood(nums, 2));
        int[] nums1 = {1, 1, 1, 1, 1};
        System.out.println(countGood(nums1, 10));
        System.out.println(countGood(new int[]{}, 10));
    }

    public static long countGood(int[] nums, int k) {

        int n = nums.length, leftIdx = 0, rightIdx = 1;
        long result = 0, currCount = 0;
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        HashMap<Integer, Long> countMap = new HashMap<>();
        freqMap.put(nums[0], 1);
        while (leftIdx < rightIdx && rightIdx < n) {
            int rightIdxElement = nums[rightIdx];
            int currFreq = freqMap.getOrDefault(rightIdxElement, 0) + 1;
            freqMap.put(rightIdxElement, currFreq);
            if (currFreq >= 2) {
                long count = ((long) currFreq * (currFreq - 1)) / 2;
                currCount += count - countMap.getOrDefault(rightIdxElement, 0L);
                countMap.put(rightIdxElement, count);
                if (currCount >= k) {
                    result += n - rightIdx;
                    while (leftIdx < rightIdx) {
                        int leftIdxElement = nums[leftIdx];
                        Integer leftValueCount = freqMap.get(leftIdxElement);
                        if (leftValueCount >= 2) {
                            leftValueCount--;
                            currCount -= leftValueCount;
                            freqMap.put(leftIdxElement, leftValueCount);
                            long leftCount = ((long) leftValueCount * (leftValueCount - 1)) / 2;
                            countMap.put(leftIdxElement, leftCount);
                        } else {
                            freqMap.remove(leftIdxElement);
                        }
                        leftIdx++;
                        if (currCount >= k) {
                            result++;
                        } else {
                            break;
                        }
                    }
                }
            }
            rightIdx++;
        }
        return result;
    }
}
