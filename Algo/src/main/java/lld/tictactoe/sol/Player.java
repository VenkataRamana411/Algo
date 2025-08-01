package lld.tictactoe.sol;

public class Player {
    public String name;

    public Symbol symbol;

    public PlayerStrategy playerStrategy;

    public Player(String name, Symbol symbol, PlayerStrategy playerStrategy) {
        this.name = name;
        this.symbol = symbol;
        this.playerStrategy = playerStrategy;
    }
}
