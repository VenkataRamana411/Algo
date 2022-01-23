package LeetCode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EvenDigits {
    public static void main(String[] args) {
        /*int[] nums = {12,345,2,6,7896};
        int l = (int) Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .filter(e -> e.length() % 2 == 0).count();
        System.out.println(l);*/



        int N = -5958 ,  output1 = 0;
        StringBuilder sb = new StringBuilder(Integer.toString(N));
        String s = Integer.toString(N);
        if(N >= 0){
            sb.deleteCharAt(sb.indexOf("5"));
        }else {
            sb.deleteCharAt(sb.lastIndexOf("5"));
        }
        output1 = Integer.parseInt(String.valueOf(sb));
        System.out.println(output1);




        int[] nums = {1,1,0,1,1,1,1,0,1,1};
        int result1 = 0 , result2 = 0 , currentValue1 = 0 , currentValue2 = 1;

        for (int n : nums) {
            if(n != currentValue1){
                ++result1;
            }
            if(n != currentValue2){
                ++result2;
            }
            currentValue1 = (currentValue1 == 0) ? 1 : 0;
            currentValue2 = (currentValue2 == 0) ? 1 : 0;
        }
        System.out.println(Math.min(result1,result2));
    }
}
