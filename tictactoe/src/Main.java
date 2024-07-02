public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Board board = new Board();
        board.printBoard();
        board.setPiece(1, 1, 'X');
        board.printBoard();
    }
}