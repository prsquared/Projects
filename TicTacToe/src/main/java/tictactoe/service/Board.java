package tictactoe.service;

import tictactoe.entity.Coordinate;
import tictactoe.entity.Square;
import tictactoe.entity.Symbol;
import tictactoe.enums.GameStatus;
import tictactoe.enums.ValidationStatus;

public class Board {

    Square[][] squares = new Square[3][3];

    public void initialize() {
        int rowCount = 0;
        for (int i = 0; i < 9; i++) {
            squares[rowCount][i % 3] = new Square(rowCount, i % 3);
            if ((i + 1) % 3 == 0) {
                rowCount++;
            }
        }
    }

    public void initialize(String string) {
        int rowCount = 0;
        for (int i = 0; i < 9; i++) {
            squares[rowCount][i % 3] = new Square(rowCount, i % 3, string.charAt(i));
            if ((i + 1) % 3 == 0) {
                rowCount++;
            }
        }
    }

    public ValidationStatus getSquareValidity(Coordinate coordinate) {
        if (squares[coordinate.getX()][coordinate.getY()].isOccupied()) {
            return ValidationStatus.SQUARE_OCCUPIED;
        }
        return ValidationStatus.VALID;
    }

    public void placeSymbol(Square square, Symbol symbol) {
        square.addSymbol(symbol);
        Coordinate coordinate = square.getPoint();
        squares[coordinate.getX()][coordinate.getY()] = square;
    }

    public void display() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + squares[i][j].getSymbol().getSymbolType());
            }
            System.out.println(" |");
        }
        System.out.println("---------");
    }

    //Core Validation logic. Might need refactoring
    public GameStatus getStatus() {
        int[] rowSum = new int[3];
        int[] colSum = new int[3];
        int[] diagSum = new int[2];
        int xCount = 0;
        int oCount = 0;
        int _Count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (squares[i][j].getSymbol().getSymbolType() == 'X') {
                    xCount++;
                } else if (squares[i][j].getSymbol().getSymbolType() == 'O') {
                    oCount++;
                } else {
                    _Count++;
                }
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
        if (Math.abs(xCount - oCount) > 1) {
            return GameStatus.IMPOSSIBLE;
        }
        boolean xWins = false;
        boolean oWins = false;
        for (int i = 0; i < 3; i++) {
            if (rowSum[i] == 3 * 'X' || colSum[i] == 3 * 'X') {
                xWins = true;
            } else if (rowSum[i] == 3 * 'O' || colSum[i] == 3 * 'O') {
                oWins = true;
            }
        }
        for (int i = 0; i < 2; i++) {
            if (diagSum[i] == 3 * 'X') {
                xWins = true;
            } else if (diagSum[i] == 3 * 'O') {
                oWins = true;
            }
        }
        if (xWins && oWins) {
            return GameStatus.IMPOSSIBLE;
        } else if (xWins) {
            return GameStatus.X_WINS;
        } else if (oWins) {
            return GameStatus.O_WINS;
        } else if (_Count > 0) {
            return GameStatus.NOT_FINISHED;
        }
        return GameStatus.DRAW;
    }

    public boolean isMovesLeft() {
        int _Count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (squares[i][j].getSymbol().getSymbolType() == '_') {
                    _Count++;
                }
            }
        }
        return _Count > 0;
    }

    public Square[][] getSquares() {
        return squares;
    }
}
