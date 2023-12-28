package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class StringCompressionTwo {
    public static void main(String[] args) {
        getLengthOfOptimalCompression("aabbaa",2);
    }
    public static int getLengthOfOptimalCompression(String s, int k) {
        StringBuilder temp = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        int count = 1 , probables = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if (i == s.length()-1){
                temp.append(s.charAt(i)).append(count);
                list.add(count);
                if (k >= count){
                    probables++;
                }
                break;
            }
            if(s.charAt(i) == s.charAt(i+1)){
                count++;
            }else{
                temp.append(s.charAt(i)).append(count);
                list.add(count);
                if (k >= count){
                    probables++;
                }
                count = 1;
            }
        }
        System.out.println(temp);
        System.out.println(probables);
        System.out.println(temp.toString().length()-probables*2);
        return count;
    }
}
