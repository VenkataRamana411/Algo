package ae.stack;

import java.util.Stack;

public class ReversePolishNotation {
    public static void main(String[] args) {
        System.out.println(reversePolishNotation(new String[]{"50", "3", "17", "+", "2", "-", "/"}));
    }

    public static int reversePolishNotation(String[] tokens) {
        // Write your code here.
        int result = 0;
        String operators = "+-*/";
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (!operators.contains(s)) {
                stack.add(Integer.valueOf(s));
            } else {
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                switch (s) {
                    case "+":
                        stack.push(temp1 + temp2);
                        break;
                    case "-":

                        stack.push(temp2 - temp1);
                        break;
                    case "*":
                        stack.push(temp1 * temp2);
                        break;
                    case "/":
                        stack.push(temp2 / temp1);
                        break;
                }
            }
        }
        return stack.pop();
    }
}
