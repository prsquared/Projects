package tictactoe.service.Player;

import tictactoe.entity.Coordinate;
import tictactoe.entity.Square;
import tictactoe.entity.Symbol;
import tictactoe.service.Board;

import java.util.Random;

public class MediumAI extends  EasyAI{

    Board board;

    public MediumAI(Symbol symbol, Board board) {
        super(symbol);
        this.board = board;
    }

    @Override
    public Coordinate getMove() {

        Coordinate coordinate = mediumMove();
        if(coordinate == null) {
            coordinate = randomize();
        }
        return  coordinate;
    }

    public Coordinate randomize() {
        Random random = new Random(System.currentTimeMillis());

        int xVal = random.nextInt(3) + 1;
        int yVal = random.nextInt(3) + 1;
        return new Coordinate(3-yVal,xVal-1);
    }


    private Coordinate mediumMove(){
        return  getIdealSquare(board.getSquares());
    }
    public Coordinate getIdealSquare(Square[][] squares) {
        int[] rowSum = new int[3];
        int[] colSum = new int[3];
        int[] diagSum = new int[2];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                rowSum[i] += squares[i][j].getSymbol().getSymbolType();
                colSum[j] += squares[i][j].getSymbol().getSymbolType();
                if (i == j) {
                    diagSum[0] += squares[i][j].getSymbol().getSymbolType();
                }
                if (3 - (j + 1) == i) {
                    diagSum[1] += squares[i][j].getSymbol().getSymbolType();
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            if (rowSum[i] == 271 || rowSum[i] == 253) {
                for (int j = 0; j < 3; j++) {
                    if (squares[i][j].getSymbol().getSymbolType() == '_') {
                        return new Coordinate(i, j);
                    }
                }
            }
            if (colSum[i] == 271 || colSum[i] == 253) {
                for (int j = 0; j < 3; j++) {
                    if (squares[j][i].getSymbol().getSymbolType() == '_') {
                        return new Coordinate(j, i);
                    }
                }
            }
        }
        if (diagSum[0] == 271 || diagSum[0] == 253) {
            for (int j = 0; j < 3; j++) {
                if (squares[j][j].getSymbol().getSymbolType() == '_') {
                    return new Coordinate(j, j);
                }
            }
        }
        if (diagSum[1] == 271 || diagSum[1] == 253) {
            for (int j = 0; j < 3; j++) {
                if (squares[3 - (j + 1)][j].getSymbol().getSymbolType() == '_') {
                    return new Coordinate(3 - (j + 1), j);
                }
            }
        }
        return null;
    }
}
