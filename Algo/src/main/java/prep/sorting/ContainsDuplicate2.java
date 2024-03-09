package prep.sorting;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate2 {
    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate2(new int[]{1,2,3,1,2,3},3));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            if(hmap.containsKey(nums[i])){
                if (Math.abs(hmap.get(nums[i])-i) <= k){
                    return true;
                }
            }
            hmap.put(nums[i],i);
        }
        return false;
    }
    private static boolean containsNearbyDuplicate2(int[] nums,int k){
        Set<Integer> numSet = new HashSet<>();
        int i = 0 , j = 0;
        for (; i < nums.length; i++){
            if (i-j > k){
                numSet.remove(nums[j++]);
            }
            if (numSet.contains(nums[i])){
                return true;
            }
            numSet.add(nums[i]);
        }
        return false;
    }
}
