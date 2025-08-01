package lld.tictactoe.sol;

import java.util.Arrays;

public class Board {
    private Symbol[][] board;
    private final int rows;

    private final int cols;
    public int counter;

    public Board(int row, int col) {
        this.rows = row;
        this.cols = col;
        this.board = new Symbol[rows][cols];
        for (int i = 0; i < row; i++) {
            Arrays.fill(board[i], Symbol.EMPTY);
        }
        counter = 0;
    }

    public boolean isValidMove(Position position) {
        return position.getRow() >= 0 && position.getRow() < rows && position.getCol() >= 0 && position.getCol() < cols && board[position.getRow()][position.getCol()].equals(Symbol.EMPTY);
    }

    public void makeMove(Position position, Symbol symbol) {
        board[position.getRow()][position.getCol()] = symbol;
        counter++;
    }

    public GameState isGameFinished() {
        for (int i = 0; i < rows; i++) {
            if (board[i][0] != Symbol.EMPTY && isWinningLine(board[i])) {
                return GameState.COMPLETED;
            }
        }
        for (int i = 0; i < cols; i++) {
            if (board[0][i] != Symbol.EMPTY && isWinningColumn(board[0][i], i)) {
                return GameState.COMPLETED;
            }
        }
        if (counter >= rows * cols) {
            return GameState.DRAW;
        }
        return GameState.IN_PROGRESS;
    }

    private boolean isWinningLine(Symbol[] line) {
        Symbol first = line[0];
        for (Symbol s : line) {
            if (s != first) {
                return false;
            }
        }
        return true;
    }

    private boolean isWinningColumn(Symbol first, int column) {
        for (int i = 1; i < rows; i++) {
            if (board[i][column] != first) {
                return false;
            }
        }
        return true;
    }

    public void printBoard(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Symbol symbol = board[i][j];
                switch (symbol){
                    case O:
                        System.out.print("O");
                        break;
                    case X:
                        System.out.print("X");
                        break;
                    case EMPTY:
                        System.out.print("-");
                        break;
                    default:
                        System.out.println(".");
                }
            }
            System.out.println();
        }
    }
}
