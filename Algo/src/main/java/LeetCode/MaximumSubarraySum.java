package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MaximumSubarraySum {
//            15
//            1
//            17
//            24
    public static void main(String[] args) {
        System.out.println(maximumSubarraySum(new int[]{1, 5, 4, 2, 9, 9, 9}, 3));
        System.out.println(maximumSubarraySum(new int[]{1, 1, 1, 1, 1, 1, 1}, 1));
        System.out.println(maximumSubarraySum(new int[]{11, 11, 7, 2, 9, 4, 17, 1}, 1));
        System.out.println(maximumSubarraySum(new int[]{1,1,1,7,8,9}, 3));
        System.out.println(maximumSubarraySum(new int[]{9,18,10,13,17,9,19,2,1,18}, 5));
    }

    public static long maximumSubarraySum(int[] nums, int k) {
        long result = 0;
        HashSet<Integer> hashSet = new HashSet<>();
        int start = 0, end = 0;
        long windowSum = 0;
        while (end < nums.length) {
            if (hashSet.size() == k){
                result = Math.max(result, windowSum);
            }
            if (hashSet.contains(nums[end])) {
                while (start < end && nums[start] != nums[end]) {
                    hashSet.remove(nums[start]);
                    windowSum -= nums[start++];
                }
                hashSet.remove(nums[start]);
                windowSum -= nums[start++];
            }
            if (hashSet.size() < k) {
                windowSum += nums[end];
                hashSet.add(nums[end]);
            } else {
                windowSum -= nums[start];
                hashSet.remove(nums[start++]);
                hashSet.add(nums[end]);
                windowSum += nums[end];
            }
            end++;
        }
        if (hashSet.size() == k) {
            return Math.max(result, windowSum);
        }
        return result;
    }

//    public static long maximumSubarraySum(int[] nums, int k) {
//        long result = 0;
//        HashSet<Integer> hashSet = new HashSet<>();
//        int start = 0, end = 0;
//        long windowSum = 0;
//        while (end < nums.length) {
//            if (hashSet.size() < k) {
//                if (hashSet.contains(nums[end])) {
//                    hashSet.clear();
//                    windowSum = 0;
//                }
//                windowSum += nums[end];
//                hashSet.add(nums[end]);
//            } else {
//                result = Math.max(result, windowSum);
//                if (hashSet.contains(nums[end])) {
//                    while (start < end && nums[start] != nums[end]){
//                        hashSet.remove(nums[start]);
//                        windowSum -= nums[start++];
//                    }
//                    hashSet.remove(nums[start]);
//                    windowSum -= nums[start++];
//                }else {
//                    windowSum -= nums[start];
//                    hashSet.remove(nums[start++]);
//                }
//                hashSet.add(nums[end]);
//                windowSum += nums[end];
//            }
//            end++;
//        }
//        if (hashSet.size() == k) {
//            return Math.max(result, windowSum);
//        }
//        return result;
//    }

}
