package lld.tictactoe.sol;

public class TicTacToeBoard implements BoardGame {

    public lld.tictactoe.sol.Board board;
    public Player playerX;
    public Player playerO;
    public Player currentPlayer;

    public TicTacToeBoard(int rows, int cols, PlayerStrategy playerXStrategy, PlayerStrategy playerOStrategy) {
        board = new Board(rows,cols);
        playerX = new Player("Ram",Symbol.X,playerXStrategy);
        playerO = new Player("Shyam",Symbol.O,playerOStrategy);
        this.currentPlayer = playerX;
    }

    @Override
    public void play() {

        while (true){
            board.printBoard();
            Position move = currentPlayer.playerStrategy.makeMove(board);
            board.makeMove(move,currentPlayer.symbol);
            if (board.isGameFinished() == GameState.COMPLETED || board.isGameFinished() == GameState.DRAW){
                announceResult();
                break;
            }
            switchPlayer();
        }

    }

    private void switchPlayer(){
        currentPlayer = currentPlayer == playerX ? playerO  :playerX;
    }

    private void announceResult(){
        board.printBoard();
        System.out.println("Game Completed");

    }
}
