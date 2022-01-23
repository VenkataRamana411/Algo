package Array;

import java.util.*;

public class ValidSubsequence {
    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(1,2,3,4);
        List<Integer> sequence = Arrays.asList(1,3,4);
        System.out.println(isValidSubsequence(array,sequence));
    }
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        // Write your code here.
        int j = 0;
        for(int i:array){
            if(sequence.get(j) == i){
                ++j;
                if(j == sequence.size()){
                    return true;
                }
            }
        }
        return false;
    }
}
