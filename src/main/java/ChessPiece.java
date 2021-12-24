public abstract class ChessPiece {

    /**
     * color of piece White or Black
     */
    String color;

    /**
     * Was piece moved. If not- true. If yes-false. Use for King and Rook.
     */
    boolean check = true;

    public ChessPiece(String color) {
        this.color = color;
    }

    /**
     * check - can move piece according chess rules. For each chess pieces different.
     *
     * @param chessBoard
     * @param startLine   0-7 start position horizontal
     * @param startColumn 0-7 start position vertical
     * @param endLine     0-7 end position horizontal
     * @param endColumn   0-7 end position vertical
     * @return tru if move is possible according chess rules
     */
    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int startLine, int startColumn, int endLine, int endColumn);

    /**
     * every piece have unique symbol (K, Q, R, B, H, P)
     *
     * @return piece symbol
     */
    public abstract String getSymbol();

    public String getColor() {
        return color;
    }

    /**
     * check is start and end positions between 0-7 (inside board)
     *
     * @param startLine
     * @param startColumn
     * @param endLine
     * @param endColumn
     * @return true if positions is inside board
     */
    protected boolean isMoveInsideBoard(int startLine, int startColumn, int endLine, int endColumn) {
        if (startLine < 0 || startLine > 7
                || startColumn < 0 || startColumn > 7
                || endLine < 0 || endLine > 7
                || endColumn < 0 || endColumn > 7) {
            return false;
        }

        return true;
    }

    /**
     * check is end position different from end position
     *
     * @param startLine
     * @param startColumn
     * @param endLine
     * @param endColumn
     * @return tru if start/end positions are different
     */
    protected boolean isStartEndDifferent(int startLine, int startColumn, int endLine, int endColumn) {
        if (startLine == endLine && startColumn == endColumn) {
            return false;
        }

        return true;
    }

    /**
     * check end positions- are there piece with the same color (move is not allow)
     *
     * @param endLine
     * @param endColumn
     * @param chessBoard
     * @return return true if on end positions is piece with the same color.
     */
    protected boolean isMoveEndSameColor(int endLine, int endColumn, ChessBoard chessBoard) {
        if (chessBoard.board[endLine][endColumn] != null && chessBoard.board[endLine][endColumn].getColor().equals(color)) {
            return true;
        }

        return false;
    }

}
