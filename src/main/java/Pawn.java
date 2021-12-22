public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getSymbol() {
        return "P";
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
        if(!correctStartPosition(startLine)) return false;
        if (canMoveAsPawn(startLine, startColumn, endLine, endColumn, chessBoard)) return true;

        return false;
    }

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
