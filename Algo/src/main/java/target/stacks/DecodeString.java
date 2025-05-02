package target.stacks;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[c]]"));
        System.out.println(decodeString("10[a2[c]]"));
        //System.out.println(decodeString("2[abc]3[cd]ef"));
        //"2[abc]3[cd]ef";
    }

    public static String decodeString(String s) {
        Stack<String> stringStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        String nums = "0123456789";
        for (char c : s.toCharArray()) {
            if (c == ']') {
                while (!stringStack.peek().equals("[")) {
                    sb.append(stringStack.pop());
                }
                stringStack.pop();
                String sequence = sb.toString();
                StringBuilder num = new StringBuilder();
                while (!stringStack.isEmpty() && nums.contains(stringStack.peek())) {
                    num.append(stringStack.pop());
                }
                int temp = Integer.parseInt(num.reverse().toString());
                while (temp != 1) {
                    sb.append(sequence);
                    temp--;
                }
                stringStack.add(sb.toString());
                sb.delete(0, sb.length());
            } else {
                stringStack.add(String.valueOf(c));
            }
        }
        while (!stringStack.isEmpty()) {
            sb.append(stringStack.pop());
        }
        return sb.reverse().toString();
    }


    public String decodeStringO(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // Build the number k (repeat count)
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                countStack.push(k);
                stringStack.push(currentString);
                // Reset for the next encoded string
                currentString = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                int repeatCount = countStack.pop();
                StringBuilder previousString = stringStack.pop();
                // Append the decoded string to the previous string
                for (int i = 0; i < repeatCount; i++) {
                    previousString.append(currentString);
                }
                currentString = previousString;
            } else {
                // Append the character to the current string
                currentString.append(c);
            }
        }

        return currentString.toString();
    }

}
