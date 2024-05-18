package LeetCode;

import java.util.Stack;

public class RemoveKDigits {
    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219",3));
    }

    public static String removeKdigits(String num, int k) {
        if (num.length() == k){
            return "0";
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = num.length()-1 ; i >= 0 ; i--){
            stack.push(num.charAt(i) - '0');
        }
        while (k != 0){
            int num1 = stack.pop();
            int num2 = stack.pop();
            stack.push(Math.min(num1, num2));
            k--;
        }
        if (stack.peek() == 0){
            stack.pop();
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()){
            result.append(stack.pop());
        }

        return result.length() == 0 ? "0" : result.toString();
    }
}
