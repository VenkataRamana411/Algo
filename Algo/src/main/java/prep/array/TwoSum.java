package prep.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TwoSum {
    public static void main(String[] args) {
        int target = 6;
        int[] input = {1, 3, 5, 6, 7, 8, 10};
        int[] result = helper(input, target);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(helper2(input,target)));
        System.out.println(Arrays.toString(twoSumBest(input,target)));
    }
    public static int[] twoSumBest(int[] numbers, int target) {
        int[] result = new int[2];
        for (int i = 0 , j = numbers.length-1; i < j;) {
            if(target == numbers[i] + numbers[j]){
                result[0] = i + 1;
                result[1] = j + 1;
                return result;
            }else if(target < numbers[i] + numbers[j]){
                j--;
            }else{
                i++;
            }
        }
        return result;
    }

    private static int[] helper(int[] numbers, int target) {
        HashMap<Integer, Integer> nums = new HashMap<>();
        nums.put(numbers[0], 1);
        int[] result = new int[2];
        for (int i = 1; i < numbers.length; i++) {
            if (nums.containsKey(target - numbers[i])) {
                result[0] = nums.get(target - numbers[i]);
                result[1] = i + 1;
            }
            nums.put(numbers[i], i + 1);
        }
        return result;
    }

    /**
    * Without Extra Space
    * */
    private static int[] helper2(int[] numbers, int target) {
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                int temp = numbers[i] + numbers[j];
                if (temp == target) {
                    result[0] = i + 1;
                    result[1] = j + 1;
                    return result;
                } else if (temp > target) {
                    break;
                }
            }
        }
        return result;
    }
}
