package LeetCode;

import java.util.Stack;

public class ParseBoolExp {
    public static void main(String[] args) {
//        System.out.println(parseBoolExpr("|(f,f,f,t)"));
//        System.out.println(parseBoolExpr("&(|(f))"));
//        System.out.println(parseBoolExpr("!(&(f,t))"));
        System.out.println(parseBoolExpr("|(&(t,f,t),!(t))"));
    }

    public static boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();
        Stack<Character> opStack = new Stack<>();
        for (char ch : expression.toCharArray()) {
            if (ch != ')') {
                stack.push(ch);
            } else {
                while (stack.peek() != '(') {
                    char c = stack.pop();
                    if (c != ',') {
                        opStack.push(c);
                    }
                }
                stack.pop();
                char operator = stack.pop();
                boolean tempResult = opStack.pop() != 'f';
                if (operator == '|') {
                    while (!opStack.empty()) {
                        if (opStack.pop() == 't') {
                            tempResult = true;
                            break;
                        }
                    }
                }
                if (operator == '&') {
                    while (!opStack.empty()) {
                        if (opStack.pop() == 'f') {
                            tempResult = false;
                            break;
                        }
                    }
                }
                if (operator == '!') {
                    tempResult = !tempResult;
                }
                stack.push(tempResult ? 't' : 'f');
                opStack.clear();
            }
        }
        return stack.pop() == 't';
    }

}
