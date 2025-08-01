package lld.tictactoe.sol;

public class Main {
    public static void main(String[] args) {
        TicTacToeBoard ticTacToeBoard = new TicTacToeBoard(3, 3, new HumanPlayerStrategy(), new HumanPlayerStrategy());
        ticTacToeBoard.play();
    }
}
