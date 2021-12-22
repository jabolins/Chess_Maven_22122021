import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ChessPieceTest {

    @Test
    public void isMoveInsideBoardTrue() {
        ChessPiece chessPiece = Mockito.mock(
                ChessPiece.class,
                Mockito.CALLS_REAL_METHODS);
        assertTrue(chessPiece.isMoveInsideBoard(2, 2, 3, 3));

    }

    @Test
    public void isMoveInsideBoardFalse() {
        ChessPiece chessPiece = Mockito.mock(
                ChessPiece.class,
                Mockito.CALLS_REAL_METHODS);
        assertFalse(chessPiece.isMoveInsideBoard(-1, 2, 3, 3));
        assertFalse(chessPiece.isMoveInsideBoard(1, -1, 3, 3));
        assertFalse(chessPiece.isMoveInsideBoard(2, 2, -1, 3));
        assertFalse(chessPiece.isMoveInsideBoard(2, 2, 3, -2));
        assertFalse(chessPiece.isMoveInsideBoard(2, 2, 3, -2));

        assertFalse(chessPiece.isMoveInsideBoard(8, 2, 3, -2));
        assertFalse(chessPiece.isMoveInsideBoard(2, 8, 3, -2));
        assertFalse(chessPiece.isMoveInsideBoard(2, 2, 8, -2));
        assertFalse(chessPiece.isMoveInsideBoard(2, 2, 3, 8));
    }

    @Test
    public void isStartEndDifferentTrue() {
        ChessPiece chessPiece = Mockito.mock(
                ChessPiece.class,
                Mockito.CALLS_REAL_METHODS);
        assertTrue(chessPiece.isStartEndDifferent(3, 2, 2, 2));
        assertTrue(chessPiece.isStartEndDifferent(2, 3, 2, 2));
        assertTrue(chessPiece.isStartEndDifferent(2, 2, 3, 2));
        assertTrue(chessPiece.isStartEndDifferent(2, 2, 2, 3));
    }

    @Test
    public void isStartEndDifferentFalse() {
        ChessPiece chessPiece = Mockito.mock(
                ChessPiece.class,
                Mockito.CALLS_REAL_METHODS);
        assertFalse(chessPiece.isStartEndDifferent(2, 4, 2, 4));
    }

}