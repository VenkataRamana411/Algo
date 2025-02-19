package Strings;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        //abcddcba
        Scanner sc = new Scanner(System.in);
        String input = "";

        do{
            input = sc.nextLine();
            /*Approach -1 : Use Inbuilt functions
              space = O(N) As we are creating new String object
              Time = O(N) As we are iterating through String once
            */
            StringBuilder sb = new StringBuilder();
            sb.append(input);
            sb.delete(0,sb.length());
            sb.reverse();
            System.out.println(input+" is"+(input.contentEquals(sb)?" ":" not")+" palindrome");

            /*
            * Approach-Recursion
            * But it takes SPACE = O(N) due to storing of call stack
            * */


            /*Approach - 2 : using two pointers at start and end
                    space = O(1) As we are not storing anything
                    Time = O(N) As we are iterating through String once*/
            boolean a2 =true;
            for(int i = 0 , j = input.length()-1 ; i < j ; i++,j--){
                    if(input.charAt(i) != input.charAt(j)){
                        a2 = false;
                        break;
                    }
            }
            System.out.println(input+" is"+(a2?" ":" not")+" palindrome");

            System.out.println(input+" is"+(isPalindrome(input)?" ":" not")+" palindrome");

        }while (!input.equals("q"));

    }

    private static boolean isPalindrome(String input){
        int leftIdx = 0;
        int rightIdx = input.length()-1;
        while(leftIdx < rightIdx){
            if(input.charAt(leftIdx) != input.charAt(rightIdx)){
                return false;
            }
            rightIdx--;
            leftIdx++;
        }
        return true;
    }
}
