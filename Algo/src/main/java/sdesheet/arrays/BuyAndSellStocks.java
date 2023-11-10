package sdesheet.arrays;

public class BuyAndSellStocks {
    public static void main(String[] args) {
        int[] input = new int[]{7,6,4,3,1};
        System.out.println(helper(input));
    }

    private static int helper(int[] input) {
        int result = 0;
        int min = input[0];
        for (int i = 1; i < input.length; i++) {
            if (input[i] < min) {
                min = input[i];
            }
            if (input[i] - min > result) {
                result = input[i] - min;
            }
        }
        return result;
    }
}
