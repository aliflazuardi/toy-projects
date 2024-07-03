public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to TicTacToe!");

        Board board = new Board();

        // run game until finished
        while(!board.isGameFinished()){
            board.printBoard();
            boolean isPlaced = board.placePiece(1, 1, 'X');
            System.out.println(isPlaced);
            board.printBoard();
            isPlaced = board.placePiece(1, 1, 'O');
            System.out.println(isPlaced);
            board.initBoard();
            board.printBoard();
        }
    }
}