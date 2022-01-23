package Strings;

import java.util.*;

public class CaesarCiphar {
    public static void main(String[] args) {
        /*
        * xyz 2 ==> zab
        * We have to shift k bits given as per input
        * */
        Scanner sc = new Scanner(System.in);
        String input = "";
        int k = 0;
        StringBuilder output = new StringBuilder();
        StringBuilder output2 = new StringBuilder();
        do{
            input = sc.nextLine();
            k = sc.nextInt();
            /*Approach -1 : Using unicode values
              space = O(N) As we are creating new String object
              Time = O(N) As we are iterating through String once
            */
            k = k % 26; /*If at all we are given big number as key. This mode operation ensure it will fall on 1 to 26 always */
            for(int i = 0 ; i < input.length();i++){
                int val = input.charAt(i);
                val += k;
                if(val > 122){
                    val -= 26;
                }
                output.append((char)val);
            }
            System.out.println(output);

            /*
            * Approach-2: We can store all possible values in array and find index from it
            * */


            char[] chars = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
            List<char[]> characters = Collections.singletonList(chars);
            for(int i = 0 ; i < input.length() ; i++){
                /*char val = input.charAt(i);*/

                int temp = characters.indexOf(input.charAt(i));
                if((temp+k)>25){
                    temp = temp % 25;
                    temp--;
                }
                output2.append(chars[temp]);
            }
            System.out.println(output2);

        }while (!input.equals("q"));
    }
}
