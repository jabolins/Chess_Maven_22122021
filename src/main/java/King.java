public class King extends ChessPiece {

    public King(String color) {
        super(color);
    }

    /**
     * @return symbol of chess piece King- "K"
     */
    @Override
    public String getSymbol() {
        return "K";
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
        if (canMoveAsKing(startLine, startColumn, endLine, endColumn, chessBoard)) return true;

        return false;
    }

    /**
     * check - is move according King rules
     *
     * @param startLine
     * @param startColumn
     * @param endLine
     * @param endColumn
     * @param chessBoard
     * @return true if move is according King rules
     */
    private boolean canMoveAsKing(
            int startLine
            , int startColumn
            , int endLine
            , int endColumn
            , ChessBoard chessBoard) {

        if ((endLine == startLine + 1
                && (endColumn == startColumn - 1 || endColumn == startColumn || endColumn == startColumn + 1))

                || (endLine == startLine
                && (endColumn == startColumn - 1 || endColumn == startColumn + 1))

                || (endLine == startLine - 1
                && (endColumn == startColumn - 1 || endColumn == startColumn || endColumn == startColumn + 1))) {
            return true;
        }

        return false;
    }

    /**
     * chek - can any piece (different color) move to position (line, column)
     *
     * @param board
     * @param line
     * @param column
     * @return true if it is.
     */
    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board.board[i][j] != null
                        && !board.board[i][j].getColor().equals(color)
                        && board.board[i][j].canMoveToPosition(board, i, j, line, column)) {
                    return true;
                }
            }
        }

        return false;
    }

}
