package lld.tictactoe;

import java.util.Arrays;

public class Board {
    String[][] board;

    public Board() {
        this.board = new String[3][3];
        boardReset();
    }

    public boolean makeMove(int row, int col, String value) throws IllegalArgumentException {
        if (isValidMove(row, col)) {
            board[row][col] = value;
            return resultDetection(row, col);
        } else {
            throw new IllegalArgumentException("Invalid Move!. Please try again");
        }
    }

    public boolean resultDetection(int row, int col) {
        if (board[row][0].equals(board[row][1]) && board[row][1].equals(board[row][2])) {
            return true;
        } else if (board[0][col].equals(board[1][col]) && board[1][col].equals(board[2][col])) {
            return true;
        } else if (row == col && (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]))) {
            return true;
        } else if (row + col == 2 && ((board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0])))) {
            return true;
        }
        return false;
    }

    public boolean isValidMove(int row, int col) {
        return row >= 0 && row <= 2 && col >= 0 && col <= 2 && board[row][col].equals("*");
    }

    public void printCurrentState() {
        for (String[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }

    public void boardReset() {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                board[i][j] = "*";
            }
        }
    }
}
