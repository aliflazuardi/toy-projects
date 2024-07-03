public class Board {
    private char[][] state;

    Board() {
        state = new char[3][3];
        initBoard();
    }

    public void initBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                state[i][j] = ' ';
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.printf("%c | %c | %c\n", state[i][0], state[i][1], state[i][2]);
        }
        System.out.println();
    }

    private boolean isPiecePlaced(int row, int col) {
        return state[row][col] != ' ';
    }

    public boolean placePiece(int row, int col, char piece) {
        if (isPiecePlaced(row, col)) {
            return false;
        }
        state[row][col] = piece;
        return true;
    }
}
