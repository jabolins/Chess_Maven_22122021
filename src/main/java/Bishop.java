public class Bishop extends ChessPiece {

    public Bishop(String color) {
        super(color);
    }

    /**
     * @return symbol of chess piece Bishop- "B"
     */
    @Override
    public String getSymbol() {
        return "B";
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
        if (canMoveAsBishop(startLine, startColumn, endLine, endColumn, chessBoard)) return true;
        return false;
    }

    /**
     * check - can piece move according Bishop rules
     *
     * @param startLine
     * @param startColumn
     * @param endLine
     * @param endColumn
     * @param chessBoard
     * @return true if move is possible according Bishop move rules
     */
    private boolean canMoveAsBishop(int startLine, int startColumn, int endLine, int endColumn, ChessBoard chessBoard) {

        if (!isMoveDiagonal(startLine, startColumn, endLine, endColumn)) return false;
        if (!areFieldsFree(startLine, startColumn, endLine, endColumn, chessBoard)) return false;
        return true;
    }

    /**
     * check is move diagonal
     *
     * @param startLine
     * @param startColumn
     * @param endLine
     * @param endColumn
     * @return is move diagonal
     */
    private boolean isMoveDiagonal(int startLine, int startColumn, int endLine, int endColumn) {
        if (Math.abs(endLine - startLine) == Math.abs(endColumn - startColumn)) {
            return true;
        }
        return false;
    }

    /**
     * check is all fields between start position and end position free
     *
     * @param startLine
     * @param startColumn
     * @param endLine
     * @param endColumn
     * @param chessBoard
     * @return is all fields free
     */
    private boolean areFieldsFree(
            int startLine
            , int startColumn
            , int endLine
            , int endColumn
            , ChessBoard chessBoard) {
        int countOfSteps = Math.abs(endLine - startLine);
        int lineStep = (endLine - startLine) / countOfSteps;
        int columnStep = (endColumn - startColumn) / countOfSteps;
        int currentLine = startLine;
        int currentColumn = startColumn;

        for (int i = 0; i < countOfSteps - 1; i++) {
            currentLine += lineStep;
            currentColumn += columnStep;
            if (chessBoard.board[currentLine][currentColumn] != null) {
                return false;
            }
        }
        return true;
    }
}
