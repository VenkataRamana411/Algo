package LeetCode.lc2025;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIndex {
    public static void main(String[] args) {
        // System.out.println(minimumIndex(List.of(2,1,3,1,1,1,7,1,2,1)));
        System.out.println(minimumIndex(List.of(3, 3, 3, 3, 7, 2, 2)));
    }

    public static int minimumIndex(List<Integer> nums) {
        int majority = nums.get(0), count = 0, majorityCount = 0;
        for (int num : nums) {
            if (num == majority) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                majority = num;
                count = 1;
            }
        }

        for (int num : nums) {
            if (num == majority) {
                majorityCount++;
            }
        }
        count = 0;
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            if (nums.get(0) == majority) {
                count++;
            }
            int remainingCount = majorityCount - count;
            if (count * 2 > i + 1 && remainingCount * 2 > n - i - 1) {
                return i;
            }
        }
        return -1;

//        HashMap<Integer,Integer> hmap = new HashMap<>();
//        for(Integer num: nums){
//            hmap.put(num,hmap.getOrDefault(num,0)+1);
//        }
//        int maxFreq = 0, dominantElement = 0;
//        for(Map.Entry entry : hmap.entrySet()){
//            if((int)entry.getValue() > (maxFreq)){
//                maxFreq = (int) entry.getValue();
//                dominantElement = (int) entry.getKey();
//            }
//        }
//        if(maxFreq % 2 != 0){
//            return -1;
//        }
//        int left = 0;
//        maxFreq = maxFreq/2;
//        for(int i = 0; i < nums.size(); i++){
//            if(nums.get(i) == dominantElement){
//                left++;
//            }
//            if(left == maxFreq){
//                return i;
//            }
//        }

    }
}
