package sdesheet.arrays;

import java.util.Arrays;

public class SetMatrixZero {
    public static void main(String[] args) {
        int[][] input = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        betterHelper(input);
        System.out.println(Arrays.deepToString(input));
    }

    /**
     * Better Solution
     * TC: O(M*N) + O(M*N)  ~ O(2*M*N)
     * SC: O(M) + O(N)
     */
    private static void betterHelper(int[][] matrix) {
        int[] rowTracker = new int[matrix.length];
        int[] colTracker = new int[matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    rowTracker[row] = 1;
                    colTracker[col] = 1;
                }
            }
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (rowTracker[row] == 1 || colTracker[col] == 1) {
                    matrix[row][col] = 0;
                }
            }
        }
    }

    /**
     * Brute Force
     * TC: O(M*N) + O(M+N) + O(M*N)  ~ O(MN)^3
     * SC: O(1)
     */
    private static void helper(int[][] input) {
        for (int row = 0; row < input.length; row++) {
            for (int col = 0; col < input[0].length; col++) {
                if (input[row][col] == 0) {
                    fillZerosInRow(input, row);
                    fillZerosInColumn(input, col);
                }
            }
        }
        for (int row = 0; row < input.length; row++) {
            for (int col = 0; col < input[0].length; col++) {
                if (input[row][col] == -1) {
                    input[row][col] = 0;
                }
            }
        }
    }

    private static void fillZerosInRow(int[][] input, int row) {
        for (int col = 0; col < input[row].length; col++) {
            if (input[row][col] != 0) {
                input[row][col] = -1;
            }
        }
    }

    private static void fillZerosInColumn(int[][] input, int column) {
        for (int row = 0; row < input.length; row++) {
            if (input[row][column] != 0) {
                input[row][column] = -1;
            }
        }
    }
}
