package lld.tictactoe.sol;

public class PlayerFactory {

    public Player getPlayer(String name, Symbol symbol, PlayerStrategy playerStrategy) {
        return new Player(name, symbol, playerStrategy);
    }


}
