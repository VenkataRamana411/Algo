package LeetCode;

import java.util.HashMap;

public class ContainsDuplicate {
    public static void main(String[] args) {

    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
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
}
