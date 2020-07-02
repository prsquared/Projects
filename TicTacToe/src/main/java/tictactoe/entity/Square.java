package tictactoe.entity;

public class Square {
    private Symbol symbol;
    private boolean occupied;
    Coordinate point;

    public Square(int x, int y) {
        this.symbol = new Symbol('_');
        this.occupied = false;
        this.point = new Coordinate(x,y);
    }

    public Square(int x, int y, char symbol) {
        this.symbol = new Symbol(symbol);
        this.occupied = false;
        this.point = new Coordinate(x,y);
    }

    public Square(Coordinate coordinate) {
        this.symbol = new Symbol('_');
        this.occupied = false;
        this.point = new Coordinate(coordinate.getX(),coordinate.getY());
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public Coordinate getPoint() {
        return point;
    }

    public void setPoint(Coordinate point) {
        this.point = point;
    }
    public void addSymbol(Symbol symbol){
        setSymbol(symbol);
        setOccupied(true);
    }
    public void testSymbol(Symbol symbol){
        setSymbol(symbol);
    }
    public void testSymbol(char sChar){
        Symbol symbol = new Symbol(sChar);
        setSymbol(symbol);
    }
}
