package tictactoe.entity;

public class Symbol {
    private char symbolType;

    public Symbol(char symbolType) {
        this.symbolType = symbolType;
    }

    public char getSymbolType() {
        return symbolType;
    }

    public void setSymbolType(char symbolType) {
        this.symbolType = symbolType;
    }

    public boolean equals(Symbol other) {
        return other.getSymbolType() == this.getSymbolType();
    }

    public static Symbol getOtherPlayerSymbol(Symbol playerSymbol) {
        return playerSymbol.getSymbolType() == 'X' ?
                new Symbol('O')
                :playerSymbol.getSymbolType() == 'O' ?
                new Symbol('X') : null;
    }
}
