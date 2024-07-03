public class Game {
    private Board board;
    private int score;

    Game() {
        board = new Board();
        score = 0;
    }

    public boolean isGameOver() {
        return board.isMovePossible();
    }

    public int getGameScore() {
        return score;
    }

    public void makeMove(String move) {
        switch (move) {
            case "RIGHT":
                moveRight();
                break;
            case "LEFT":
                moveLeft();
                break;
            case "UP":
                moveUp();
                break;
            case "DOWN":
                moveDown();
                break;
            default:
                System.out.println("Invalid move!");
        }
    }

    private void moveRight() {
        board.shiftRight();
    }

    private void moveLeft() {
        board.shiftLeft();
    }

    private void moveUp() {
        board.shiftUp();
    }

    private void moveDown() {
        board.shiftDown();
    }
}
