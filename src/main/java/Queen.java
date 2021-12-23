public class Queen extends ChessPiece {

    public Queen(String color) {
        super(color);
    }

    @Override
    public String getSymbol() {
        return "Q";
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int startLine, int startColumn, int endLine, int endColumn) {
        if (!isStartEndDifferent(startLine, startColumn, endLine, endColumn)) return false;
        if (!isMoveInsideBoard(startLine, startColumn, endLine, endColumn)) return false;
        if (isMoveEndSameColor(endLine, endColumn, chessBoard)) return false;
        if (canMoveAsQueen(startLine, startColumn, endLine, endColumn, chessBoard)) return true;

        return false;
    }

    private boolean canMoveAsQueen(int startLine, int startColumn, int endLine, int endColumn, ChessBoard chessBoard) {
        if (!isMoveDiagonalOrStright(startLine, startColumn, endLine, endColumn)) return false;

        if (Math.abs(endLine - startLine) == Math.abs(endColumn - startColumn)) {
            return areFieldFreeDiagonal(startLine, startColumn, endLine, endColumn, chessBoard);
        }
        if (startLine == endLine || startColumn == endColumn) {
            return areFieldsFreeStright(startLine, startColumn, endLine, endColumn, chessBoard);
        }
        return false;
    }

    private boolean isMoveDiagonalOrStright(int startLine, int startColumn, int endLine, int endColumn) {
        if (Math.abs(endLine - startLine) == Math.abs(endColumn - startColumn)
                || startLine == endLine
                || startColumn == endColumn) {
            return true;
        }
        return false;
    }

    private boolean areFieldsFreeStright(int startLine, int startColumn, int endLine, int endColumn, ChessBoard chessBoard) {
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
