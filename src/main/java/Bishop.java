public class Bishop extends ChessPiece{

    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getSymbol() {
        return "B";
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int startLine, int startColumn, int endLine, int endColumn) {
        if (!isStartEndDifferent(startLine, startColumn, endLine, endColumn)) return false;
        if (!isMoveInsideBoard(startLine, startColumn, endLine, endColumn)) return false;
        if (isMoveEndSameColor(endLine, endColumn, chessBoard)) return false;
        if (canMoveAsBishop(startLine, startColumn, endLine, endColumn,chessBoard)) return true;
        return false;
    }

    private boolean canMoveAsBishop(int startLine, int startColumn, int endLine, int endColumn, ChessBoard chessBoard) {

        if (!isMoveDiagonal(startLine, startColumn, endLine, endColumn)) return false;
        if (!isFieldsFree(startLine, startColumn, endLine, endColumn, chessBoard)) return false;
        return true;
    }

    private boolean isMoveDiagonal(int startLine, int startColumn, int endLine, int endColumn) {
        if (Math.abs(endLine - startLine)== Math.abs(endColumn - startColumn)){
            return true;
        }
        return false;
    }

    private boolean isFieldsFree(int startLine, int startColumn, int endLine, int endColumn, ChessBoard chessBoard) {
        int countOfSteps = Math.abs(endLine - startLine);
        int lineStep= (endLine - startLine)/countOfSteps;
        int columnStep= (endColumn - startColumn)/countOfSteps;

        for (int i = 0; i < countOfSteps-1; i++) {
           if( chessBoard.board[startLine +lineStep][startColumn +columnStep] !=null){
               return false;
           }
        }
        return true;
    }
}
