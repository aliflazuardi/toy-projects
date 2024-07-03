public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Board board = new Board();
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