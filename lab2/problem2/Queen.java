public class Queen extends Piece {
    public Queen(Position position, boolean isWhite) {
        super(position, isWhite);
    }
    @Override
    public boolean isLegalMove(Position b) {
        int fromRow = position.getRow();
        int fromCol = position.getCol();
        int toRow   = b.getRow();
        int toCol   = b.getCol();
        int dRow    = Math.abs(toRow - fromRow);
        int dCol    = Math.abs(toCol - fromCol);
        if (dRow == 0 && dCol == 0) return false; 
        if (fromRow == toRow || fromCol == toCol) return true;
        return dRow == dCol;
    }
    @Override
    public String getSymbol() { return isWhite ? "Q" : "q"; }
}
