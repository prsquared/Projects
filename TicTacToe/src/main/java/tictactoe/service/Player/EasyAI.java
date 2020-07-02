package tictactoe.service.Player;

import tictactoe.entity.Coordinate;
import tictactoe.entity.Symbol;
import tictactoe.enums.PlayerType;
import tictactoe.enums.ValidationStatus;
import tictactoe.interfaces.IPlayer;

import java.util.Random;

public class EasyAI implements IPlayer {

    Symbol symbol;

    public EasyAI(Symbol symbol) {
        this.symbol = symbol;
    }

    @Override
    public Coordinate getMove() {
        Random random = new Random(System.currentTimeMillis());

        int xVal = random.nextInt(3) + 1;
        int yVal = random.nextInt(3) + 1;

        return new Coordinate(3-yVal,xVal-1);
    }

    @Override
    public void onInvalidCoordinate(ValidationStatus status) {

    }


    @Override
    public PlayerType getPlayerType() {
        return PlayerType.COMPUTER;
    }

    @Override
    public Symbol getSymbol() {
        return symbol;
    }

    @Override
    public void onCompletion() {
        System.out.println("Making move level \"easy\"");
    }
}
