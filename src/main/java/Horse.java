public class Horse extends ChessPiece {

    public Horse(String color) {
        super(color);
    }

    /**
     * @return symbol of chess piece Hores- "H"
     */
    @Override
    public String getSymbol() {
        return "H";
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
        if (canMoveAsHorse(startLine, startColumn, endLine, endColumn)) return true;

        return false;
    }

    /**
     * check is move diagonal and are all fields free between start position and end position
     *
     * @param startLine
     * @param startColumn
     * @param endLine
     * @param endColumn
     * @return true if move is possible according Horse move rules
     */
    private boolean canMoveAsHorse(int startLine, int startColumn, int endLine, int endColumn) {
        return endLine == startLine + 1 && endColumn == startColumn + 2 ||
                endLine == startLine + 2 && endColumn == startColumn + 1 ||
                endLine == startLine - 1 && endColumn == startColumn + 2 ||
                endLine == startLine - 2 && endColumn == startColumn + 1 ||
                endLine == startLine - 2 && endColumn == startColumn - 1 ||
                endLine == startLine - 1 && endColumn == startColumn - 2 ||
                endLine == startLine + 1 && endColumn == startColumn - 2 ||
                endLine == startLine + 2 && endColumn == startColumn - 1;
    }

}

