package tictactoe.entity.Player.interfaces;

import tictactoe.entity.Coordinate;
import tictactoe.entity.Symbol;
import tictactoe.enums.PlayerType;
import tictactoe.enums.ValidationStatus;

public interface IPlayer {
    public Coordinate getMove();
    public void onInvalidCoordinate(ValidationStatus status);
    public PlayerType getPlayerType();
    public Symbol getSymbol();
    public void onCompletion();
}
