package prep.sorting;

import java.util.*;

public class ContainsDuplicate3 {
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,4,5};
        //int[] nums = {1,2,3,1};
        System.out.println(containsNearbyAlmostDuplicate(nums,3,0));
        System.out.println(containsNearbyAlmostDuplicate(new int[]{-1,-1},1,0));
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Long> treeSet = new TreeSet<>();
        treeSet.add((long)nums[0]);
        int i = 1;
        for (; i < nums.length ; i++){
            if (i > indexDiff){
                treeSet.remove(nums[i-indexDiff-1]);
            }
            long left = (long)nums[i] - valueDiff;
            long right = (long)nums[i] + valueDiff;
            if (left <= right && !treeSet.subSet(left,right+1).isEmpty()){
                return true;
            }
            treeSet.add((long)nums[i]);
        }
        return false;
    }

    public static boolean containsNearbyAlmostDuplicateNW(int[] nums, int indexDiff, int valueDiff) {
        PriorityQueue<Integer> pqAsc = new PriorityQueue<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int i = 0 , j = 0 ;
        for(; i < nums.length; i++){
            int temp = Math.abs(nums[i]);
            if(pq.size() > indexDiff){
                pqAsc.remove(nums[j++]);
                pq.remove(nums[j++]);
            }
            if (!pq.isEmpty()){

                if (Math.abs(pq.peek() - temp) <= valueDiff || Math.abs(pqAsc.peek() - temp) <= valueDiff){
                    return true;
                }
            }
            pq.add(temp);
            pqAsc.add(temp);
        }
        return false;
    }
}
