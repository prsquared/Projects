package tictactoe.service.Player;

import tictactoe.entity.Coordinate;
import tictactoe.entity.Square;
import tictactoe.entity.Symbol;
import tictactoe.service.Board;

import java.util.Random;

public class HardAI extends EasyAI {
    Board board;

    public HardAI(Symbol symbol, Board board) {
        super(symbol);
        this.board = board;
    }

    @Override
    public Coordinate getMove() {
        return findBestCoordinate();
    }

    private int evaluate() {
        Square[][] squares = board.getSquares();
        // Rowwise victory check
        for (int row = 0; row < 3; row++) {
            if (squares[row][0].getSymbol().equals(squares[row][1].getSymbol()) &&
                    squares[row][1].getSymbol().equals(squares[row][2].getSymbol())) {
                if (squares[row][0].getSymbol().equals(this.getSymbol()))
                    return +10;
                else if (squares[row][0].getSymbol()
                        .equals(Symbol.getOtherPlayerSymbol(this.getSymbol())))
                    return -10;
            }
        }
        // Columnwise
        for (int col = 0; col < 3; col++) {
            if (squares[0][col].getSymbol().equals(squares[1][col].getSymbol()) &&
                    squares[1][col].getSymbol().equals(squares[2][col].getSymbol())) {
                if (squares[0][col].getSymbol().equals(this.getSymbol()))
                    return +10;

                else if (squares[0][col].getSymbol()
                        .equals(Symbol.getOtherPlayerSymbol(this.getSymbol())))
                    return -10;
            }
        }
        // Main diagonal victory check
        if (squares[0][0].getSymbol().equals(squares[1][1].getSymbol())
                && squares[1][1].getSymbol().equals(squares[2][2].getSymbol())) {
            if (squares[0][0].getSymbol().equals(this.getSymbol()))
                return +10;
            else if (squares[0][0].getSymbol()
                    .equals(Symbol.getOtherPlayerSymbol(this.getSymbol())))
                return -10;
        }

        //Cross diagonal victory check
        if (squares[0][2].getSymbol().equals(squares[1][1].getSymbol())
                && squares[1][1].getSymbol().equals(squares[2][0].getSymbol())) {
            if (squares[0][2].getSymbol().equals(this.getSymbol()))
                return +10;
            else if (squares[0][2].getSymbol()
                    .equals(Symbol.getOtherPlayerSymbol(this.getSymbol())))
                return -10;
        }
        // Else if none of them have won then return 0
        return 0;
    }

    private int minimax(int depth, Boolean isMax) {
        int score = evaluate();
        if (score == 10)
            return score;
        if (score == -10)
            return score;
        if (!board.isMovesLeft())
            return 0;
        if (isMax) {
            int best = -1000;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board.getSquares()[i][j].getSymbol().getSymbolType() == '_') {
                        board.getSquares()[i][j].testSymbol(this.getSymbol());
                        best = Math.max(best, minimax(
                                depth + 1, !isMax));
                        board.getSquares()[i][j].testSymbol('_');
                    }
                }
            }
            return best;
        } else {
            int best = 1000;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board.getSquares()[i][j].getSymbol().getSymbolType() == '_') {
                        board.getSquares()[i][j].testSymbol(Symbol.getOtherPlayerSymbol(this.symbol));
                        best = Math.min(best, minimax(
                                depth + 1, !isMax));
                        board.getSquares()[i][j].testSymbol('_');
                    }
                }
            }
            return best;
        }
    }
    public Coordinate findBestCoordinate()
    {
        int bestVal = -1000;
        Coordinate coordinate = new Coordinate(-1,-1);

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (board.getSquares()[i][j].getSymbol().getSymbolType() == '_')
                {
                    board.getSquares()[i][j].testSymbol(this.getSymbol());
                    int moveVal = minimax(0, false);
                    board.getSquares()[i][j].testSymbol('_');

                    if (moveVal > bestVal)
                    {
                        coordinate.setX(i);
                        coordinate.setY(j);
                        bestVal = moveVal;
                    }
                }
            }
        }
        return coordinate.getX() != -1? coordinate : randomize();
    }

    public Coordinate randomize() {
        Random random = new Random(System.currentTimeMillis());

        int xVal = random.nextInt(3) + 1;
        int yVal = random.nextInt(3) + 1;
        return new Coordinate(3-yVal,xVal-1);
    }
}
