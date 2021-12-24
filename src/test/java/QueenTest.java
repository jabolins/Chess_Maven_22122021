import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueenTest {

    @Test
    void getSymbol() {
        Queen queen = new Queen("White");
        assertEquals(queen.getSymbol(), "Q");

    }

    @Test
    void canMoveToPosition() {

    }

    @Test
    void moveAsQueenDiagonalTrue() {
        Queen queen = new Queen("White");
        ChessBoard chessBoard= new ChessBoard("Player1");
        assertTrue(queen.canMoveToPosition(chessBoard,3,2,7,6));
        assertTrue(queen.canMoveToPosition(chessBoard,2,2,2,6));
    }

    @Test
    void moveAsBishopDiagonalFalse() {
        Queen queen = new Queen("White");
        ChessBoard chessBoard= new ChessBoard("Player1");
        assertFalse(queen.canMoveToPosition(chessBoard,3,2,6,6));
    }


    @Test
    void moveAsBishopIsFieldsFreeFalse(){
        Queen queen = new Queen("White");
        ChessBoard chessBoard= new ChessBoard("Player1");
        Queen qeen1 = new Queen("White");
        chessBoard.board[4][4]=qeen1;
        assertFalse(queen.canMoveToPosition(chessBoard,3,3, 7, 7));
    }

    @Test
    void moveAsBishopIsFieldsFreeTrue(){
        Queen queen = new Queen("White");
        ChessBoard chessBoard= new ChessBoard("Player1");
        Queen qeen1 = new Queen("Black");
        chessBoard.board[4][4]=qeen1;
        assertTrue(queen.canMoveToPosition(chessBoard,3,3, 4, 4));
    }
}