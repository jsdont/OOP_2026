public class Knight extends Piece {
    public Knight(Position position, boolean isWhite) {
        super(position, isWhite);
    }
    @Override
    public boolean isLegalMove(Position b) {
        int dRow = Math.abs(b.getRow() - position.getRow());
        int dCol = Math.abs(b.getCol() - position.getCol());
        return (dRow == 2 && dCol == 1) || (dRow == 1 && dCol == 2);
    }
    @Override
    public String getSymbol() { return isWhite ? "N" : "n"; }
}
