public class King extends Piece {
    public King(Position position, boolean isWhite) {
        super(position, isWhite);
    }
    @Override
    public boolean isLegalMove(Position b) {
        int dRow = Math.abs(b.getRow() - position.getRow());
        int dCol = Math.abs(b.getCol() - position.getCol());
        if (dRow == 0 && dCol == 0) return false; 
        return dRow <= 1 && dCol <= 1;
    }
    @Override
    public String getSymbol() { return isWhite ? "K" : "k"; }
}
