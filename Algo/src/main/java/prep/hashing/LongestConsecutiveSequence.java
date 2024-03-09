package prep.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        //int[] nums = {0,3,7,2,5,8,4,6,0,1};
        int[] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutiveOptimal(nums));
    }
    /**
     * TC:O(N)
     * SC:O(N)
    * */
    public static int longestConsecutiveOptimal(int[] nums){
        if (nums.length < 2){
            return nums.length;
        }
        Set<Integer> integerSet = new HashSet<>();
        //To remove duplicates
        for (int n : nums){
            integerSet.add(n);
        }
        int count = 0;
        for (int n : nums){
            //put pointers on either side of the number and start removing elements and
            // distance b/w pointers will be our answer
            int left = n-1;
            int right = n+1;
            while (integerSet.remove(left)){
                left--;
            }
            while (integerSet.remove(right)){
                right++;
            }
            //When calculating the length of the sequence, we count the difference between the right and left boundaries.
            // However, the actual count of elements in the sequence is one less than the difference between the boundaries.
            // This is because the endpoints themselves are not part of the sequence.
            //For example, in the sequence [1, 2, 3, 4], the difference between the right and left boundaries is 4 - 1 = 3. However, there are only 3 elements in the sequence: 2, 3, and 4.
            count = Math.max(count,right-left-1);
            if (integerSet.isEmpty()){
                return count;
            }
        }
        return count;
    }
    /**
     * TC: O(nlogn)
     * SC: O(1)
    * */
    public static int longestConsecutive(int[] nums) {
        if (nums.length < 2){
            return nums.length;
        }
        int maxCount = 0,currentCount = 1; // As we have already considered 0th element in the result
        Arrays.sort(nums);
        for (int i = 1 ; i < nums.length ; i++){
            if (nums[i] == nums[i-1]){
                continue;
            }else if (nums[i] == nums[i-1]+1){
                currentCount++;
            }else {
                maxCount = Math.max(maxCount,currentCount);
                currentCount = 1;
            }
        }
        return Math.max(maxCount,currentCount);
        /*HashMap<Integer,Integer> freqMap = new HashMap<>();
        freqMap.put(nums[0],1);
        for(int i= 1; i < nums.length ; i++){
            int temp = freqMap.getOrDefault(nums[i] + 1, 0) + freqMap.getOrDefault(nums[i] - 1, 0);
            freqMap.put(nums[i],temp+1);
        }
        return maxCount;*/
    }
}
