public class Queen extends ChessPiece {

    public Queen(String color) {
        super(color);
    }

    /**
     * @return symbol of chess piece Queen- "Q"
     */
    @Override
    public String getSymbol() {
        return "Q";
    }

    /**
     * @param chessBoard  can move piece according chess rules
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
        if (canMoveAsQueen(startLine, startColumn, endLine, endColumn, chessBoard)) return true;

        return false;
    }

    /**
     * check - can piece move according Queen rules (diagonal, straight and all fields in way are free)
     *
     * @param startLine
     * @param startColumn
     * @param endLine
     * @param endColumn
     * @param chessBoard
     * @return true if move is possible according Bishop move rules
     */
    private boolean canMoveAsQueen(
            int startLine
            , int startColumn
            , int endLine
            , int endColumn
            , ChessBoard chessBoard) {
        if (!isMoveDiagonalOrStraight(startLine, startColumn, endLine, endColumn)) return false;

        if (Math.abs(endLine - startLine) == Math.abs(endColumn - startColumn)) { // move is diagonal
            return areFieldFreeDiagonal(startLine, startColumn, endLine, endColumn, chessBoard);
        }
        if (startLine == endLine || startColumn == endColumn) { // move is straight
            return areFieldsFreeStraight(startLine, startColumn, endLine, endColumn, chessBoard);
        }

        return false;
    }

    /**
     * check is move diagonal or straight (Queen rules)
     *
     * @param startLine
     * @param startColumn
     * @param endLine
     * @param endColumn
     * @return true if move is according Queen rules
     */
    private boolean isMoveDiagonalOrStraight(int startLine, int startColumn, int endLine, int endColumn) {
        if (Math.abs(endLine - startLine) == Math.abs(endColumn - startColumn)
                || startLine == endLine
                || startColumn == endColumn) {
            return true;
        }

        return false;
    }

    /**
     * check- are all fields in the straight way free
     *
     * @param startLine
     * @param startColumn
     * @param endLine
     * @param endColumn
     * @param chessBoard
     * @return true if fields are free
     */
    private boolean areFieldsFreeStraight(int startLine, int startColumn, int endLine, int endColumn, ChessBoard chessBoard) {
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

    /**
     * check- are all fields in the diagonal way free
     *
     * @param startLine
     * @param startColumn
     * @param endLine
     * @param endColumn
     * @param chessBoard
     * @return true if fields are free
     */
    private boolean areFieldFreeDiagonal(int startLine, int startColumn, int endLine, int endColumn, ChessBoard chessBoard) {
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
