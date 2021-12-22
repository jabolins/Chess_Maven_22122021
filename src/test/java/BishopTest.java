import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BishopTest {

    @Test
    void getSymbol() {
        Bishop bishop = new Bishop("White");
        assertEquals(bishop.getSymbol(),"B");
    }


    @Test
    void moveAsBishopDiagonalTrue() {
        Bishop bishop = new Bishop("White");
        ChessBoard chessBoard= new ChessBoard("Player1");
        assertTrue(bishop.canMoveToPosition(chessBoard,3,2,7,6));
        assertTrue(bishop.canMoveToPosition(chessBoard,6,5,3,2));
    }

    @Test
    void moveAsBishopDiagonalFalse() {
        Bishop bishop = new Bishop("White");
        ChessBoard chessBoard= new ChessBoard("Player1");
        assertFalse(bishop.canMoveToPosition(chessBoard,3,2,6,6));
        assertFalse(bishop.canMoveToPosition(chessBoard,6,5,3,3));
    }


    @Test
    void moveAsBishopIsFieldsFreeFalse(){
        Bishop bishop = new Bishop("White");
        Bishop bishop1 = new Bishop("White");
        ChessBoard chessBoard= new ChessBoard("Player1");
        chessBoard.board[4][4]=bishop1;
        assertFalse(bishop.canMoveToPosition(chessBoard,3,3, 7, 7));
    }

    @Test
    void moveAsBishopIsFieldsFreeTrue(){
        Bishop bishop = new Bishop("White");
        Bishop bishop1 = new Bishop("Black");
        ChessBoard chessBoard= new ChessBoard("Player1");
        chessBoard.board[4][4]=bishop1;
        assertTrue(bishop.canMoveToPosition(chessBoard,1,1, 4, 4));
    }


}