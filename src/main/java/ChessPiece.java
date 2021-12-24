public abstract class ChessPiece {
    String color;
    boolean check = true;

    public ChessPiece(String color) {
        this.color = color;
    }


    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int startLine, int startColumn, int endLine, int endColumn);

    public abstract String getSymbol();

    public String getColor() {
        return color;
    }

    protected boolean isMoveInsideBoard(int startLine, int startColumn, int endLine, int endColumn) {
        if (startLine < 0 || startLine > 7
                || startColumn < 0 || startColumn > 7
                || endLine < 0 || endLine > 7
                || endColumn < 0 || endColumn > 7) {
            return false;
        } else return true;
    }

    protected boolean isStartEndDifferent(int startLine, int startColumn, int endLine, int endColumn) {
        if (startLine == endLine && startColumn == endColumn) {
            return false;
        } else return true;
    }

    protected boolean isMoveEndSameColor(int endLine, int endColumn, ChessBoard chessBoard) {
        if (chessBoard.board[endLine][endColumn] != null && chessBoard.board[endLine][endColumn].getColor().equals(color)) {
            return true;
        } else return false;

    }
}
