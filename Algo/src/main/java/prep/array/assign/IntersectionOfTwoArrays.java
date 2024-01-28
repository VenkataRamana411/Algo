package prep.array.assign;

import java.util.*;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 9, 5,4};
        int[] nums2 = new int[]{9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> hset = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        //O(n)
        for (int n : nums1) {
            hset.add(n);
        }
        //O(mlogm)
        Arrays.sort(nums2);
        //O(U * log m)
        for (int num : hset) {
            int low = 0, high = nums2.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (nums2[mid] == num) {
                    list.add(num);
                    break;
                } else if (nums2[mid] > num) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        //O(R)
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static int[] intersection2(int[] nums1, int[] nums2) {
        short[] arr = new short[1001];
        int count = 0;
        for (int n : nums1) {
            arr[n] = 1;
        }
        for (int n : nums2) {
            if (arr[n] == 1) {
                count++;
                arr[n] = -1;
            }
        }
        int[] result = new int[count];
        int i = 0;
        for (int n : nums2){
            if(arr[n] == -1){
                result[i++] = n;
                arr[n] = 0;
            }
        }
        return result;
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        short[] arr = new short[1001];
        int  i = 0;
        List<Integer> list = new ArrayList<>();
        for (int n : nums1) {
            arr[n] += 1;
        }
        for (int n : nums2) {
            if (arr[n] != 0) {
                list.add(n);
                arr[n] -= 1;
            }
        }
        int[] result = new int[list.size()];
        for (int n : list){
            result[i++] = n;
        }
        return result;
    }
}
