import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    void testInitBoard() {
        Board board = new Board();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(' ', board.getCellState(i, j));
            }
        }
    }

    @Test
    void testPlacePiece() {
        Board board = new Board();
        board.placePiece(1, 1, 'X');
        assertEquals('X', board.getCellState(1, 1));
    }

    @Test
    void testIsGameFinished() {
        Board board = new Board();
        board.placePiece(0, 1, 'X');
        board.placePiece(1, 1, 'X');
        assertFalse(board.isGameFinished());

        board.placePiece(2, 1, 'X');
        assertTrue(board.isGameFinished());
    }

}