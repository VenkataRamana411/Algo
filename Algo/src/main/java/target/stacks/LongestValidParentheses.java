package target.stacks;

import java.util.Stack;

public class LongestValidParentheses {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses(")())()()"));
    }

    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); //Push initial placeHolder value for calculation
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);  //Push open brace index
            } else {
                /**
                 * Pop it so that corresponding open will be matched
                 * Empty stack means not a valid sequence as we have -1 initially
                 * So current index will be pushed as start-1 point
                * */
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    result = Math.max(result, i - stack.peek()); // () ==> 1 - (-1) = 2
                }
            }
        }
        return result;
    }
}
