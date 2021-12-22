import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest {

    @Test
    void getColorWhite() {
        Pawn pawn = new Pawn("White");
        String expectedValue = "White";
        assertEquals(expectedValue, pawn.getColor());
    }

    @Test
    void getColorBlack() {
        Pawn pawn = new Pawn("Black");
        String expectedValue = "Black";
        assertEquals(expectedValue, pawn.getColor());
    }

    @Test
    void getSymbol() {
        Pawn pawn = new Pawn("White");
        assertEquals(pawn.getSymbol(),"P");
    }

    @Test
    void moveTheSameColorWhite() {
        ChessBoard chessBoard = new ChessBoard("Player1");
        Pawn pawn = new Pawn("White");
        Pawn pawn1 = new Pawn("White");
        chessBoard.board[4][4]=pawn1;
        assertFalse(pawn.canMoveToPosition(chessBoard,3,4,4,4), "End position the same color");
        assertTrue(pawn.canMoveToPosition(chessBoard,2,4,3,4), "End position the same color");
    }


    @Test
    void moveAsPawnBasicMoveTrue() {
        ChessBoard chessBoard = new ChessBoard("Player1");
        Pawn pawn = new Pawn("White");

        assertTrue(pawn.canMoveToPosition(chessBoard,3,3,4,3));
    }

    @Test
    void moveAsPawnBasicMoveFalse() {
        ChessBoard chessBoard = new ChessBoard("Player1");
        Pawn pawn = new Pawn("White");
        assertFalse(pawn.canMoveToPosition(chessBoard,3,3,5,3));
        assertFalse(pawn.canMoveToPosition(chessBoard,3,3,4,4));
    }

    @Test
    void moveAsPawnCaptureMoveTrue() {
        ChessBoard chessBoard = new ChessBoard("Player1");
        Pawn pawn = new Pawn("White");
        Pawn pawn1=new Pawn ("Black");
        chessBoard.board[4][5]=pawn1;
        assertTrue(pawn.canMoveToPosition(chessBoard,3,4,4,5));;
    }

    @Test
    void moveAsPawnCaptureMoveFalse() {
        ChessBoard chessBoard = new ChessBoard("Player1");
        Pawn pawn = new Pawn("White");
        Pawn pawn1=new Pawn ("White");
        chessBoard.board[4][5]=pawn1;
        assertFalse(pawn.canMoveToPosition(chessBoard,3,4,4,5));;
    }

    @Test
    void moveAsPawnCaptureMoveFalseNullPosition() {
        ChessBoard chessBoard = new ChessBoard("Player1");
        Pawn pawn = new Pawn("White");
        assertFalse(pawn.canMoveToPosition(chessBoard,3,4,4,5));;
    }

    @Test
    void moveAsPawnFirstMoveTrue() {
        ChessBoard chessBoard = new ChessBoard("Player1");
        Pawn pawn = new Pawn("White");
        assertTrue(pawn.canMoveToPosition(chessBoard,1,4,3,4));;
    }

    @Test
    void moveAsPawnFirstMoveTrueBlack() {
        ChessBoard chessBoard = new ChessBoard("Player1");
        Pawn pawn = new Pawn("Black");
        assertTrue(pawn.canMoveToPosition(chessBoard,6,4,4,4));;
    }

    @Test
    void moveAsPawnFirstMoveFalse() {
        ChessBoard chessBoard = new ChessBoard("Player1");
        Pawn pawn = new Pawn("White");
        Pawn pawn1=new Pawn ("White");
        chessBoard.board[2][4]=pawn1;
        assertFalse(pawn.canMoveToPosition(chessBoard,1,4,3,4));;
        chessBoard.board[3][5]=pawn1;
        assertFalse(pawn.canMoveToPosition(chessBoard,1,5,3,5));;

    }


//    @Test
//    void moveAsHorse2() {
//        ChessBoard chessBoard = new ChessBoard("Player1");
//        Horse horse = new Horse("White");
//        assertFalse(horse.canMoveToPosition(chessBoard,5,6,6,3), "End positon incorrect");
//    }



}