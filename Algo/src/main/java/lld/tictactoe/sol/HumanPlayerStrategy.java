package lld.tictactoe.sol;

import java.util.Scanner;

public class HumanPlayerStrategy implements PlayerStrategy{

    Scanner sc;

    public HumanPlayerStrategy() {
        this.sc = new Scanner(System.in);
    }

    @Override
    public Position makeMove(Board board) {

        while (true){
            System.out.println("Enter you move with row and column");
            try {
                int row = sc.nextInt();
                int col = sc.nextInt();
                Position position = new Position(row,col);
                if (board.isValidMove(position)){
                    return position;
                }
                System.out.println("Invalid Move!. Try again");
            }catch (Exception e){
                System.out.println("Invalid Input. Please try again");
                sc.nextLine();
            }
        }

    }
}
