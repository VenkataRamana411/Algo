package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class ArrayTo2DArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,4,1,2,3,1};
        System.out.println(findMatrixOptimal(nums));
    }

    /**
     * TC: O(N)
     * SC: O(1)
     * */
    public static List<List<Integer>> findMatrixOptimal(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //Define a frequency counter
        int[] freq = new int[nums.length+1];
        for (int n : nums) {
            // Check if size of current element freq is greater than number of rows created till so far. If true create a new row
           if (freq[n] >= result.size()){
               result.add(new ArrayList<>());
           }
           result.get(freq[n]).add(n);
            freq[n]++;
        }
        return result;
    }
    /**
     * TC: O(N * M)
     * SC: O(1)
    * */
    public static List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();
        row.add(nums[0]);
        result.add(row);
        boolean isAdded = false;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < result.size(); j++) {
                if (!result.get(j).contains(nums[i])) {
                    result.get(j).add(nums[i]);
                    isAdded = true;
                    break;
                }
            }
            if (!isAdded) {
                ArrayList<Integer> newRow = new ArrayList<>();
                newRow.add(nums[i]);
                result.add(newRow);
            }
            isAdded = false;
        }
        return result;
    }
}
