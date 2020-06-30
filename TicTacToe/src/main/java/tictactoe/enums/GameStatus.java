package tictactoe.enums;

public enum GameStatus {
    X_WINS("X wins"),
    O_WINS("O wins"),
    DRAW("Draw"),
    IMPOSSIBLE("Impossible"),
    NOT_FINISHED("Game not finished");

    private String gameStatus;

    GameStatus(String s) {
        this.gameStatus = s;
    }

    public String getGameStatus() {
        return gameStatus;
    }
}
