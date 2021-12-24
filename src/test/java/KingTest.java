import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KingTest {

    @Test
    void getSymbol() {
        King king = new King("White");
        assertEquals(king.getSymbol(), "K");
    }

    @Test
    void canMoveAsKingTrue() {
        King king = new King("White");
        ChessBoard chessBoard = new ChessBoard("Playr2");
        assertTrue(king.canMoveToPosition(chessBoard, 3, 3, 4, 2));
        assertTrue(king.canMoveToPosition(chessBoard, 3, 3, 4, 3));
        assertTrue(king.canMoveToPosition(chessBoard, 3, 3, 4, 4));
        assertTrue(king.canMoveToPosition(chessBoard, 3, 3, 3, 2));
        assertTrue(king.canMoveToPosition(chessBoard, 3, 3, 3, 4));
        assertTrue(king.canMoveToPosition(chessBoard, 3, 3, 2, 2));
        assertTrue(king.canMoveToPosition(chessBoard, 3, 3, 2, 3));
        assertTrue(king.canMoveToPosition(chessBoard, 3, 3, 2, 4));
    }

    @Test
    void canMoveAsKingFalse() {
        King king = new King("White");
        ChessBoard chessBoard = new ChessBoard("Playr2");
        assertFalse(king.canMoveToPosition(chessBoard, 3, 3, 4, 5));
        assertFalse(king.canMoveToPosition(chessBoard, 3, 3, 1, 3));
    }

    @Test
    void isUnderAttackTrue(){
        King king = new King("white");
        Queen queen = new Queen("Black");
        Queen queen1 = new Queen("Black");
        ChessBoard chessBoard = new ChessBoard("Playr2");
        chessBoard.board[2][2]=queen;
        chessBoard.board[3][3]=queen1;
        assertTrue(king.isUnderAttack(chessBoard,6,6));
    }

    @Test
    void isUnderAttackFalse(){
        King king = new King("White");
        Queen queen = new Queen("Black");
        Queen queen1 = new Queen("White");
        ChessBoard chessBoard = new ChessBoard("Playr2");
        chessBoard.board[2][2]=queen;
        chessBoard.board[3][3]=queen1;
        assertFalse(king.isUnderAttack(chessBoard,6,6));
        assertFalse(king.isUnderAttack(chessBoard,5,6));
    }
}