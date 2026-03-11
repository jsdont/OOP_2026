public class Rook extends Piece {
    public Rook(Position position, boolean isWhite) {
        super(position, isWhite);
    }
    @Override
    public boolean isLegalMove(Position b) {
        int fromRow = position.getRow();
        int fromCol = position.getCol();
        int toRow   = b.getRow();
        int toCol   = b.getCol();
        if (fromRow == toRow && fromCol == toCol) return false; 
        return fromRow == toRow || fromCol == toCol;
    }
    @Override
    public String getSymbol() { return isWhite ? "R" : "r"; }
}
