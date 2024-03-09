package prep.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    /**
     * 179. Largest Number
     * Medium
     * Topics
     * Companies
     * Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
     * <p>
     * Since the result may be very large, so you need to return a string instead of an integer.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [10,2]
     * Output: "210"
     * Example 2:
     * <p>
     * Input: nums = [3,30,34,5,9]
     * Output: "9534330"
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= nums.length <= 100
     * 0 <= nums[i] <= 109
     * <p>
     * Seen this question in a real interview before?
     * 1/4
     * Yes
     * No
     * Accepted
     * 454K
     * Submissions
     * 1.3M
     * Acceptance Rate
     * 35.8%
     */
    public static void main(String[] args) {
        int[] nums = new int[]{3, 30, 34, 5, 9};
        System.out.println(largestNumber(nums));
    }

    /**
     * k: Average length of strings in string array
     * TC: O(NlogN * k) + O(N) = O(k * NlogN)
     * SC: O(N)
    * */
    public static String largestNumber(int[] nums) {
        String[] stringNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            stringNums[i] = String.valueOf(nums[i]);
        }
        /*Comparator<String> stringComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String value1 = o1 + o2;
                String value2 = o2 + o1;
                return value2.compareTo(value1);
            }
        };*/
        //Build comparator to compare 2 strings and sort the result in descending order
        Comparator<String> stringComparator = (o1, o2) -> {
            System.out.println(o1 + " -- " + o2);
            String value1 = o1 + o2;
            String value2 = o2 + o1;
            return value2.compareTo(value1);
        };
        Arrays.sort(stringNums,stringComparator);
        //If first value is 0 then all following values are 0. so return it
        if (stringNums[0].equals("0")){
            return stringNums[0];
        }
        StringBuilder result = new StringBuilder();
        for (String num : stringNums){
            result.append(num);
        }
        return result.toString();
    }
}
