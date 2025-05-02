package target.stacks;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        System.out.println(isValid("(){({})}"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.add(c);
            } else {
                switch (c) {
                    case ')':
                        if (stack.pop() != '(') {
                            return false;
                        }
                        break;
                    case '}':
                        if (stack.pop() != '{') {
                            return false;
                        }
                        break;
                    case ']':
                        if (stack.pop() != ']') {
                            return false;
                        }
                        break;
                }
            }
        }
        return stack.isEmpty();
    }

}
