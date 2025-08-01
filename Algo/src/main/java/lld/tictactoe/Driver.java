package lld.tictactoe;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Board board = new Board();
        Player player1 = new Player("1");
        Player player2 = new Player("2");

        player1.makeMove(board,1,2,"X");
        player2.makeMove(board,2,2,"0");

        player1.makeMove(board,1,1,"X");
        player2.makeMove(board,2,0,"0");

        player1.makeMove(board,1,0,"X");
        //player2.makeMove(board,0,2,"0");
    }
}
