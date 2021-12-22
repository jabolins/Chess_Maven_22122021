public class Main {

    public static void main(String[] args) {
        ChessBoard chessBoard = new ChessBoard("Player1");
        Horse horse = new Horse("White");
        chessBoard.board[2][3]= horse;
        chessBoard.printBoard();

        System.out.println(chessBoard.board[2][3].getColor());
    }
}
