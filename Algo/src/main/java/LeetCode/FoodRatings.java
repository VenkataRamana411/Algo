package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FoodRatings {
    String[] foods;
    String[] cuisines;
    int[] ratings;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        this.foods = foods;
        this.cuisines = cuisines;
        this.ratings = ratings;
    }

    public void changeRating(String food, int newRating) {
        for (int i = 0; i < foods.length; i++) {
            if (foods[i].equals(food)) {
                ratings[i] = newRating;
            }
        }
    }

    public String highestRated(String cuisine) {
        List<String> highestRatedFood = new ArrayList<>();
        int highestRated = 0;
        for (int i = 0; i < cuisines.length; i++) {
            if (cuisines[i].equals(cuisine)) {
                if (ratings[i] > highestRated){
                    highestRatedFood.clear();
                    highestRatedFood.add(foods[i]);
                    highestRated = ratings[i];
                }else if(ratings[i] == highestRated){
                    highestRatedFood.add(foods[i]);
                    highestRated = ratings[i];
                }
            }
        }
        Collections.sort(highestRatedFood);
        return highestRatedFood.get(0);
    }
}
