package prep.array;

import java.util.ArrayList;
import java.util.List;

public class PoliceThief {
    public static void main(String[] args) {
        String[] input = {"T","T","P","P","P","T","P","P"};
        System.out.println(helper(input,2));
    }

    private static int helper(String[] input,int k){
        int result = 0;
        List<Integer> police = new ArrayList<>();
        List<Integer> thief = new ArrayList<>();
        for(int i = 0; i < input.length; i++){
            if (input[i].equals("P")){
                police.add(i);
            }else {
                thief.add(i);
            }
        }
        int i = 0;
        int j = 0;
       while (i < police.size() && j < thief.size()){
           if (Math.abs(i-j) <= k){
               result++;
               i++;
               j++;
           } else if (police.get(i) < thief.get(j)) {
               i++;
           }else {
               j++;
           }
       }
        return result;
    }
}
