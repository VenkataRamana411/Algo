package Array;

import java.util.*;

public class ThreeNumberSum {
    public static void main(String[] args) {
        List<Integer[]> result = optimalThreeNumberSum(new int[]{12, 3, 1, 2, -6, 5, -8, 6}, 0);
        Iterator<Integer[]> itr = result.iterator();
        while(itr.hasNext()){
            System.out.println(Arrays.toString(itr.next()));
        }
    }

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        // Write your code here.
        array = new int[]{1,2,3};
        targetSum = 6;
        List<Integer[]> output = new ArrayList<>();
        for(int i = 0 ; i < array.length;i++){
            int temp = targetSum+array[i];
            for(int j = i+1 ; j < array.length;j++){
                int temp2 = temp+array[j];
                for(int k = j+1 ; k < array.length;k++){
                    int temp3 = temp2+array[k];
                    if(temp3 == targetSum){
                        Integer[] resultSet = {array[i],array[j],array[k]};
                        output.add(resultSet);
                    }
                }
            }
        }
        return output;
    }

    public static List<Integer[]> optimalThreeNumberSum(int[] array, int targetSum){
        List<Integer[]> output = new ArrayList<>();
        /*
         * -8,-6,1,2,3,5,6,12
         * */
        Arrays.sort(array);
        for(int i = 0 ; i < array.length ; i++){
            for (int j = i+1 , k = array.length-1 ; j < k ;  ){
                int temp = array[i]+array[j]+array[k];
                if(temp == targetSum){
                    Integer[] resulSet = {array[i],array[j],array[k]};
                    output.add(resulSet);
                    j++;
                    k--;
                }else if(temp > targetSum){
                    k--;
                }else {
                    j++;
                }
            }
        }
        return output;
    }
}
