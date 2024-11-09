package ae.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalanceBrackets {
    public static void main(String[] args) {
        System.out.println(balancedBrackets("([])(){}(())()()"));
        System.out.println(balancedBrackets("()()[{()})]"));
        System.out.println(balancedBrackets("(((((({{{{{safaf[[[[[([)]safsafsa)]]]]]}}}gawga}}))))))"));
    }

    public static boolean balancedBrackets(String str) {
        // Write your code here.
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> charMap = new HashMap<>();
        charMap.put(')','(');
        charMap.put(']','[');
        charMap.put('}','{');
        String charBraces = "()[]{}";
        for (Character c : str.toCharArray()){
            if (charBraces.contains(c.toString())){
                if (!charMap.containsKey(c)){
                    stack.push(c);
                }else {
                    if (stack.empty()  || !charMap.get(c).equals(stack.peek())){
                        return false;
                    }
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
