package tictactoe.util;

import tictactoe.entity.Record;
import tictactoe.enums.GameStatus;
import tictactoe.service.Board;

public class Test {
    public static void main(String[] args) {
        Board board = new Board();
        String[][] inputs = {{"start", "hard", "medium"}};
        Record[] players = new Record[3];
        players[0] = new Record("Hard AI");
        players[1] = new Record("Medium AI");
            for (int i = 0; i < 100; i++) {
                System.out.println("Input command:");
                board.initialize();
                Game game = new Game();
                game.setBoard(board);
                game.initializePlayers(inputs[0]);
                GameStatus status = game.simulateGame();
                if (GameStatus.X_WINS.equals(status)) {
                    players[0].setWinCount(players[0].getWinCount() + 1);
                    players[1].setLoseCount(players[1].getLoseCount() + 1);
                } else if (GameStatus.O_WINS.equals(status)) {
                    players[1].setWinCount(players[1].getWinCount() + 1);
                    players[0].setLoseCount(players[0].getLoseCount() + 1);
                } else {
                    players[0].setDrawCount(players[0].getDrawCount() + 1);
                    players[1].setDrawCount(players[1].getDrawCount() + 1);
                }
            }

        System.out.println(players[0]);
        System.out.println(players[1]);
    }
}
