package tictactoe.entity;

public class Record {
    String playerName;
    int winCount;
    int loseCount;
    int drawCount;

    public Record(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getWinCount() {
        return winCount;
    }

    public void setWinCount(int winCount) {
        this.winCount = winCount;
    }

    public int getLoseCount() {
        return loseCount;
    }

    public void setLoseCount(int loseCount) {
        this.loseCount = loseCount;
    }

    public int getDrawCount() {
        return drawCount;
    }

    public void setDrawCount(int drawCount) {
        this.drawCount = drawCount;
    }

    @Override
    public String toString() {
        return "Record{" +
                "playerName='" + playerName + '\'' +
                ", winCount=" + winCount +
                ", loseCount=" + loseCount +
                ", drawCount=" + drawCount +
                '}';
    }
}
