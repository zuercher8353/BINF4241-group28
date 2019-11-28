package test;
import main.*;
import org.junit.*;
import org.junit.jupiter.api.BeforeEach;

public class BoardTest {
    private int boardsize = 8;
    Board board;
    Die die;

    @BeforeEach
    public void setup() {
        board = new Board(boardsize);
        die = new Die();
    }

    @Test
    public void testBoardSize() {
        Board newBoard = new Board(9);
        Assert.assertEquals(board.initSquares().length,boardsize);
        Assert.assertEquals(board.getBoardsize(),boardsize);
        Assert.assertNotEquals(newBoard.getBoardsize(),board.getBoardsize());
    }
}