package prep.array;

import java.util.ArrayList;
import java.util.List;

public class KidWithCandies {
    public static void main(String[] args) {
        int[] candies = new int[]{2,3,5,1,3};
        System.out.println(kidsWithCandies(candies,3));
    }
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int max = candies[0];
        for (int i = 1 ; i < candies.length ; i++){
            if (candies[i] > max){
                max = candies[i];
            }
        }
        for (int i = 0 ; i < candies.length ; i++){
            if (candies[i] + extraCandies >= max){
                result.add(true);
            }else {
                result.add(false);
            }
        }
        return result;
    }
}
