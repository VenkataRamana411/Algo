package lld.tictactoe;

public class Player implements PlayerInt {
    String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public void makeMove(Board board,int row,int col,String move) {
        try {
            if (board.makeMove(row,col,move)){
                board.printCurrentState();
                System.out.println("Player: "+name+"Wins!!");
            }else {
                board.printCurrentState();
                System.out.println("Next Move!!");
            }
        }catch (IllegalArgumentException e){
            System.out.println("Invalid Move! Please try again");
        }

    }
}
