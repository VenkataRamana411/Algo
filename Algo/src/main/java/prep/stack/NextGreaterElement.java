package prep.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{4, 5, 2, 25})));
        System.out.println(Arrays.toString(nextGreaterElement2(new Long[]{4L, 5L, 2L, 25L})));
    }
    public static int[] nextGreaterElement(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result,-1);
        int j = 0;
        Stack<Integer> integerStack = new Stack<>();
        for (int i = 0 ; i < nums.length ; i++){
            if (integerStack.empty()){
                integerStack.add(i);
            }else {
                while (!integerStack.empty() && nums[i] > nums[integerStack.peek()]){
                    result[integerStack.pop()] = nums[i];
                }
                integerStack.add(i);
            }
        }
        return result;
    }
    public static Long[] nextGreaterElement2(Long[] nums) {
        Long[] result = new Long[nums.length];
        Arrays.fill(result,-1L);
        Stack<Integer> integerStack = new Stack<>();
        for (int i = 0 ; i < nums.length ; i++){
            if (integerStack.empty()){
                integerStack.add(i);
            }else {
                while (!integerStack.empty() && nums[i] > nums[integerStack.peek()]){
                    result[integerStack.pop()] = nums[i];
                }
                integerStack.add(i);
            }
        }
        return result;
    }
}
