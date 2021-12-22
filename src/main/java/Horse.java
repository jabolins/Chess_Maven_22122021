public class Horse extends ChessPiece {
    public Horse(String color) {
        super(color);
    }

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


    @Override
    public String getSymbol() {
        return "H";
    }
}
