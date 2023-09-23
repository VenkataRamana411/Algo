package ks.recursion;

import java.util.List;

public class ArrayRec {
    public static void main(String[] args) {
       /* int[] nums = new int[]{1,2,4,8,9,10};
        System.out.println(isSorted(nums,0));
        int[] nums2 = new int[]{1,34,5,2,1,3,4,6,1,34,3,1};
        List<Integer> integerList = linearSearchOccurrences(nums2, 0, 1, new ArrayList<>());
        System.out.println(integerList.toString());*/
        int[] nums3 = new int[]{5, 6, 7, 8, 9, 1, 2, 3, 4};
        System.out.println(rotatedBinarySearch(nums3, 0, nums3.length - 1, 50));
    }

    private static boolean isSorted(int[] nums, int index) {
        if ((nums.length - 1) == index) {
            return true;
        }
        if (nums[index] > nums[index + 1]) {
            return false;
        }
        return isSorted(nums, index + 1);
    }

    private static List<Integer> linearSearchOccurrences(int[] nums, int index, int target, List<Integer> result) {
        if (index == nums.length) {
            return result;
        }
        if (nums[index] == target) {
            result.add(index);
        }
        return linearSearchOccurrences(nums, index + 1, target, result);
    }

    private static int rotatedBinarySearch(int[] nums, int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[start] <= nums[mid]) {
            if (target >= nums[start] && target <= nums[mid]) {
                return rotatedBinarySearch(nums, start, mid - 1, target);
            } else {
                return rotatedBinarySearch(nums, mid + 1, end, target);
            }
        } else if (target >= nums[mid] && target <= nums[end]) {
            return rotatedBinarySearch(nums, mid + 1, end, target);
        } else {
            return rotatedBinarySearch(nums, start, mid - 1, target);
        }
    }
}
