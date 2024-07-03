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
        // input validation
        if (row >= 3 || row < 0 || col >= 3 || col < 0) {
            return false;
        }

        if (isPiecePlaced(row, col)) {
            return false;
        }
        state[row][col] = piece;
        return true;
    }

    public boolean isGameFinished() {
        // check vertical
        for (int i = 0; i < 3; i++) {
            if (state[i][0] != ' ' && (state[i][0] == state[i][1] && state[i][1] == state[i][2])) {
                return true;
            }
        }

        // check horizontal
        for (int j = 0; j < 3; j++) {
            if (state[0][0] != ' ' && (state[0][j] == state[1][j] && state[1][j] == state[2][j])) {
                return true;
            }
        }

        // check diagonal
        return (state[0][0] == state[1][1] && state[1][1] == state[2][2] && state[0][0] != ' ')
                || (state[0][2] == state[1][1] && state[1][1] == state[2][0] && state[0][2] != ' ');
    }
}
