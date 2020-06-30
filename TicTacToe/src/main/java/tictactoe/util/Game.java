package tictactoe.util;

import tictactoe.entity.Board;
import tictactoe.entity.Coordinate;
import tictactoe.entity.Player.EasyAI;
import tictactoe.entity.Player.HumanPlayer;
import tictactoe.entity.Square;
import tictactoe.entity.Symbol;
import tictactoe.enums.GameStatus;
import tictactoe.enums.ValidationStatus;
import tictactoe.entity.Player.interfaces.IPlayer;

import java.util.Scanner;

public class Game {
    private Board board = new Board();
    private IPlayer[] players = new IPlayer[2];
    private static final Scanner scanner = new Scanner(System.in);

    public void start() {
        String input = "";
        do {
            System.out.println("Input command:");
            input = scanner.nextLine();
            String[] inputs = input.split("\\s+");
            if (!isValid(inputs)) {
                System.out.println("Bad parameters!");
                continue;
            }
            if (!"exit".equals(input)) {
                board.initialize();
                initializePlayers(inputs);
                playGame();
            }
        } while (!"exit".equals(input));
    }

    private void initializePlayers(String[] inputs) {
        for (int i = 1; i < 3; i++) {
            if ("user".equals(inputs[i])) {
                players[i-1] = new HumanPlayer(getSymbol(i));
            } else {
                players[i-1] = new EasyAI(getSymbol(i));
            }
        }
    }

    private Symbol getSymbol(int index){
        return index == 1 ? new Symbol('X') : new Symbol('O');
    }

    private static boolean isValid(String[] inputs) {
        if (inputs.length == 3 && isValidInput3(inputs)) {
            return true;
        } else if (inputs.length == 1 && "exit".equals(inputs[0])) {
            return true;
        }
        return false;
    }

    private static boolean isValidInput3(String[] inputs) {
        if (!"start".equals(inputs[0])) {
            return false;
        }
        for (int i = 1; i < 3; i++) {
            if (!"easy".equals(inputs[i]) && !"user".equals(inputs[i])) {
                return false;
            }
        }
        return true;
    }

    public void playGame() {
        boolean isXMove = true;
        board.display();
        IPlayer player = null;
        do {
            player = isXMove ? players[0] : players[1];
            Coordinate coordinate = player.getMove();
            ValidationStatus validationStatus = board.getSquareValidity(coordinate);
            if(!validationStatus.isValid()){
                player.onInvalidCoordinate(validationStatus);
                continue;
            }
            Square square = new Square(coordinate);
            board.placeSymbol(square,player.getSymbol());
            GameStatus status = board.getStatus();
            board.display();
            if (status.equals(GameStatus.X_WINS) || status.equals(GameStatus.O_WINS)
                    || status.equals(GameStatus.DRAW)) {
                System.out.println(status.getGameStatus());
                break;
            }
            isXMove = !isXMove;
        } while (true);
    }


}
