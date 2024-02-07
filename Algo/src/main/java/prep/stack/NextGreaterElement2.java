package prep.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement2 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }

    /**
    * TC: O(N)
     * SC: O(N)
    * */
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = n-1 ; i >= 0 ; i--){
            stack.push(nums[i]);
        }
        // (Top) 1 2 3 4 3
        for (int i = n-1 ; i >= 0 ; i--){
            int temp = nums[i];
            //pop the stack until we find greater element from the left (top)
            while (!stack.isEmpty() && temp >= stack.peek()){
                stack.pop();
            }
            //ITR-1 : 4 3
            //ITR-2 :
            //ITR-3 : 4
            //ITR-4 : 4 3
            //ITR-5 : 4 3
            //If no greater element is there that means stack is empty
            result[i] = stack.empty() ? -1 : stack.peek();
            //We need to push current number because we need in next iteration
            stack.push(temp);
        }
        return result;
    }

    public static int[] nextGreaterElements_brute(int[] nums) {
        //Create Extra and traverse it
        // TC: O(2*N)  & SC : O(2*N)
        int n = nums.length;
        int[] result = new int[n*2];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < 2*n ; i++){
            int val = nums[i % n];
            while (!stack.empty() && nums[stack.peek()] < val){
                result[stack.peek()] = val;
                stack.pop();
            }
            if (i < n){
                stack.push(i);
            }
        }
        return result;
    }
}
