package tictactoe.entity.Player;

import tictactoe.entity.Board;
import tictactoe.entity.Coordinate;
import tictactoe.entity.Symbol;

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
        return  board.getIdealSquare();
    }
}
