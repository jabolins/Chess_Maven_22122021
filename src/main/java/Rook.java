public class Rook extends ChessPiece {

    public Rook(String color) {
        super(color);
    }

    /**
     * @return symbol of chess piece Rook- "R"
     */
    @Override
    public String getSymbol() {
        return "R";
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
        if (canMoveAsRook(startLine, startColumn, endLine, endColumn, chessBoard)) return true;

        return false;
    }

    /**
     * check - can piece move according Rook rules (move is straight and all positions in the way are free)
     *
     * @param startLine
     * @param startColumn
     * @param endLine
     * @param endColumn
     * @param chessBoard
     * @return true if move is possible according Rook move rules
     */
    private boolean canMoveAsRook(
            int startLine
            , int startColumn
            , int endLine
            , int endColumn
            , ChessBoard chessBoard) {
        if (!isMoveStraightLine(startLine, startColumn, endLine, endColumn)) return false;
        if (!areFieldsFree(startLine, startColumn, endLine, endColumn, chessBoard)) return false;

        return true;
    }

    /**
     * check - is move straight
     *
     * @param startLine
     * @param startColumn
     * @param endLine
     * @param endColumn
     * @return true if move is straight
     */
    private boolean isMoveStraightLine(int startLine, int startColumn, int endLine, int endColumn) {
        if (startLine == endLine || startColumn == endColumn) {
            return true;
        }

        return false;
    }

    /**
     * check- are all fields (positions) free in the way.
     *
     * @param startLine
     * @param startColumn
     * @param endLine
     * @param endColumn
     * @param chessBoard
     * @return true if fields are free.
     */
    private boolean areFieldsFree(int startLine, int startColumn, int endLine, int endColumn, ChessBoard chessBoard) {
        int countOfSteps = Math.abs((endLine - startLine) + (endColumn - startColumn));
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
