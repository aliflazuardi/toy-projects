import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to TicTacToe!");

        Board board = new Board();

        char symbol = 'X';
        Scanner sc = new Scanner(System.in);
        boolean isPlaced = false;
        // run game until finished
        while(!board.isGameFinished()){
            if(isPlaced) {
                if (symbol == 'X'){
                    symbol = 'O';
                } else {
                    symbol = 'X';
                }
            }
            System.out.printf("%c turn to place piece\n", symbol);
            System.out.println("Enter row:");
            int row = sc.nextInt();
            System.out.println("Enter col:");
            int col = sc.nextInt();
            isPlaced = board.placePiece(row, col, symbol);
            board.printBoard();
        }

        System.out.println(symbol + " has won!");
    }
}