public class Pawn extends Piece {
    private boolean hasMoved; 
    public Pawn(Position position, boolean isWhite) {
        super(position, isWhite);
        this.hasMoved = false;
    }
    @Override
    public boolean isLegalMove(Position b) {
        int fromRow = position.getRow();
        int fromCol = position.getCol();
        int toRow   = b.getRow();
        int toCol   = b.getCol();
        int dCol    = Math.abs(toCol - fromCol);
        int direction = isWhite ? 1 : -1;
        int dRow = (toRow - fromRow) * direction; 
        if (dCol == 0 && dRow == 1) return true;
        if (dCol == 0 && dRow == 2 && !hasMoved) return true;
        if (dCol == 1 && dRow == 1) return true; 
        return false;
    }
    public void markMoved() { this.hasMoved = true; }
    public boolean hasMoved() { return hasMoved; }
    @Override
    public String getSymbol() { return isWhite ? "P" : "p"; }
}
