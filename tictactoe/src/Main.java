import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to TicTacToe!");

        Board board = new Board();

        char symbol = 'X';
        Scanner sc = new Scanner(System.in);
        // run game until finished
        while(!board.isGameFinished()){
            if (symbol == 'X'){
                symbol = 'O';
            } else {
                symbol = 'X';
            }
            System.out.printf("%c turn to place piece\n", symbol);
            int row = sc.nextInt();
            int col = sc.nextInt();
            boolean isPlaced = board.placePiece(row, col, symbol);
            System.out.println(isPlaced);
            board.printBoard();
        }
    }
}