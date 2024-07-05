import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to 2048!");

        Game game = new Game();

        Scanner scanner = new Scanner(System.in);
        while (!game.isGameOver()) {
            System.out.println("Enter your move: ");
            String input = scanner.nextLine();
            game.makeMove(input);
        }

        System.out.println("Game over! Your score is: " + game.getGameScore());
    }
}