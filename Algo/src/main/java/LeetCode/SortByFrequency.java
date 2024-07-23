package LeetCode;

import java.util.*;

public class SortByFrequency {
    public static void main(String[] args) {
        int[] nums ={1,1,2,2,2,3};
        System.out.println(Arrays.toString(frequencySort(nums)));
    }

    public static int[] frequencySort(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> hmap = new HashMap<>();
        for(int num : nums){
            hmap.put(num,hmap.getOrDefault(num,0)+1);
        }

        Integer[] numsArray = new Integer[n];
        for(int i = 0 ; i < n ; i++){
            numsArray[i] = nums[i];
        }
        Arrays.sort(numsArray, (a,b) -> {
            if(hmap.get(a).equals(hmap.get(b))){
                return Integer.compare(b,a);
            }
            return Integer.compare(hmap.get(a),hmap.get(b));
        });
        for(int i = 0 ; i < n ; i++){
            nums[i] = numsArray[i];
        }
        return nums;
    }
}
