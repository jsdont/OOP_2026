public class Bishop extends Piece {
    public Bishop(Position position, boolean isWhite) {
        super(position, isWhite);
    }
    @Override
    public boolean isLegalMove(Position b) {
        int dRow = Math.abs(b.getRow() - position.getRow());
        int dCol = Math.abs(b.getCol() - position.getCol());
        if (dRow == 0 && dCol == 0) return false; 
        return dRow == dCol;
    }
    @Override
    public String getSymbol() { return isWhite ? "B" : "b"; }
}
