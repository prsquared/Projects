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
}
