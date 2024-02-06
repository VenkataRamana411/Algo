package prep.stack;

import java.util.HashMap;
import java.util.Stack;

public class IsValidParenthesis {
    public static void main(String[] args) {
        System.out.println(isValid("){"));
        System.out.println(isValidApproach2("(]"));
    }

    public static boolean isValidApproach2(String s) {
        if (s.length() == 0) {
            return true;
        }
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> characterStack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                characterStack.add(c);
            } else {
                if (characterStack.empty()){
                    return false;
                }
                char topChar;
                switch (c) {
                    case ')':
                        topChar = characterStack.pop();
                        if (topChar == '{' || topChar == '[') {
                            return false;
                        }
                        break;
                    case '}':
                        topChar = characterStack.pop();
                        if (topChar == '(' || topChar == '[') {
                            return false;
                        }
                        break;
                    case ']':
                        topChar = characterStack.pop();
                        if (topChar == '{' || topChar == ')') {
                            return false;
                        }
                        break;
                }
            }
        }
        return characterStack.empty();
    }

    public static boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        if (s.length() % 2 != 0) {
            return false;
        }
        HashMap<Character, Character> characterHashMap = new HashMap<>();
        characterHashMap.put(')', '(');
        characterHashMap.put(']', '[');
        characterHashMap.put('}', '{');
        Stack<Character> characterStack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (characterHashMap.containsValue(c)) {
                characterStack.add(c);
            } else {
                if (characterStack.empty() || !characterHashMap.get(c).equals(characterStack.pop())) {
                    return false;
                }
            }
        }
        return characterStack.empty();
    }
}
