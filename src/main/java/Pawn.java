public class Pawn extends ChessPiece {

    public Pawn(String color) {
        super(color);
    }

    /**
     * @return symbol of chess piece Pawn- "P"
     */
    @Override
    public String getSymbol() {
        return "P";
    }

    /**
     * check - can move piece according chess rules
     *
     * @param chessBoard
     * @param startLine   0-7 start position horizontal
     * @param startColumn 0-7 start position vertical
     * @param endLine     0-7 end position horizontal
     * @param endColumn   0-7 end position vertical
     * @return true if move is possible according chess rules
     */
    @Override
    public boolean canMoveToPosition(
            ChessBoard chessBoard
            , int startLine
            , int startColumn
            , int endLine
            , int endColumn) {

        if (!isStartEndDifferent(startLine, startColumn, endLine, endColumn)) return false;
        if (!isMoveInsideBoard(startLine, startColumn, endLine, endColumn)) return false;
        if (isMoveEndSameColor(endLine, endColumn, chessBoard)) return false;
        if (!correctStartPosition(startLine)) return false;
        if (canMoveAsPawn(startLine, startColumn, endLine, endColumn, chessBoard)) return true;

        return false;
    }

    /**
     * pawn have 3 kinds of move- basic (1 step forward), attack/capture (diagonal forward), first (2 steps forward)
     * check - is move according one of them.
     *
     * @param startLine
     * @param startColumn
     * @param endLine
     * @param endColumn
     * @param chessBoard
     * @return true if move is according pawn rules.
     */
    private boolean canMoveAsPawn(int startLine, int startColumn, int endLine, int endColumn, ChessBoard chessBoard) {

        if (basicMove(startLine, startColumn, endLine, endColumn, chessBoard)) {
            return true;
        }
        if (capturedMove(startLine, startColumn, endLine, endColumn, chessBoard)) {
            return true;
        }
        if (firstMove(startLine, startColumn, endLine, endColumn, chessBoard)) {
            return true;
        }

        return false;
    }

    private boolean basicMove(int startLine, int startColumn, int endLine, int endColumn, ChessBoard chessBoard) {
        if (getColor().equals("White")) {
            if (endLine == startLine + 1
                    && endColumn == startColumn
                    && chessBoard.board[endLine][endColumn] == null) {
                return true;
            }
        } else if (getColor().equals("Black")) {
            if (endLine == startLine - 1
                    && endColumn == startColumn
                    && chessBoard.board[endLine][endColumn] == null) {
                return true;
            }
        }
        return false;
    }

    private boolean capturedMove(int startLine, int startColumn, int endLine, int endColumn, ChessBoard chessBoard) {
        if (chessBoard.board[endLine][endColumn] == null) {
            return false;
        }

        if (getColor().equals("White")) {
            if (endLine == startLine + 1
                    && (endColumn == startColumn + 1 || endColumn == startColumn - 1)
                    && chessBoard.board[endLine][endColumn].getColor().equals("Black")) {
                return true;
            }
        } else if (getColor().equals("Black")) {
            if (endLine == startLine - 1
                    && (endColumn == startColumn + 1 || endColumn == startColumn - 1)
                    && chessBoard.board[endLine][endColumn].getColor().equals("White")) {
                return true;
            }
        }
        return false;
    }

    private boolean firstMove(int startLine, int startColumn, int endLine, int endColumn, ChessBoard chessBoard) {
        if (getColor().equals("White")) {
            if (startLine == 1
                    && endLine == 3
                    && endColumn == startColumn
                    && chessBoard.board[2][startColumn] == null
                    && chessBoard.board[3][startColumn] == null) {
                return true;
            }
        } else if (getColor().equals("Black")) {
            if (startLine == 6
                    && endLine == 4
                    && endColumn == startColumn
                    && chessBoard.board[5][startColumn] == null
                    && chessBoard.board[4][startColumn] == null) {
                return true;
            }
        }
        return false;
    }

    /**
     * check is pawn start position possible (not line 0 for white and not line 7 for black)
     *
     * @param startLine
     * @return true if pawn start position is according chess rules
     */
    private boolean correctStartPosition(int startLine) {
        if (getColor().equals("White")) {
            if (startLine == 0) {
                return false;
            }
        } else if (getColor().equals("Black")) {
            if (startLine == 7) {
                return false;
            }
        }
        return true;
    }

}
