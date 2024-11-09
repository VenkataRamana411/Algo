package ae.stack;

import java.util.Stack;

public class BestDigits {
    public static void main(String[] args) {
        System.out.println(bestDigits("462839",2));
    }

    public static String bestDigits(String number, int numDigits) {
        // Write your code here.
        Stack<Character> stack = new Stack<>();
        for (int i = 0 ; i < number.length(); i++){
            char num = number.charAt(i);
            while (numDigits > 0 && !stack.isEmpty() && num > stack.peek()){
                stack.pop();
                numDigits--;
            }
            stack.push(num);
        }
        while (numDigits > 0){
            stack.pop();
            numDigits--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
