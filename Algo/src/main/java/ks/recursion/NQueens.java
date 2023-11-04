package ks.recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        int[][] board = new int[4][4];
        List<int[][]> list = new ArrayList<>();
        helper(0, board, list, n);
        System.out.println(list);
    }

    private static void helper(int column, int[][] board, List<int[][]> result, int n) {
        if (column == n) {
            result.add(board);
            System.out.println(board);
            return;
        }
        for (int row = 0; row < n; row++) {
            if (isSafe(row, column, board, n)) {
                board[row][column] = 1;
                helper(column + 1, board, result, n);
                board[row][column] = 0;
            }
        }
    }

    private static boolean isSafe(int row, int column, int[][] board, int n) {
        int dColumn = column;
        int dRow = row;
        while (column >= 0 && row >= 0) {
            if (board[row][column] == 1) {
                return false;
            }
            column--;
            row--;
        }
        row = dRow;
        column = dColumn;
        while (column >= 0) {
            if (board[row][column] == 1) {
                return false;
            }
            column--;
        }
        column = dColumn;
        while (column >= 0 && row < n) {
            if (board[row][column] == 1) {
                return false;
            }
            column--;
            row++;
        }
        return true;
    }
}
