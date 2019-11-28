package test;
import main.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameTest {
    private int boardsize = 8;
    Board board;
    Die die;

    @Before
    public void setup() {
        board = new Board(boardsize);
        die = new Die();
    }

    @Test
    public void testBoardSize() {
        Board board = new Board(boardsize);
        Assert.assertEquals(board.getBoardsize(),boardsize);
    }

    @Test
    public void testDie() {
        Assert.assertEquals(Die.roll(), 4);
    }
}