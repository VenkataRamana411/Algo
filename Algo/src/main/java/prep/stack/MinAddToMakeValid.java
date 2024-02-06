package prep.stack;

import java.util.Stack;

public class MinAddToMakeValid {
    public static void main(String[] args) {
        System.out.println(helper3("()))(("));
    }

    private static int helper3(String s){
        int result = 0;
        Stack<Character> characterStack = new Stack<>();
        for (char c : s.toCharArray()){
            if (c == '('){
                characterStack.add(c);
            }else {
                if (characterStack.empty()){
                    result++;
                }else {
                    characterStack.pop();
                }
            }
        }
        return result + characterStack.size();
    }

    public int helper4(String s) {
        int open = 0 , close = 0;
        for(char c : s.toCharArray()){
            if(c == '('){
                open++;
            }else{
                if (open > 0){
                    open--;
                }else {
                    close++;
                }
            }
        }
        return open+close;
    }

    public static int helper2IfFlipAllowed(String s) {
        int result = 0 , n = s.length();
        if (n % 2 != 0){
            result++;
        }
        for(int i = 0 ; i < s.length()-1 ; ){
            if (s.charAt(i) == '('){
                if (s.charAt(i+1) != ')'){
                    result++;
                }
            }else {
                if (s.charAt(i+1) != '('){
                    result++;
                }
            }
            i += 2;
        }
        return result;
    }

    // ((())(
    public int helper(String s) {
        int open = 0 , close = 0;
        for(char c : s.toCharArray()){
            if(c == '('){
                open++;
            }else{
                close++;
            }
        }
        return Math.abs(open - close);
    }

}
