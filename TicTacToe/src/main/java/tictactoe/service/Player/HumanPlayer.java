package tictactoe.service.Player;

import tictactoe.entity.Coordinate;
import tictactoe.entity.Symbol;
import tictactoe.enums.PlayerType;
import tictactoe.enums.ValidationStatus;
import tictactoe.interfaces.IPlayer;

import java.util.Scanner;

public class HumanPlayer implements IPlayer {
    private static final Scanner scanner = new Scanner(System.in);

    Symbol symbol;

    public HumanPlayer(Symbol symbol) {
        this.symbol = symbol;
    }

    @Override
    public PlayerType getPlayerType() {
        return PlayerType.HUMAN;
    }

    @Override
    public Symbol getSymbol() {
        return symbol;
    }

    @Override
    public void onCompletion() {
    }

    @Override
    public Coordinate getMove() {
        String[] coordinateStr;
        boolean validInput = false;
        int x = 0;
        int y = 0;
        do {
            System.out.println("Enter the coordinates:");
            try {
                String input = scanner.nextLine();
                coordinateStr = input.split("\\s+");
                x = Integer.parseInt(coordinateStr[0]);
                y = Integer.parseInt(coordinateStr[1]);
                validInput = true;
            } catch (Exception ex) {
                System.out.println(ValidationStatus.INVALID_INPUT.getError());
                continue;
            }
            if (x > 3 || y > 3
                    || x < 1 || y < 1) {
                System.out.println(ValidationStatus.OUT_OF_BOUNDS.getError());
                validInput = false;
            }

        } while (!validInput);
        return new Coordinate(3 - y, x - 1);
    }

    @Override
    public void onInvalidCoordinate(ValidationStatus status) {
        System.out.println("This cell is occupied! Choose another one!");
    }
}
