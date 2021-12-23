public class Rook extends ChessPiece {

    public Rook(String color) {
        super(color);
    }

    @Override
    public String getSymbol() {
        return "R";
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int startLine, int startColumn, int endLine, int endColumn) {
        if (!isStartEndDifferent(startLine, startColumn, endLine, endColumn)) return false;
        if (!isMoveInsideBoard(startLine, startColumn, endLine, endColumn)) return false;
        if (isMoveEndSameColor(endLine, endColumn, chessBoard)) return false;
        if (canMoveAsRook(startLine, startColumn, endLine, endColumn,chessBoard)) return true;
        return false;
    }

    private boolean canMoveAsRook(int startLine, int startColumn, int endLine, int endColumn, ChessBoard chessBoard) {

        if (!isMoveStrightLine(startLine, startColumn, endLine, endColumn)) return false;
        if (!areFieldsFree(startLine, startColumn, endLine, endColumn, chessBoard)) return false;
        return true;
    }

    private boolean isMoveStrightLine(int startLine, int startColumn, int endLine, int endColumn) {
        if( startLine == endLine || startColumn == endColumn){
            return true;
        }
        return false;
    }

    private boolean areFieldsFree(int startLine, int startColumn, int endLine, int endColumn, ChessBoard chessBoard) {
        int countOfSteps = Math.abs((endLine - startLine) + (endColumn - startColumn));
        int lineStep= (endLine - startLine)/countOfSteps;
        int columnStep=(endColumn - startColumn)/countOfSteps;
        int currentLine= startLine;
        int currentColumn= startColumn;

        for (int i = 0; i < countOfSteps-1; i++) {
            currentLine+=lineStep;
            currentColumn+=columnStep;
            if(chessBoard.board[currentLine][currentColumn]!=null){
                return false;
            }
        }
        return true;
    }
}
