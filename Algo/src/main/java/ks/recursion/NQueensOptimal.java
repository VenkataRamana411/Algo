package ks.recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueensOptimal {
    public static void main(String[] args) {
        int n = 4;
        int[][] board = new int[4][4];
        List<int[][]> list = new ArrayList<>();
        int[] leftRow = new int[n];
        int[] lowerDiagonal = new int[2 * n - 1];
        int[] upperDiagonal = new int[2 * n - 1];
        helper(0, board, list, leftRow, lowerDiagonal, upperDiagonal);
    }

    private static void helper(int column, int[][] board, List<int[][]> result, int[] leftRow, int[] lowerDiagonal, int[] upperDiagonal) {
        if (column == board.length) {
            result.add(board);
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("------------------");
            return;
        }
        for (int row = 0; row < board.length; row++) {
            if (leftRow[row] == 0 && lowerDiagonal[row + column] == 0 && upperDiagonal[board.length - 1 + column - row] == 0) {
                board[row][column] = 1;
                leftRow[row] = 1;
                lowerDiagonal[row + column] = 1;
                upperDiagonal[board.length - 1 + column - row] = 1;
                helper(column+1,board,result,leftRow,lowerDiagonal,upperDiagonal);
                board[row][column] = 0;
                leftRow[row] = 0;
                lowerDiagonal[row + column] = 0;
                upperDiagonal[board.length - 1 + column - row] = 0;

            }
        }
    }
}
