package LeetCode;

public class Helper {
    public static void main(String[] args) {
        String[] foods = new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"};
        String[] cuisines = new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"};
        int[] ratings = new int[]{9, 12, 8, 15, 14, 7};
        FoodRatings foodRatings = new FoodRatings(foods, cuisines, ratings);
        System.out.println(foodRatings.highestRated("korean"));
        System.out.println(foodRatings.highestRated("japanese"));
    }
}
