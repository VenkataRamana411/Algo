package LeetCode;

import java.util.*;

public class BinaryArraySort {
    public static void main(String[] args) {
        int[] nums = {8,4,2,30,15};
        BinaryArraySort binaryArraySort = new BinaryArraySort();
        System.out.println(binaryArraySort.canSortArray(nums));
        System.out.println(binaryArraySort.canSortArray(new int[]{3,16,8,4,2}));
        System.out.println(binaryArraySort.canSortArray(new int[]{20,16}));
    }

    public boolean canSortArray(int[] nums) {
        boolean IS_SORTED = true;
        int prev = nums[0];
        for (int i = 1 ; i < nums.length; i++){
            if (nums[i] < prev){
                IS_SORTED = false;
            }
        }
        if (IS_SORTED){
            return true;
        }
        LinkedHashMap<Integer, Counter> hashMap = new LinkedHashMap<>();
        for (int n : nums){
            int count = setBitCounter(n);
            if (hashMap.containsKey(count)){
                Counter counter = hashMap.get(count);
                if (n < counter.getSmallest()){
                    counter.setSmallest(n);
                }
                if (n > counter.getLargest()){
                    counter.setLargest(n);
                }
            }else {
                hashMap.put(count,new Counter(n,n));
            }
        }

        int prevLarge = Integer.MIN_VALUE;
        for (Map.Entry<Integer,Counter> entry : hashMap.entrySet()){
            if (prevLarge > entry.getValue().getSmallest()){
                return false;
            }
            prevLarge = entry.getValue().getLargest();
        }
        return true;
    }

    public static class Counter{
        private int smallest;
        private int largest;

        public Counter(int smallest, int largest) {
            this.smallest = smallest;
            this.largest = largest;
        }

        public int getSmallest() {
            return smallest;
        }

        public void setSmallest(int smallest) {
            this.smallest = smallest;
        }

        public int getLargest() {
            return largest;
        }

        public void setLargest(int largest) {
            this.largest = largest;
        }
    }

    private int setBitCounter(int num){
        int result = 0;
        for (char c: Integer.toBinaryString(num).toCharArray()){
            if (c == '1'){
                result++;
            }
        }
        return result;
    }
}
