public class TestProblem2 {
    public static void main(String[] args) {
        System.out.println("===== Problem 2: Chess Pieces =====\n");
        Rook rook = new Rook(new Position(0, 0), true); 
        System.out.println(rook);
        System.out.println("Rook a1 -> a5 (vertical): " + rook.isLegalMove(new Position(4, 0)));   
        System.out.println("Rook a1 -> h1 (horizontal): " + rook.isLegalMove(new Position(0, 7))); 
        System.out.println("Rook a1 -> b2 (diagonal): " + rook.isLegalMove(new Position(1, 1)));   
        System.out.println();
        Bishop bishop = new Bishop(new Position(3, 2), true); 
        System.out.println(bishop);
        System.out.println("Bishop c4 -> f7 (diagonal): " + bishop.isLegalMove(new Position(6, 5))); 
        System.out.println("Bishop c4 -> a2 (diagonal): " + bishop.isLegalMove(new Position(1, 0))); 
        System.out.println("Bishop c4 -> c7 (vertical): " + bishop.isLegalMove(new Position(6, 2))); 
        System.out.println();
        Queen queen = new Queen(new Position(3, 3), true); 
        System.out.println(queen);
        System.out.println("Queen d4 -> d8 (vertical): "  + queen.isLegalMove(new Position(7, 3))); 
        System.out.println("Queen d4 -> h4 (horizontal): " + queen.isLegalMove(new Position(3, 7))); 
        System.out.println("Queen d4 -> g7 (diagonal): "  + queen.isLegalMove(new Position(6, 6))); 
        System.out.println("Queen d4 -> e6 (invalid): "   + queen.isLegalMove(new Position(5, 4))); 
        System.out.println();
        King king = new King(new Position(0, 4), true); 
        System.out.println(king);
        System.out.println("King e1 -> e2 (one step up): " + king.isLegalMove(new Position(1, 4)));  
        System.out.println("King e1 -> d2 (diagonal): "   + king.isLegalMove(new Position(1, 3)));  
        System.out.println("King e1 -> e3 (two steps): "  + king.isLegalMove(new Position(2, 4)));  
        System.out.println();
        Knight knight = new Knight(new Position(4, 4), false); 
        System.out.println(knight);
        System.out.println("Knight e5 -> f7 (L-shape): "  + knight.isLegalMove(new Position(6, 5))); 
        System.out.println("Knight e5 -> d3 (L-shape): "  + knight.isLegalMove(new Position(2, 3))); 
        System.out.println("Knight e5 -> e7 (straight): " + knight.isLegalMove(new Position(6, 4))); 
        System.out.println();
        Pawn pawnWhite = new Pawn(new Position(1, 0), true); 
        System.out.println(pawnWhite);
        System.out.println("Pawn a2 -> a3 (1 step forward): " + pawnWhite.isLegalMove(new Position(2, 0))); 
        System.out.println("Pawn a2 -> a4 (2 step first move): " + pawnWhite.isLegalMove(new Position(3, 0))); 
        System.out.println("Pawn a2 -> b3 (diagonal capture): " + pawnWhite.isLegalMove(new Position(2, 1))); 
        System.out.println("Pawn a2 -> a1 (backward): " + pawnWhite.isLegalMove(new Position(0, 0))); 
        pawnWhite.markMoved();
        System.out.println("After first move - Pawn a2 -> a4 (2 steps, no longer valid): "
                + pawnWhite.isLegalMove(new Position(3, 0))); 
    }
}
