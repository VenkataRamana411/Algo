package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCompressionOne {
    public static void main(String[] args) {
        char[] chars = new char[]{'a'};
        getLengthOfOptimalCompression(chars);
        System.out.println(chars);
    }

    public static int getLengthOfOptimalCompression(char[] chars) {

        StringBuilder temp  = new StringBuilder();
        int count = 1;
        for(int i = 0 ; i < chars.length ; i++){
            if (i == chars.length-1){
                temp.append(chars[i]);
                if (count > 1){
                    temp.append(count);
                }
                break;
            }
            if(chars[i] == chars[i+1]){
                count++;
            }else{
                temp.append(chars[i]);
                if (count > 1){
                    temp.append(count);
                }
                count = 1;
            }
        }
        char[] comp = temp.toString().toCharArray();
        for(int i=0;i<comp.length;i++){
            chars[i]=comp[i];
        }
        if (comp.length != chars.length){
            Arrays.fill(chars,comp.length,chars.length-1,' ');
        }

        System.out.println(comp.length);
        return comp.length;
      /*  System.out.println(result);
        return count;*/
    }

    private static int getResult(int count) {
        if (count < 9){
            return 2;
        } else if (count < 99) {
            return 3;
        } else if (count < 999) {
            return 4;
        }else {
            return 5;
        }
    }
}
