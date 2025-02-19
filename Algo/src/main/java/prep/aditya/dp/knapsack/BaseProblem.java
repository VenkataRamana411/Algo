package prep.aditya.dp.knapsack;

import java.util.Arrays;

public class BaseProblem {
    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int bagWeight = 50;
        System.out.println(recursive(weights, val, bagWeight, weights.length - 1));
        /**
         * Identify recursive inputs which  are changing and define memo based on them
         * */

        int[][] memo = new int[bagWeight + 1][weights.length];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        System.out.println(memoization(weights, val, bagWeight, weights.length - 1, memo));
        System.out.println(tabulation(weights,val,bagWeight));
        System.out.println(tabulation2(weights,val,bagWeight));
    }

    private static int recursive(int[] weights, int[] values, int bagWeight, int index) {
        if (index == 0 || bagWeight == 0) {
            return 0;
        }
        if (weights[index] <= bagWeight) {
            return Math.max(values[index] + recursive(weights, values, bagWeight - weights[index], index - 1), recursive(weights, values, bagWeight, index - 1));
        }
        return recursive(weights, values, bagWeight, index - 1);
//        // Base case: If index is 0 or the bagWeight is 0, no items can be taken
//        if (index == 0 || bagWeight == 0) {
//            return 0;
//        }
//
//        // If the current item weight is less than or equal to the remaining bag weight
//        if (weights[index-1] <= bagWeight) {
//            return Math.max(
//                    values[index-1] + recursive(weights, values, bagWeight - weights[index], index - 1),  // Include the current item
//                    recursive(weights, values, bagWeight, index - 1)  // Do not include the current item
//            );
//        }
//
//        // If the current item's weight is greater than the remaining bag weight
//        return recursive(weights, values, bagWeight, index - 1);  // Skip the current item
    }

    private static int memoization(int[] weights, int[] values, int bagWeight, int index, int[][] memo) {
        if (index == 0 || bagWeight == 0) {
            return 0;
        }
        if (memo[bagWeight][index] != -1) {
            return memo[bagWeight][index];
        }
        if (weights[index] <= bagWeight) {
            memo[bagWeight][index] = Math.max(values[index] + memoization(weights, values, bagWeight - weights[index], index - 1, memo), memoization(weights, values, bagWeight, index - 1, memo));
        } else {
            memo[bagWeight][index] = memoization(weights, values, bagWeight, index - 1, memo);
        }
        return memo[bagWeight][index];
    }

    /**
     Step 1: Initialize DP Table
     java
     Copy
     int n = weights.length;
     int[][] dp = new int[n + 1][bagWeight + 1];
     n: This stores the number of items (i.e., the length of the weights array).

     dp[][]: This is a 2D array used to store the results of subproblems.

     dp[i][w] represents the maximum value that can be obtained by considering the first i items with a knapsack capacity of w.
     We create an extra row and column (n+1 rows and bagWeight+1 columns) to handle the base case where no items are considered (i = 0) or when the knapsack capacity is 0 (w = 0).

     Step 2: Fill DP Table Using Nested Loops
     java
     Copy
     // Build table dp[][] in bottom-up manner
     for (int i = 0; i <= n; i++) {
     for (int w = 0; w <= bagWeight; w++) {
     Outer loop (i): Loops over the number of items considered (from 0 to n).
     Inner loop (w): Loops over possible knapsack capacities (from 0 to bagWeight).
     The idea is to fill the DP table row by row (from i = 0 to n) and column by column (from w = 0 to bagWeight), ensuring that we calculate the optimal solution for each subproblem in a bottom-up manner.

     Step 3: Base Cases
     java
     Copy
     if (i == 0 || w == 0)
     dp[i][w] = 0;
     If i == 0, it means we're considering 0 items, so the maximum value is 0 (no items to choose from).
     If w == 0, it means the knapsack has 0 capacity, so the maximum value is 0 (can't carry anything in the knapsack).
     So, the base case is that when either there are no items or no capacity in the knapsack, the value is 0.

     Step 4: Decision to Include or Exclude the Current Item
     java
     Copy
     else if (weights[i - 1] <= w)
     dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
     Condition (weights[i - 1] <= w): This checks if the current item (i-1) can be included in the knapsack (i.e., its weight is less than or equal to the remaining capacity w).
     If it can be included, we decide whether including it is better than excluding it:
     Include the item: Add the value of the current item (values[i - 1]) to the result of the subproblem where the remaining capacity is reduced by the weight of the current item (w - weights[i - 1]), i.e., values[i - 1] + dp[i - 1][w - weights[i - 1]].
     Exclude the item: Consider the result of the subproblem without including the current item, i.e., dp[i - 1][w].
     Result: The maximum of these two options is stored in dp[i][w].
     Step 5: Exclude the Current Item
     java
     Copy
     else
     dp[i][w] = dp[i - 1][w];
     Condition (else): If the current item (i-1) cannot be included (its weight is greater than the remaining capacity), we simply exclude it from the knapsack and take the result of the subproblem where the capacity remains the same (dp[i - 1][w]).
     Step 6: Return the Result
     java
     Copy
     return dp[n][bagWeight];
     After all loops are completed, dp[n][bagWeight] will hold the maximum value that can be obtained by considering all n items with a knapsack of capacity bagWeight.
    * */
    private static int tabulation(int[] weights, int[] values, int bagWeight) {
        int n = weights.length;
        int[][] dp = new int[n + 1][bagWeight + 1];

        // Build table dp[][] in bottom-up manner
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= bagWeight; w++) {
                if (i == 0 || w == 0)
                    dp[i][w] = 0;
                else if (weights[i - 1] <= w)
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                else
                    dp[i][w] = dp[i - 1][w];
            }
        }
        return dp[n][bagWeight];
    }

    private static int tabulation2(int[] weights, int[] values, int bagWeight) {
        int[] dp = new int[bagWeight+1];
        for(int item = 1; item < weights.length+1; item++){
            for (int wt = bagWeight; wt >= 0; wt--){
                if (weights[item-1] <= wt){
                    dp[wt] = Math.max(dp[wt],dp[wt-weights[item-1]]+values[item-1]);
                }
            }
        }
        return dp[bagWeight];
    }
}
