package LeetCode;

import java.util.Stack;

public class ReverseSubString {
    public static void main(String[] args) {
        System.out.println(reverseParentheses("(u(love)i)"));
        System.out.println(reverseParentheses("(ed(et(oc))el)"));
    }

    private static String reverseParentheses(String s) {
        Stack<StringBuilder> strings = new Stack<>();
        strings.push(new StringBuilder());
        for (char c : s.toCharArray()) {
            if (c == '(') {
                strings.push(new StringBuilder());
            } else if (c == ')') {
                StringBuilder reverse = strings.pop().reverse();
                strings.push(strings.pop().append(reverse));
            } else {
                strings.push(strings.pop().append(c));
            }
        }
        return strings.pop().toString();
    }

    private static String reverse(String word) {
        StringBuilder sb = new StringBuilder();
        sb.reverse();
        return "";
    }
}
