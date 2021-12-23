import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RookTest {


    @Test
    void getSymbol() {
        Rook rook = new Rook("White");
        assertEquals(rook.getSymbol(),"R");
    }

    @Test
    void moveAsRookStrightTrue(){
        Rook rook = new Rook("White");
        ChessBoard chessBoard = new ChessBoard("Player2");
        assertTrue(rook.canMoveToPosition(chessBoard,3,7,6,7));
        assertTrue(rook.canMoveToPosition(chessBoard,3,6,3,1));
    }

    @Test
    void moveAsRookStrightFalse(){
        Rook rook = new Rook("White");
        ChessBoard chessBoard = new ChessBoard("Player2");
        assertFalse(rook.canMoveToPosition(chessBoard,3,6,6,7));
    }

    @Test
    void moveAsRookFieldsFreeFalse(){
        Rook rook = new Rook("White");
        Rook rook1 = new Rook("White");
        ChessBoard chessBoard = new ChessBoard("Player1");
        chessBoard.board[3][3]=rook1;
        assertFalse(rook.canMoveToPosition(chessBoard,3,7,3, 1));
        assertFalse(rook.canMoveToPosition(chessBoard,1,3,6,3));
    }

    @Test
    void moveAsRookFieldsFreeTrue(){
        Rook rook = new Rook("White");
        Rook rook1 = new Rook("Black");
        ChessBoard chessBoard = new ChessBoard("Player1");
        chessBoard.board[3][3]=rook1;
        assertTrue(rook.canMoveToPosition(chessBoard,3,7,3, 3));
    }

}